import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<T> implements Iterable<T> {

    private class Node<T> {
        T item;
        Node<T> next;
    }

    private Node<T> head = null;

    boolean isEmpty() {
        return head == null;
    }

    void insert(T item) {
        Node<T> myNode = new Node<T>();
        myNode.item = item;
        if (this.isEmpty()) {
            head = myNode;
        }
        else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = myNode;
        }
    }

    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private Node<T> temp = head;

        public boolean hasNext() {
            return temp != null;
        }

        public T next() {
            if (hasNext()) {
                T item = temp.item;
                temp = temp.next;
                return item;
            }
            else {
                throw new NoSuchElementException("No element!");
            }
        }
    }

    public static void main(String[] args) {
        MyList<String> gryffindor = new MyList<String>();
        gryffindor.insert("Harry");
        gryffindor.insert("Hermione");
        gryffindor.insert("Ron");

        for (String name : gryffindor) {
            StdOut.println(name);
        }

    }
}
