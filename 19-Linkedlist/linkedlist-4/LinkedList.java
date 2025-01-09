// File 4: Adding print method to LinkedList

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
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Method to print the LinkedList
    public void print() {
        if (head == null) { // Check if the list is empty
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head; // Start from the head
        while (temp != null) {
            System.out.print(temp.data + " --> "); // Print the node data
            temp = temp.next; // Move to the next node
        }
        System.out.println("null"); // End of the LinkedList
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); // Create a new LinkedList object
        ll.addFirst(10); // Add 10 at the beginning
        ll.addFirst(20); // Add 20 at the beginning
        ll.addLast(30); // Add 30 at the end
        ll.addLast(40); // Add 40 at the end
        ll.print(); // Print the entire LinkedList
    }
}
