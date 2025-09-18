// File 1: Basic LinkedList implementation

public class LinkedList {
    // Inner Node class for representing each element in the LinkedList
    public static class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node

        public Node(int data) {
            this.data = data; // Initialize the node with data
            this.next = null; // Set next to null by default
        }
    }

    // Static variables for the size and head/tail of the LinkedList
    public static int size; // To store the size of the LinkedList
    public static Node head; // Reference to the first node (head)
    public static Node tail; // Reference to the last node (tail)

    public static void main(String[] args) {
        System.out.println("Basic LinkedList implementation");
    }
} 
