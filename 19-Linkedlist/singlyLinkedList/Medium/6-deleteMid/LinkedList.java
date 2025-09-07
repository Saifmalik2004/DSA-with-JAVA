
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
    
    // Method to add a node at the beginning of the LinkedList
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

    // Method to add a node at the end of the LinkedList
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
    // Remove first node
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return -1;
        } else if (size == 1) {
            int val = head.data;
            head = null;
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
            head = null;
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
     public void deleteMiddle() {
        Node fast=head;
        Node slow=head;
        if(fast.next==null){
            return ;
        }

        if(fast.next.next==null){
            head.next=null;
            return ;
        }

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        

        if(slow.next!=null){
        slow.data=slow.next.data;
        slow.next=slow.next.next;
        }

        
    }
    
  public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);


        ll.print();
      ll.deleteMiddle();
        ll.print();
        
    }
}
