

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
    
    // Helper method to recursively search for the key in the LinkedList
public int helper(Node head, int key) {
    // Base case: if the current node is null, return -1 (key not found)
    if (head == null) {
        return -1;
    }

    // If the current node's data matches the key, return 0 (found at this position)
    if (head.data == key) {
        return 0;
    }

    // Recursive case: search in the rest of the list (head.next)
    int idx = helper(head.next, key);

    // If key was not found in the rest of the list, return -1
    if (idx == -1) {
        return -1;
    }

    // If the key was found, add 1 to the index to account for the current node
    return idx + 1;
}

// Public method to search for the key in the LinkedList starting from the head
public int RecSearch(int key) {
    return helper(head, key);  // Call the helper method with the head node and the key
}

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.print();
        System.out.println("at index = "+ll.RecSearch(30));
    }
}
