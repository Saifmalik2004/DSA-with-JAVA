



public class LinkedList {
    public  static class Node{
        int data;
        Node next;

        public Node (int data){
            this.data=data;
            this.next=null;
        }
    }
    public static int size;
    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head =tail=newNode;
            return;
        }

        newNode.next=head;

        head=newNode;
       


    }
    public void addlast(int data){
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head =tail=newNode;
            return;
        }

        tail.next=newNode;

        tail=newNode;
        
        

    }
    public int removeFirst(){
        
        
        if(size==0){
            System.out.println("liked list is empty");
            return 0;
        }else if(size==1){
              int val=head.data;
              head=tail=null;
              size--;
              return val;
        }
        
        int val=head.data;
        head=head.next;
        size--;
        return val;


       
        
        

    }
    public int removeLast(){
        
        
        if(size==0){
            System.out.println("liked list is empty");
            return 0;
        }else if(size==1){
              int val=head.data;
              head=tail=null;
              size--;
              return val;
        }
        Node temp=head;
        int i=0;
        while(temp.next.next !=null){
            temp=temp.next;
            i++;
        }
        int val=temp.next.data;
        temp.next=null;
        tail=temp;
        size--;
        return val;


       
        
        

    }
    
    public void print(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return;
        }
       Node temp=head;
        while(temp !=null){
           
            System.out.print(temp.data+"-->");

            temp=temp.next;

        }
        System.out.println("null");



    }
    
    public void addAtIndex(int index, int data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        if (index == 0) { 
           addFirst(data);
           return;
        }else if(index==size-1){
            addlast(data);
            return;
        }
        Node newNode = new Node(data); 
        size++;    

        Node temp = head; 
    

        int i=0;
        while(i<index-1 ){
            temp=temp.next;
            i++;
        }
    
       
    
        // Step 4: Insert the new node
        newNode.next = temp.next; // Link the new node to the next node
        temp.next = newNode;  // Link the previous node to the new node
    }
    public void removeAtIndex(int index) {
        // Step 1: Validate the index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        // Step 2: Handle special cases for removing the first or last element
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }
        
        // Step 3: Traverse to the node before the target index
        Node temp = head; // Start at the head
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next; // Move to the next node
        }
        
        // Step 4: Remove the target node
        Node nodeToRemove = temp.next; // The node to be removed
        temp.next = nodeToRemove.next; // Bypass the node to remove
        nodeToRemove.next = null; // Optional: Clean up the removed node
        
        // Step 5: Update the size of the list
        size--;
    }

    public int contain(int key){
         Node prev=head;
         int i=0;
        while (prev !=null) {
            
            if(prev.data==key){
                return i;
            }
            prev=prev.next;
            i++;
        }
        return -1;
    }
    public void deleteNthFromLast(int n){
        int sz=0;
        Node temp=head;
        while(temp !=null){
            temp=temp.next;
            sz++;
        }

        if(n==sz){
            head=head.next;
            return;
        }

        int i=1;
        Node prev=head;
        while(i<sz-n){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        size--;
        

   }

    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }

        if(head.data==key){
            return 0;

        }

        int idx=helper(head.next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;


    }
    public int RecSearch(int key){
        return helper(head,key);
    }

    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;

        while(curr != null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;


    }
    public Node findMid(Node head){
        Node fast=head;
        Node slow=head;

        while(fast !=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true;
        }

        Node prev=null;
        Node curr=findMid(head);
        Node next;

        while(curr !=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
         
        Node left=head;
        Node right=prev;

        while(right !=null){
            if(left.data !=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        

        return true;
    }
    
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        
        System.out.println("size="+size);

        ll.addFirst(1);
        ll.addlast(2);
        ll.addlast(2);
        ll.addlast(9);
        
        
        ll.print();
        System.out.println("size="+size);
        System.out.println(ll.checkPalindrome());
          

    }
}
