

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
    public static void main(String[] args) {
        CircularLL cll = new CircularLL();

        cll.addFirst(10);
        cll.addFirst(20);
        
    }
}
