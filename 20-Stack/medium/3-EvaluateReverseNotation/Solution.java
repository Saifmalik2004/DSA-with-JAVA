import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a,b;
        
        for (String token : tokens) {
            // check if operator
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                 b = stack.pop();
                 a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                 b = stack.pop();
                 a = stack.pop();
                stack.push(a / b); // integer division
            } else {
                // number case
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop(); // final answer
    }
}