import java.util.Stack;

public class StackJFC {
    
    // Recursive method to push an element at the bottom of the stack
    public static void pushBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);  // Base case: if stack is empty, push the element
            return;
        }
        int top = s.pop();  // Pop the top element to hold it temporarily
        pushBottom(s, data);  // Recursively push data at the bottom
        s.push(top);  // Push the popped element back on top
    }

    // Method to reverse the entire stack
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;  // Base case: if stack is empty, return
        }
        int top = s.pop();  // Pop the top element
        reverseStack(s);  // Recursively reverse the remaining stack
        pushBottom(s, top);  // Push the popped element at the bottom of the stack
    }

    // Method to print and remove all elements from the stack
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.print(s.pop());  // Print and remove the top element
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);  // Push elements onto the stack
        s.push(2);
        s.push(3);

        reverseStack(s);  // Reverse the stack
        printStack(s);  // Print the reversed stack
    }
}
