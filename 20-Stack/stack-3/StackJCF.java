import java.util.Stack;

public class StackJCF {
    
    public static void main(String[] args) {
        // Create a stack of integers
        Stack<Integer> s = new Stack<>();
        
        // Push elements onto the stack
        s.push(1);
        s.push(2);
        s.push(3);
        
        // Print and pop elements until the stack is empty
        while (!s.isEmpty()) {
            System.out.println(s.peek());  // Print the top element
            s.pop();  // Pop the top element from the stack
        }
    }
}
