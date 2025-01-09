// File 5: Adding removeFirst method to LinkedList

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

    // Method to remove the first node of the LinkedList
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return -1;
        } else if (size == 1) {
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
    // Method to remove the last node of the LinkedList

    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return 0;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        
        Node temp = head;
        int i = 0;
        
        while (temp.next.next != null) {
            temp = temp.next;
            i++;
        }
        
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        
        return val;
    }
    // Method to add  node at the index  of the LinkedList

    public void addAtIndex(int index, int data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        if (index == 0) { 
            addFirst(data);
            return;
        } else if (index == size - 1) {
            addLast(data);
            return;
        }
    
        Node newNode = new Node(data); 
        size++;    
    
        Node temp = head; 
        int i = 0;
    
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
    
       
        newNode.next = temp.next;
        temp.next = newNode;       
    }
    public void removeAtIndex(int index) {
       
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
       
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }
        
       
        Node temp = head; 
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next; 
        }
        
       
        Node nodeToRemove = temp.next; 
        temp.next = nodeToRemove.next; 
        nodeToRemove.next = null;     
        
       
        size--;
    }
    
    //method to search in a list
    public int contain(int key) {
        Node prev = head;
        int i = 0;
    
        while (prev != null) {
            if (prev.data == key) {
                return i;
            }
            prev = prev.next;
            i++;
        }
    
        return -1;
    }
    public boolean detectCycle(){
        Node slow=head;
        Node fast=head;

        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }

        return false;
    }
    //remove cycle
    public void removeCycle(){
        Node slow=head;
        Node fast=head;
        boolean hasCycle=false;
        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                hasCycle=true;
                break;
            }
        }

        if(hasCycle==false){
            return;
        }

        slow=head;
        Node prev=null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
       
         prev.next=null;
       
       
    }



    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
      
        head=new Node(1);
        Node temp=new Node(2);
        head.next=temp;
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=temp;



       
    
        if (ll.detectCycle()) {
            System.out.println("The LinkedList contains a cycle.");
        } else {
            System.out.println("The LinkedList does not contain a cycle.");
        }

        ll.removeCycle();

        if (ll.detectCycle()) {
            System.out.println("The LinkedList contains a cycle.");
        } else {
            System.out.println("The LinkedList does not contain a cycle.");
        }

        ll.print();
       
     
    }
}
