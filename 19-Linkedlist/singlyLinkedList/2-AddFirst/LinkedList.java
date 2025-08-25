

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

    private void addLast(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    private int removeFirst() {

        if (head == null) {
            System.err.println("No element");
            return -1;
        } else if (head.next == null) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;

    }

    private int removeLast() {

        if (head == null) {
            System.err.println("No element");
            return -1;
        } else if (head.next == null) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;

    }

    private int remove(int data) {

        if (head == null) {
            System.err.println("No element");
            return -1;
        }

        if (head.data == data) {
            int val = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return val;
        }

        Node temp = head;
        while (temp.next.data != data && temp.next != null) {
            temp = temp.next;

        }

        if (temp.next == null) {
            System.out.println("element not found");
            return -1;
        }

        int val = temp.next.data;
        temp.next = temp.next.next;

        if (temp.next == null) {
            tail = temp;
        }
        size--;
        return val;

    }

    private void print() {

        if (head == null) {
            System.err.println("No element");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;

        }
        System.out.println("null");

    }

    private void addNodeAt(int idx, int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        if (idx <= 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        if (idx >= size) {
            tail.next = newNode;
            tail = newNode;
            size++;
            return;
        }

        int i = 1;
        Node temp = head;
        while (i < idx) {
            temp = temp.next;
            i++;

        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;

    }

    private void removeNodeAt(int idx) {

        if (idx < 0 || idx >= size) {
            System.err.println("invalid index");
            return;
        }
        if (idx == 0) {
            head = head.next;
            size--;

            if (head == null) {
                tail = null;
            }
            return;
        }

        int i = 1;
        Node temp = head;
        while (i < idx) {
            temp = temp.next;
            i++;

        }

        temp.next = temp.next.next;
        if (temp.next == null) {
            tail = temp;
        }
        size--;

    }

    private int valueAt(int idx) {

        if (idx < 0 || idx >= size) {
            System.err.println("invalid index");
            return -1;
        }
        if (idx == size-1) {
            return tail.data;
        }

        int i = 0;
        Node temp = head;
        while (i < idx) {
            temp = temp.next;
            i++;

        }

        return temp.data;
       

    }

     private boolean contains(int data) {

        if (data == tail.data) {
            return true;
        }

        
        Node temp = head;
        while (temp != null &&data != temp.data) {
            temp = temp.next;
        }
        if(temp==null) return false;

        return true;
       

    }

    private int length() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void deleteNthNodefromlast(int n){

        if(head==null){
            System.out.println("nothing to delete");
            return;
        }
        Node temp=head;
        int s=0;

        while(temp!=null){
           temp= temp.next;
           s++;
        }
        
        if(n<=0 || n>s){
            System.out.println("invalid index");
            return;
        }

        if(size==n){
            head=head.next;
            if(head==null) tail=null;
            size--;
            return;
        }

        temp=head;
        while(s>n+1){
           temp= temp.next;
           s--;
        }
        temp.next=temp.next.next;
        if(temp.next==null) tail=temp;
        size--;


    }

    private void deleteNNodefromlast(int idx){

        if(head==null){
            System.out.println("nothing to delete");
            return;
        }
        Node temp=head;
        int s=0;

        while(temp!=null){
           temp= temp.next;
           s++;
        }
        
        if(idx<=0 || idx>s){
            System.out.println("invalid index");
            return;
        }

        if(size==idx){
            head=tail=null;
            size-=idx;
            return;
        }

        temp=head;
        while(s>idx+1){
           temp= temp.next;
           s--;
        }
        temp.next=null;
        tail=temp;
        
        size-=idx;


    }

    private void reverse(){
        Node prev=null;
        Node curr=head;
        Node next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;

    }

     private boolean palindrome(){
       
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        Node prev=null;
        Node curr=slow;
        Node next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node head1=head;
        Node head2 =prev;

        while(head2!=null){
            if(head1.data!=head2.data){
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }

        return true;


    }

    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); // Create a new LinkedList object
        System.out.println(ll.isEmpty());
        ll.addLast(30); //0
        ll.addLast(0); //1
        ll.addLast(40);//2
        ll.addLast(30);//3
        ll.print();
        System.out.println(ll.palindrome());
        
        System.out.println("Nodes added at the beginning of the LinkedList");
    }
}
