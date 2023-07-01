import java.util.NoSuchElementException;

public class Deque {
    private Node head;

    private class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
            this.next = null;
        }

    }

    // Create empty deque
    public Deque() {
        head = null;
    }

    // Check deque is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Add item to the top
    public void addFirst(String item) {
        if (item == null) throw new IllegalArgumentException("Empty value!");
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Remove item from the top
    public String removeFirst() {
        if (head != null) {
            String item = head.item;
            head = head.next;
            return item;
        }
        else {
            throw new NoSuchElementException("Empty deque!");
        }
    }

    public static void main(String[] args) {
        // Test client
        Deque myList = new Deque();
        myList.removeFirst();
    }
}
