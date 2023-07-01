import java.util.NoSuchElementException;

public class Deque {
    private Node head;
    private Node tail;
    private int size;

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
        tail = null;
        size = 0;
    }

    // Check deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Add item to the top
    public void addFirst(String item) {
        if (item == null) throw new IllegalArgumentException("Invalid item!");
        Node newNode = new Node(item);
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
    public void addLast(String item) {
        if (item == null) throw new IllegalArgumentException("Invalid item!");
        Node newNode = new Node(item);

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
    public String removeFirst() {
        if (head != null) {
            String item = head.item;
            head = head.next;
            size--;
            return item;
        }
        else {
            throw new NoSuchElementException("Empty deque!");
        }
    }

    // Remove item from the last
    public String removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("Empty deque!");
        }
        else {
            Node temp = head;
            for (int i = 0; i < this.getSize() - 2; i++) {
                temp = temp.next;
            }
            String item = tail.item;
            tail = temp;
            temp.next = null;
            size--;
            return item;
        }

    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        // Test client
        Deque myList = new Deque();
        myList.addFirst("Harry");
        myList.addFirst("Hermione");
        myList.addFirst("Ron");
        // head -> Ron -> Hermione -> Harry <- Tail
        myList.removeLast();
    }
}
