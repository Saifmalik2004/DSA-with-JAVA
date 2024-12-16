

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
   
    // Method to reverse the LinkedList
public void reverse() {
    // Initialize three pointers:
    // - prev: points to the previous node (starts as null)
    // - curr: points to the current node (starts as the head)
    // - next: stores the next node temporarily while reversing links
    Node prev = null;
    Node curr = head;  // Start with the head
    Node next;
    
    // Traverse the LinkedList, reversing the direction of the links
    while (curr != null) {
        next = curr.next;   // Save the next node temporarily
        curr.next = prev;   // Reverse the current node's link to point to the previous node
        prev = curr;        // Move prev to the current node
        curr = next;        // Move to the next node in the original list
    }
    
    // Once the loop completes, prev will be pointing to the new head of the reversed list
    head = prev;  // Update head to the new first node (previous tail)
}

    
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.print();
        ll.reverse();
        ll.print();
    }
}
