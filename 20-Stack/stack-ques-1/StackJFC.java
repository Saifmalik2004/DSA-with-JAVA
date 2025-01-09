import java.util.Stack;

public class StackJFC {
    
    // Recursive method to push an element at the bottom of the stack
    public static void pushBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);  // Base case: if the stack is empty, push the element
            return;
        }
        int top = s.pop();  // Pop the top element to hold it temporarily
        pushBottom(s, data);  // Recursively call to push the element at the bottom
        s.push(top);  // Push the previously popped element back on top
    }

    public static void main(String[] args) {
        // Create a stack of integers
        Stack<Integer> s = new Stack<>();
        
        // Push elements onto the stack
        s.push(1);
        s.push(2);
        s.push(3);
        
        // Push 0 at the bottom of the stack using the recursive method
        pushBottom(s, 0);
        
        // Print and pop elements until the stack is empty
        while (!s.isEmpty()) {
            System.out.println(s.peek());  // Print the top element
            s.pop();  // Pop the top element from the stack
        }
    }
}
