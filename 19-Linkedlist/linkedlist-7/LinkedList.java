

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
    // Method to remove the last node of the LinkedList

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
    
    // Method to add a node at a specific index in the LinkedList
    
public void addAtIndex(int index, int data) {
    // Check if the index is valid; if not, throw an exception
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Invalid index");
    }
    
    // If the index is 0, call addFirst to add the node at the beginning
    if (index == 0) { 
        addFirst(data);
        return;
    }
    // If the index is the last position, call addLast to add the node at the end
    else if (index == size - 1) {
        addLast(data);
        return;
    }
    
    // Create a new node to insert at the given index
    Node newNode = new Node(data); 
    size++;  // Increment the size of the list
    
    // Traverse the list to find the node just before the specified index
    Node temp = head; 
    int i = 0;
    
    // Traverse until the node before the target index
    while (i < index - 1) {
        temp = temp.next;
        i++;
    }
    
    // Insert the new node at the desired position
    newNode.next = temp.next;  // Link the new node to the next node
    temp.next = newNode;       // Link the previous node to the new node
}

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.print();
        ll.addAtIndex(3, 3);
        
        ll.print();
    }
}
