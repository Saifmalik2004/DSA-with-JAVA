// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Stack;

public class PrefixToPostfix {

   public static String prefixToPostfix(String s) {

      Stack<String> st = new Stack<>();
      

      for(int i = s.length()-1; i >=0 ; i--) {
         char ch = s.charAt(i);
         if (Character.isLetterOrDigit(ch)) {
            st.add(Character.toString(ch));
         } else {
            String operand1 = (String)st.pop();
            String operand2 = (String)st.pop();
            String expr =  operand1 + operand2 +ch;
            st.add(expr);
         }
      }

      return st.pop();
   }

   public static void main(String[] args) {
      String s = "*+pq-mn";
      String infixExpr = prefixToPostfix(s);
      System.out.println("Postfix Expression: " + infixExpr);
   }
}
