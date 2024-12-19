public class DoublyLL {
    public static class Node {
        Node prev;
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Method to add a node at the beginning of the LinkedList
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public void printDLL() {
        if (head == null) {
            System.err.println("Linked list is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<--->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
    public int removeFirst() {
        if (head == null) {
            System.out.println("Nothing to delete in the list");
            return -1; // Return a sentinel value
        }

        size--;
        int val = head.data;
        if (head.next == null) {
            head = tail = null;
            return val;
        }

        head = head.next;
        head.prev = null;
        return val;
    }

    public int removeLast() {
        if (tail == null) {
            System.out.println("Nothing to delete in the list");
            return -1; // Return a sentinel value
        }

        size--;
        int val = tail.data;
        if (tail.prev == null) {
            head = tail = null;
            return val;
        }

        tail = tail.prev;
        tail.next = null;
        return val;
    }
    public int search(int target) {
        if (head == null) {
            System.out.println("List is empty.");
            return -1; // Return -1 to indicate that the element is not found
        }
    
        Node start = head; // Pointer starting from the head
        Node end = tail;   // Pointer starting from the tail
        int startPos = 0;  // Position tracker for the start pointer
        int endPos = size - 1; // Position tracker for the end pointer
    
        // Traverse from both ends towards the middle
        while (startPos <= endPos) {
            if (start.data == target) {
                return startPos; // Target found at start pointer
            }
            if (end.data == target) {
                return endPos; // Target found at end pointer
            }
    
            start = start.next; // Move start pointer forward
            end = end.prev;     // Move end pointer backward
            startPos++;         // Increment start position
            endPos--;           // Decrement end position
        }
    
        // If we exit the loop, the element is not in the list
        System.out.println("Element not found in the list.");
        return -1; // Return -1 to indicate that the element is not found
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
        curr.next = prev; 
        curr.prev=next;  // Reverse the current node's link to point to the previous node
        prev = curr;        // Move prev to the current node
        curr = next;        // Move to the next node in the original list
    }
    
    // Once the loop completes, prev will be pointing to the new head of the reversed list
    head = prev;  // Update head to the new first node (previous tail)
}

    

    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addLast(2);
        ll.addLast(3);

        System.out.println("Size: " + ll.getSize());
        ll.printDLL();

        System.out.println("Deleted = " + ll.removeFirst());
        System.out.println("Deleted = " + ll.removeFirst());

        System.out.println("Size: " + ll.getSize());
        ll.printDLL();

        System.out.println("Deleted = " + ll.removeLast());
        System.out.println("Size: " + ll.getSize());
        ll.printDLL();
        ll.addLast(2);
        ll.addLast(3);

        System.out.println(ll.search(3));
        ll.printDLL();
        ll.reverse();
        System.out.println(ll.getSize());
        ll.printDLL();

    }
}
