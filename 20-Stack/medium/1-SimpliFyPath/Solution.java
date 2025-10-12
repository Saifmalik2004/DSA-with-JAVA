
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
       Stack<String> stack = new Stack<>(); 

        StringBuilder sb = new StringBuilder(); 

        String[] pathItems = path.split("/"); 

        for(String s : pathItems) {

            if(s.equals("") || s.equals(".")) {
                continue; 
            } else if(s.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop(); 
                }
            } else {
                stack.push(s); 
            }
        }
        
        if(stack.isEmpty()) {
            return "/"; 
        }

        for(String s : stack) {
            sb.append("/").append(s); 
        }
        return sb.toString(); 
    }
}
