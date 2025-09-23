import java.util.Stack;

public class PostfixToPrefix {

    public static String postfixToPrefix(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.add(Character.toString(ch));
            } else {  // Operator
                // Ensure stack has enough operands
                String operand2 = st.pop();
                String operand1 = st.pop();
                String expr = ch+ operand1  + operand2 ;
                st.add(expr);
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        String s = "pq+mn-*";
        String infixExpr = postfixToPrefix(s);
        System.out.println("prefix Expression: " + infixExpr);
    }
}
