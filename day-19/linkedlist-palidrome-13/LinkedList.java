

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
   //methode to reverse a linked list
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
    
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
    }
   // Method to find the middle node of the LinkedList
public Node findMid(Node head) {
    // Initialize two pointers: fast and slow
    Node fast = head;
    Node slow = head;
    
    // Traverse the list with fast and slow pointers
    // Fast pointer moves two steps at a time, slow pointer moves one step
    while (fast != null && fast.next != null) {
        slow = slow.next;        // Move slow pointer one step
        fast = fast.next.next;   // Move fast pointer two steps
    }
    
    // When the fast pointer reaches the end, the slow pointer will be at the middle
    return slow;
}

   // Method to check if the LinkedList is a palindrome or not
public boolean checkPalindrome() {
    // If the list is empty or has only one element, it's a palindrome
    if (head == null || head.next == null) {
        return true;
    }
    
    // Step 1: Find the middle node using the findMid method
    Node prev = null;
    Node curr = findMid(head); // The middle node becomes the starting point of the second half of the list
    Node next;
    
    // Step 2: Reverse the second half of the list starting from the middle node
    while (curr != null) {
        next = curr.next;      // Save the next node
        curr.next = prev;      // Reverse the current node's next pointer
        prev = curr;           // Move prev to the current node
        curr = next;           // Move to the next node
    }
    
    // Step 3: Compare the first and second halves of the list
    Node left = head;  // Pointer to the start of the list (first half)
    Node right = prev; // Pointer to the start of the reversed second half
    
    // Traverse both halves and compare the nodes
    while (right != null) {  // Only need to check the second half (right side)
        if (left.data != right.data) {  // If data doesn't match, it's not a palindrome
            return false;
        }
        left = left.next;   // Move to the next node in the first half
        right = right.next; // Move to the next node in the second half
    }
    
    // If all nodes matched, the list is a palindrome
    return true;
}

    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
       
        ll.addFirst(20);
        ll.addLast(30);
        ll.addLast(30);
        ll.addFirst(20);

        ll.print();
        System.out.println(ll.checkPalindrome());
        ll.print();
    }
}
