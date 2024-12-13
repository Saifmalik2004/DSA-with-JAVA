// File 3: Adding addLast method to LinkedList

public class LinkedList {
    // Inner Node class for representing each element in the LinkedList
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int size;
    public static Node head;
    public static Node tail;

    // Method to add a node at the beginning of the LinkedList
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Method to add a node at the end of the LinkedList
    public void addLast(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        size++; // Increment size of the LinkedList
        if (head == null) {
            head = tail = newNode; // If the list is empty, both head and tail point to the new node
            return;
        }
        tail.next = newNode; // Link the current tail to the new node
        tail = newNode; // Update the tail reference to the new node
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); // Create a new LinkedList object
        ll.addFirst(10); // Add 10 at the beginning
        ll.addFirst(20); // Add 20 at the beginning
        ll.addLast(30); // Add 30 at the end
        ll.addLast(40); // Add 40 at the end
        System.out.println("Nodes added at the beginning and end of the LinkedList");
    }
}
