// File 5: Adding removeFirst method to LinkedList

public class LinkedList {
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
    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return 0;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        
        Node temp = head;
        int i = 0;
        
        while (temp.next.next != null) {
            temp = temp.next;
            i++;
        }
        
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        
        return val;
    }
    public void addAtIndex(int index, int data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        if (index == 0) { 
            addFirst(data);
            return;
        } else if (index == size - 1) {
            addLast(data);
            return;
        }
    
        Node newNode = new Node(data); 
        size++;    
    
        Node temp = head; 
        int i = 0;
    
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
    
        // Insert the new node
        newNode.next = temp.next;  // Link the new node to the next node
        temp.next = newNode;       // Link the previous node to the new node
    }
    
    // Method to remove a node at a specific index in the LinkedList
public void removeAtIndex(int index) {
    // Validate the index
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Invalid index");
    }
    
    // Handle special cases for removing the first or last element
    if (index == 0) {
        removeFirst();  // Call removeFirst method to remove the first node
        return;
    } else if (index == size - 1) {
        removeLast();   // Call removeLast method to remove the last node
        return;
    }
    
    // Traverse to the node just before the target index
    Node temp = head; // Start at the head
    for (int i = 0; i < index - 1; i++) {
        temp = temp.next; // Move to the next node
    }
    
    // Remove the target node by linking the previous node to the next node
    Node nodeToRemove = temp.next; // The node to be removed
    temp.next = nodeToRemove.next; // Bypass the node to remove
    nodeToRemove.next = null;     // Optional: Clean up the removed node
    
    // Decrease the size of the list
    size--;
}


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.print();
        ll.removeAtIndex(3);
        
        ll.print();
    }
}
