
import java.util.Stack;


public class InfixToPostfix {
    public static  int prio(char c){
        switch (c) {
            case '^' -> { return 3;}
            case '*', '/' -> {return 2;}
            case '+', '-' -> {return 1;}
        }
        return -1;
    }
public static String infixTOPostfix(String s) {
    Stack<Character> st = new Stack<>();
    StringBuilder ans = new StringBuilder();
    
    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if (Character.isLetterOrDigit(ch)) {
            ans.append(ch);
        } else if (ch == '(') {
            st.push(ch);
        } else if (ch == ')') {
            while (!st.isEmpty() && st.peek() != '(') {
                ans.append(st.pop());
            }
            st.pop();  // Remove '('
        } else {
            while (!st.isEmpty() &&
                   (prio(ch) < prio(st.peek()) ||
                    (prio(ch) == prio(st.peek()) && ch != '^'))) {
                ans.append(st.pop());
            }
            st.push(ch);
        }
    }

    while (!st.isEmpty()) {
        ans.append(st.pop());
    }

    return ans.toString();
}

    public static void main(String[] args) {
        String s="(p+q)*(m-n)";
        System.out.println("Postfix Expression "+infixTOPostfix(s));
    }
}
