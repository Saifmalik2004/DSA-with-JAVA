
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
    
   public void sort() {
    Node zero = new Node(-1);
    Node tempZ = zero;
    Node one = new Node(-1);
    Node tempO = one;
    Node two = new Node(-1);
    Node tempT = two;
    Node temp = head;

    while (temp != null) {
        if (temp.data == 0) {
            tempZ.next = temp;
            tempZ = tempZ.next;
        } else if (temp.data == 1) {
            tempO.next = temp;
            tempO = tempO.next;
        } else {
            tempT.next = temp;
            tempT = tempT.next;
        }
        temp = temp.next;
    }

    // Connect three lists
    tempZ.next = (one.next != null) ? one.next : two.next;
    tempO.next = two.next;
    tempT.next = null; // very important to avoid cycle

    head = zero.next;
}
  public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(0);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(0);
        ll.addLast(0);

        ll.print();
        ll.sort();
        ll.print();
        
    }
}
