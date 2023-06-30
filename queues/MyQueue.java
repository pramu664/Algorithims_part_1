import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<T> implements Iterable<T> {

    // managing head and tail
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    // Node
    private class Node<T> {
        T item;
        Node<T> next;
    }

    // isEmpty, insert, pop functionality
    public boolean isEmpty() {
        return head == null;
    }

    public void insert(T item) {
        Node<T> myNode = new Node<T>();
        myNode.item = item;
        myNode.next = null;

        if (isEmpty()) {
            head = myNode;
            tail = myNode;
        }
        else {
            tail.next = myNode;
            tail = myNode;
        }

        size++;
    }

    public T pop() {
        if (!isEmpty()) {
            T item = head.item;
            head = head.next;
            return item;
        }
        else {
            throw new NoSuchElementException("Empty queue!");
        }
    }

    // Size tracking
    public int getLength() {
        return size;
    }

    // Iteration
    public Iterator<T> iterator() {
        return new MyQueueIterator();
    }

    private class MyQueueIterator implements Iterator<T> {
        private Node<T> temp = head;

        public boolean hasNext() {
            return temp != null;
        }

        public T next() {
            T item = temp.item;
            temp = temp.next;
            return item;
        }
    }

}
