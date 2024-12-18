public class LinkedList {
    // Node class representing each element in the linked list
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // LinkedList attributes
    public static int size;  // Tracks the size of the LinkedList
    public static Node head; // Reference to the head node
    public static Node tail; // Reference to the tail node

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
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to remove the first node of the LinkedList
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return -1;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Method to remove the last node of the LinkedList
    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return -1;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        Node temp = head;
        // Traverse to the second last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    // Method to search for a value in the LinkedList
    public int contain(int key) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data == key) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Key not found
    }

    // Method to skip M nodes and delete N nodes in the LinkedList
    public void skipMdeleteN(Node head, int m, int n) {
        Node current = head; // Start from the head of the list
        Node temp;           // Temporary reference to nodes being deleted
        int count;

        // Traverse the LinkedList
        while (current != null) {
            // Skip M nodes
            for (count = 1; count < m && current != null; count++) {
                current = current.next;
            }

            // If we've reached the end, exit the loop
            if (current == null) {
                return;
            }

            // Start deleting N nodes
            temp = current.next;
            for (count = 1; count <= n && temp != null; count++) {
                Node toDelete = temp;
                temp = temp.next;
            }

            // Connect the current node to the remaining list
            current.next = temp;

            // Move current to the next part of the list
            current = temp;
        }
    }

    // Main method to test the LinkedList
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Adding elements to the LinkedList
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(10);

        

        int m = 3, n = 2; // Parameters for skipping and deleting
        System.out.println("m = " + m + ", n = " + n);

        // Apply skip M and delete N operation
        ll.skipMdeleteN(head, m, n);

        // Print the updated LinkedList
        ll.print();
    }
}
