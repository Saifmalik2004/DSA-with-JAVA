

public class LinkedList {

    // Inner Node class for representing each element in the LinkedList
    public class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private int size;
    private Node head;
    private Node tail;

    private void addFirst(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;

    }

    
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); // Create a new LinkedList object
       
        ll.addFirst(30); //0
        ll.addFirst(40); //
       
        
        System.out.println("Nodes added at the beginning of the LinkedList");
    }
}
