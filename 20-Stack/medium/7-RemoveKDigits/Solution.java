
import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {


        int n=num.length();
        if(k==n) return "0";

        Stack<Character> stack= new Stack<>();
        int i=0;
        while(i<n){
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder str=new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        str.reverse();

        while(str.length()>1 && str.charAt(0)=='0'){
            str.deleteCharAt(0);
        }
        return str.toString();
        

    }
}