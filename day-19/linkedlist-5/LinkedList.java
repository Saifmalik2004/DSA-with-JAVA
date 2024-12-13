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
    // If the LinkedList is empty, return -1 indicating no element to remove
    if (size == 0) {
        System.out.println("LinkedList is empty");
        return -1;
    }
    // If there is only one node in the LinkedList
    else if (size == 1) {
        // Save the data of the node to return it
        int val = head.data;
        // Set head and tail to null as the list will be empty after removal
        head = tail = null;
        // Decrease the size of the list
        size--;
        return val;
    }
    // If there are more than one node in the LinkedList
    // Save the data of the node to return it
    int val = head.data;
    // Move the head to the next node
    head = head.next;
    // Decrease the size of the list
    size--;
    return val;
}

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.print();

        System.out.println("Removed: " + ll.removeFirst());
        ll.print();
    }
}
