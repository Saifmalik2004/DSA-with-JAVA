

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

      public static void main(String[] args) {
          CircularLL cll = new CircularLL();
  
          cll.addFirst(10);
          cll.addFirst(20);
          cll.addLast(30);
          cll.addLast(40);
          cll.printLL();
      }
  }
  