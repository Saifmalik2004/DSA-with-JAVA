

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

// Method to delete the nth node from the end of the LinkedList
public void deleteNthFromLast(int n) {
    int sz = 0;  // Variable to store the size of the list
    Node temp = head;
    
    // Calculate the size of the list
    while (temp != null) {
        temp = temp.next;
        sz++;
    }
    
    // If the node to remove is the head (n == sz), update head to the next node
    if (n == sz) {
        head = head.next;
        return;
    }
    
    // Traverse to the (sz - n)th node, which is the node just before the node to remove
    int i = 1;
    Node prev = head;
    while (i < sz - n) {
        prev = prev.next;  // Move to the next node
        i++;
    }
    
    // Remove the nth node from the end by linking the previous node to the node after it
    prev.next = prev.next.next;
    
    // Decrease the size of the list
    size--;
}

    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.print();
        ll.deleteNthFromLast(2);
        ll.print();
    }
}
