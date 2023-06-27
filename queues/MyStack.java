import java.util.NoSuchElementException;

public class MyStack<T> {

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

    public static void main(String[] args) {
        // Test client
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(12);
        stack.push(13);
        stack.push(14);
    }
}
