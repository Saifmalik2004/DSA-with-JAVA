

public class CircularLL {
    public static class Node {
          int data;
          Node next;
      
         public Node(int data) {
              this.data = data;
              this.next = null;
          }
      }
      public static Node head;
      public static Node tail;
      public static int size;
       // 1. Add First
       public void addFirst(int data) {
          Node newNode = new Node(data);
          if (head == null) {
              // List is empty, point new node to itself
              head = newNode;
              tail = newNode;
              newNode.next = head;
          } else {
              // Insert at the beginning
              newNode.next = head;
              head = newNode;
              tail.next = head; // Update tail's next to point to the new head
          }
      }
       // 2. Add Last
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // List is empty, new node becomes head and tail
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            // Insert at the end
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Tail points back to head
        }
    }
    // 5. Print Circular Linked List
    public void printLL() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }
     // 3. Remove First
     public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (head == tail) {
            // Only one node
            head = null;
            tail = null;
        } else {
            head = head.next; // Move head forward
            tail.next = head; // Update tail's next
        }
    }

    // 4. Remove Last
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (head == tail) {
            // Only one node
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next; // Traverse to second-last node
            }
            current.next = head; // Update second-last node's next to head
            tail = current; // Update tail
        }
    }

    
// 6. Search for a Value
public boolean search(int key) {
    if (head == null) {
        return false;
    }
    Node current = head;
    do {
        if (current.data == key) {
            return true;
        }
        current = current.next;
    } while (current != head);
    return false;
}
public void reverse() {
    if (head == null || head.next == head) {
        // List is empty or has only one node
        return;
    }

    Node prev = null;       // To track the previous node
    Node current = head;    // Start from the head
    Node next = null;       // To temporarily store next node
    Node oldHead = head;    // Keep track of the old head

    // Traverse the list and reverse the pointers
    do {
        next = current.next;  // Store the next node
        current.next = prev;  // Reverse the current node's pointer
        prev = current;       // Move prev one step ahead
        current = next;       // Move current one step ahead
    } while (current != head);

    // Adjust the head and tail
    tail = oldHead;       // The old head becomes the new tail
    tail.next = prev;     // Tail's next points to the new head
    head = prev;          // The new head is the last node
}

      public static void main(String[] args) {
          CircularLL cll = new CircularLL();
         

          cll.addFirst(10);
          cll.addLast(20);
          cll.addLast(30);
          cll.printLL(); // 20 -> 10 -> 30 -> (head)
        cll.reverse();
        cll.printLL();//  30 -> 20 -> 10 -> (head)
      }
  }
 