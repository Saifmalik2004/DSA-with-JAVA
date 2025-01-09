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
    
    public void swapNodes(int x, int y) {
        if (x == y) 
            return; // No need to swap if the values are the same
    
        Node prevX = null, currX = head;
    
        // Find node with data x
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }
    
        Node prevY = null, currY = head;
    
        // Find node with data y
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }
    
        // If either x or y is not found, no swap is possible
        if (currX == null || currY == null) 
            return;
    
        // If x is not the head, update the previous node's next pointer
        if (prevX != null) 
            prevX.next = currY;
        else 
            head = currY; // If x is the head, update the head to y
    
        // If y is not the head, update the previous node's next pointer
        if (prevY != null) 
            prevY.next = currX;
        else 
            head = currX; // If y is the head, update the head to x
    
        // Swap the next pointers of x and y
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    
     // Main method to test the LinkedList
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Adding elements to the LinkedList
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        

        
        ll.print();

        ll.swapNodes(2, 3);
       

        // Print the updated LinkedList
        ll.print();
    }
}