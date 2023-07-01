import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private class Node<T> {
        T item;
        Node<T> next;

        public Node(T item) {
            this.item = item;
            this.next = null;
        }

    }

    // Create empty deque
    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    // Check deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Add item to the top
    public void addFirst(T item) {
        if (item == null) throw new IllegalArgumentException("Invalid item!");
        Node<T> newNode = new Node<T>(item);
        if (head == null) {
            head = newNode;
            tail = head;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Add item to the last
    public void addLast(T item) {
        if (item == null) throw new IllegalArgumentException("Invalid item!");
        Node<T> newNode = new Node<T>(item);

        if (head == null) {
            head = newNode;
            tail = head;
            size++;
            return;
        }

        tail.next = newNode;
        tail = tail.next;
        size++;
    }

    // Remove item from the top
    public T removeFirst() {
        if (head != null) {
            T item = head.item;
            head = head.next;
            size--;
            return item;
        }
        else {
            throw new NoSuchElementException("Empty deque!");
        }
    }

    // Remove item from the last
    public T removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("Empty deque!");
        }
        else {
            Node<T> temp = head;
            for (int i = 0; i < this.getSize() - 2; i++) {
                temp = temp.next;
            }
            T item = tail.item;
            tail = temp;
            temp.next = null;
            size--;
            return item;
        }

    }

    public int getSize() {
        return size;
    }

    // Iterator
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {
        private Node<T> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (hasNext()) {
                T item = current.item;
                current = current.next;
                return item;
            }
            else {
                throw new NoSuchElementException("Empty!");
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Not implemented!");
        }
    }

    public static void main(String[] args) {
        // Test client
        Deque<String> myList = new Deque<String>();
        myList.addFirst("Harry");
        myList.addFirst("Hermione");
        myList.addFirst("Ron");
        // head -> Ron -> Hermione -> Harry <- Tail

        for (String name : myList) {
            StdOut.println(name);
        }
    }
}
