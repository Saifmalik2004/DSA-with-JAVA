import java.util.Stack;

public class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (stack.size() > 0) {
                    str.append(c);
                }
                stack.push(c);
            } else {
                stack.pop();
                if (stack.size() > 0) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1
        String input1 = "(()())(())";
        System.out.println("Test 1: " + sol.removeOuterParentheses(input1));
        // Expected: "()()()"

        // Test 2
        String input2 = "(()())(())(()(()))";
        System.out.println("Test 2: " + sol.removeOuterParentheses(input2));
        // Expected: "()()()()(())"

        // Test 3
        String input3 = "()()";
        System.out.println("Test 3: " + sol.removeOuterParentheses(input3));
        // Expected: "" (outer removed, nothing left)
    }
}
