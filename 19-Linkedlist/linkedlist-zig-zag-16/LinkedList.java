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
    
        // Insert the new node
        newNode.next = temp.next;  // Link the new node to the next node
        temp.next = newNode;       // Link the previous node to the new node
    }
    public void removeAtIndex(int index) {
        // Validate the index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        // Handle special cases for removing the first or last element
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }
        
        // Traverse to the node before the target index
        Node temp = head; // Start at the head
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next; // Move to the next node
        }
        
        // Remove the target node
        Node nodeToRemove = temp.next; // The node to be removed
        temp.next = nodeToRemove.next; // Bypass the node to remove
        nodeToRemove.next = null;     // Optional: Clean up the removed node
        
        // Update the size of the list
        size--;
    }
    
    
    // Method to check if a specific value exists in the LinkedList
public int contain(int key) {
    Node prev = head;  // Start at the head of the list
    int i = 0;         // Index of the current node
    
    // Traverse the list to find the node with the given value (key)
    while (prev != null) {
        if (prev.data == key) {
            return i;  // Return the index if the key is found
        }
        prev = prev.next;  // Move to the next node
        i++;               // Increment the index
    }
    
    // Return -1 if the key is not found in the list
    return -1;
}


private Node getMid(Node head){
    Node slow=head;
    Node fast=head.next  ;


        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer one step
            fast = fast.next.next;   // Move fast pointer two steps
        } 
        return slow;
}

private void zigZag( ){
    

    Node mid = getMid(head);
    Node curr=mid.next;
    mid.next=null;

    Node prev = null;
    Node next;
    
    // Traverse the LinkedList, reversing the direction of the links
    while (curr != null) {
        next = curr.next;   // Save the next node temporarily
        curr.next = prev;   // Reverse the current node's link to point to the previous node
        prev = curr;        // Move prev to the current node
        curr = next;        // Move to the next node in the original list
    }
    Node leftHead=head;
    Node rightHead=prev;
    Node rightNext, leftNext;

    while(head !=  null && rightHead != null){
      leftNext=leftHead.next;
      leftHead.next=rightHead;
      rightNext=rightHead.next;
      rightHead.next=leftNext;

      rightHead=rightNext;
      leftHead=leftNext;

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
    ll.zigZag();

    ll.print();
      
        
}
}
