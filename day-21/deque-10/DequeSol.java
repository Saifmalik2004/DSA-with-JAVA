import java.util.Deque;
import java.util.LinkedList;

public class DequeSol {
    static class Stack {

        // Declare a Deque to store stack elements
        Deque<Integer> deque = new LinkedList<>();

        // Method to check if the stack is empty
        public boolean isEmpty() {
            return deque.isEmpty();
        }

        // Method to push (add) an element onto the stack
        public void push(int data) {
            deque.addLast(data); // Add to the end (top of the stack)
        }

        // Method to pop (remove) the top element from the stack
        public int pop() {
            return deque.removeLast(); // Remove from the end (top of the stack)
        }

        // Method to peek (view) the top element without removing it
        public int peek() {
            return deque.getLast(); // Get the last element (top of the stack)
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        // Push elements onto the stack
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        // Peek at the top element
        System.out.println("Top of stack: " + s.peek());

        // Pop and print elements until the stack is empty
        while (!s.isEmpty()) {
            System.out.println("Popped: " + s.pop());
        }
    }
}
