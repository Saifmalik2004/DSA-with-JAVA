

public class DoublyLL {
    public static class Node{
        Node prev;
        int  data;
        Node next;
        
       public Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public static void main(String[] args) {
        System.out.println("Basic LinkedList implementation");
    }
}
