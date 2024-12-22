import java.util.ArrayList;

public class StackArraylist {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        // Check if the stack is empty
        public boolean isEmpty() {
            return list.isEmpty();
        }

        // Push an element onto the stack
        public void push(int data) {
            list.add(data);
        }

        // Pop the top element from the stack
        public int pop() {
            if (isEmpty()) {
                return -1; // Return -1 if the stack is empty
            }
            int top = list.get(list.size() - 1); // Get the top element
            list.remove(list.size() - 1); // Remove it from the stack
            return top;
        }

        // Peek at the top element without removing it
        public int peek() {
            if (isEmpty()) {
                return -1; // Return -1 if the stack is empty
            }
            return list.get(list.size() - 1); // Return the top element
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1); // Push 1 onto the stack
        stack.push(2); // Push 2 onto the stack
        stack.push(3); // Push 3 onto the stack

        // Print and pop elements from the stack
        while (!stack.isEmpty()) {
            System.out.println(stack.peek()); // Peek the top element
            stack.pop(); // Pop the top element
        }
    }
}
