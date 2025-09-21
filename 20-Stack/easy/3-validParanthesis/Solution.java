import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') st.push(')');
            else if (c == '[') st.push(']');
            else if (c == '{') st.push('}');
            else if (st.isEmpty() || st.pop() != c) return false;
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
       

        String testCase1 = "()[]{}";
        String testCase2 = "([{}])";
        String testCase3 = "(]";
        String testCase4 = "((()))";
        String testCase5 = "{[()]()}";
        String testCase6 = "({[})";

        System.out.println(testCase1 + " -> " + isValid(testCase1));  // true
        System.out.println(testCase2 + " -> " + isValid(testCase2));  // true
        System.out.println(testCase3 + " -> " + isValid(testCase3));  // false
        System.out.println(testCase4 + " -> " + isValid(testCase4));  // true
        System.out.println(testCase5 + " -> " + isValid(testCase5));  // true
        System.out.println(testCase6 + " -> " + isValid(testCase6));  // false
    }
}
