// File 2: Adding addFirst method to LinkedList

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
        Node newNode = new Node(data); // Create a new node with the given data
        size++; // Increment size of the LinkedList
        if (head == null) {
            head = tail = newNode; // If the list is empty, both head and tail point to the new node
            return;
        }
        newNode.next = head; // Link the new node to the current head
        head = newNode; // Set the new node as the head of the list
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); // Create a new LinkedList object
        ll.addFirst(10); // Add 10 at the beginning
        ll.addFirst(20); // Add 20 at the beginning
        System.out.println("Nodes added at the beginning of the LinkedList");
    }
}
