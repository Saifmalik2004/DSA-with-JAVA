public class DoublyLL {
    public static class Node {
        Node prev;
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Method to add a node at the beginning of the LinkedList
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    

    public void printDLL() {
        if (head == null) {
            System.err.println("Linked list is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<--->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    
    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();
        ll.addFirst(10);
        ll.addFirst(20);
        
        ll.printDLL();

       
    }
}
