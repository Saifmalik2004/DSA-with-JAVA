
public class LinkedList {

    // Inner Node class
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
    private static Node tail;

    // Add a node at the beginning
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

    // Add a node at the end
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
            head = tail = null;
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

    // Add node at a given index
    public void addAtIndex(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            addFirst(data);
            return;
        } else if (index == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove node at a given index
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

    // Search for a key in LinkedList
    public int contain(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Delete nth node from the end
    public void deleteNthFromLast(int n) {
        if (n <= 0 || n > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        int sz = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next;
            size--;
            return;
        }

        int i = 1;
        Node prev = head;
        while (i < sz - n) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        size--;
    }

    public int getValueAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
    // Reverse the LinkedList

    public void reverse() {
        if (head == null || head.next == null) {
            return; // empty list or single node list
        }

        Node prev = null;
        Node curr = head;
        Node next = null;

        tail = head; // pehle jo head tha, reverse ke baad wahi tail banega

        while (curr != null) {
            next = curr.next;   // next node store
            curr.next = prev;   // reverse link
            prev = curr;        // move prev forward
            curr = next;        // move curr forward
        }

        head = prev; // last node becomes new head
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(10);
        ll.addFirst(20);
        ll.addLast(30);
        ll.addLast(40);

        ll.print();
        
        ll.reverse();
        ll.print();
    }
}
