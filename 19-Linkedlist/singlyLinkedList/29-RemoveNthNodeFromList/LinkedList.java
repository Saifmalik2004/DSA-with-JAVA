
public class LinkedList {

    // Node class
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static int size;
    private static Node head;

    // Add node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head  = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add node at the end
    public void addLast(int data) {
         Node newNode = new Node(data);
        size++;
        if(head==null) {
            head=newNode;
            return;
        }
        Node temp=head;
        while (temp.next != null) {
            temp=temp.next;
        }
        temp.next = newNode;
    }

    // Print LinkedList
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

    // Remove first node
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return -1;
        } else if (size == 1) {
            int val = head.data;
            head  = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Remove last node
    public int removeLast() {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return -1;
        } else if (size == 1) {
            int val = head.data;
            head  = null;
            size--;
            return val;
        }

        Node temp = head;
        while (temp.next.next != null) { // stop at second-last node
            temp = temp.next;
        }

        int val = temp.next.data;
        temp.next = null;
        size--;

        return val;
    }
    
    //remove nth from end
    public Node removeNthFromEnd(int n) {

        Node dummy=new Node(0);
        dummy.next=head;
        Node slow=dummy;
        Node fast=dummy;
        int i=0;

        while(i<=n){
           fast= fast.next;
           i++;
        }

        while(fast!=null){
           fast= fast.next;
           slow= slow.next;
           
        }
        slow.next=slow.next.next;
        return dummy.next;
        
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.removeNthFromEnd(2);//remove 2
        ll.print();
    }
}
