public class StackLinkedList {
    
    // Node class represents each element in the stack
    static class Node {
        int data;
        Node next;

        // Constructor to initialize the node with data
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Stack class implementing stack using a linked list
    static class Stack {
        static Node head = null;

        // Checks if the stack is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Pushes a new element onto the stack
        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        // Pops the top element from the stack and returns it
        public int pop() {
            if (isEmpty()) return -1;
            int val = head.data;
            head = head.next;
            return val;
        }

        // Peeks the top element without removing it
        public int peek() {
            if (isEmpty()) return -1;
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);  // Push 1 onto the stack
        s.push(2);  // Push 2 onto the stack
        s.push(3);  // Push 3 onto the stack

        // Print and pop elements until stack is empty
        while (!s.isEmpty()) {
            System.out.println(s.peek());  // Print top element
            s.pop();  // Pop the top element
        }
    }
}
