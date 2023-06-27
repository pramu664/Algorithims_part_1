import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> implements Iterable<T> {

    private Node<T> head = null;

    private class Node<T> {
        T item;
        Node<T> next;
    }

    public void push(T i) {
        Node<T> temp = new Node<T>();
        temp.item = i;
        temp.next = head;
        head = temp;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }
        T item = head.item;
        head = head.next;
        return item;
    }


    // Iterator
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
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
                throw new NoSuchElementException("Stack is empty!");
            }
        }
    }


    public static void main(String[] args) {
        // Test client
        // MyStack<Integer> stack = new MyStack<Integer>();
        // stack.push(12);
        // stack.push(13);
        // stack.push(14);
        //
        // MyStack<String> names = new MyStack<String>();
        // names.push("Harry");
        // names.push("Hermione");
        // names.push("Ron");
        //
        // for (String name : names)
        //     StdOut.println(name);

    }
}
