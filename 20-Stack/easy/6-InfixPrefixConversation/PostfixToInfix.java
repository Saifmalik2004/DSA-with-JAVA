import java.util.Stack;

public class PostfixToInfix {

    public static String postfixToInfix(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.add(Character.toString(ch));
            } else {  // Operator
                // Ensure stack has enough operands
                String operand2 = st.pop();
                String operand1 = st.pop();
                String expr = "(" + operand1 + ch + operand2 + ")";
                st.add(expr);
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        String s = "pq+mn-*";
        String infixExpr = postfixToInfix(s);
        System.out.println("Infix Expression: " + infixExpr);
    }
}
