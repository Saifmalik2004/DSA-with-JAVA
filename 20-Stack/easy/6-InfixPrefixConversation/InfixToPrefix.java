import java.util.Stack;

public class InfixToPrefix {

    // Operator precedence
    public static int precedence(char op) {
        return switch (op) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    // Efficient reversal + parenthesis swap
    public static String reverseAndSwapParentheses(String expression) {
        StringBuilder result = new StringBuilder();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                result.append(')');
            } else if (ch == ')') {
                result.append('(');
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String infixToPrefix(String expression) {
        String modifiedExpr = reverseAndSwapParentheses(expression);

        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < modifiedExpr.length(); i++) {
            char ch = modifiedExpr.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();  // pop '('
            } else {  // operator
                 while (!stack.isEmpty() &&
                   (precedence(ch) < precedence(stack.peek()) ||
                    (precedence(ch) == precedence(stack.peek()) && ch != '^'))) {
                postfix.append(stack.pop());
            }
            stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        // Final prefix result
        return postfix.reverse().toString();
    }

    public static void main(String[] args) {
        String infixExpr = "(p+q)*(m-n)";
        String prefixExpr = infixToPrefix(infixExpr);
        System.out.println("Prefix Expression: " + prefixExpr);
    }
}
