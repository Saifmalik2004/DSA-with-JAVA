
public class Solution {
    public static String say(int n) {

        if(n==1) return "1";
        
        String prev=say(n-1);
     
      
        StringBuilder ans =new StringBuilder();
        int i=0;
        while(i<prev.length()){
            int count=1;
            while(i+1<prev.length()&& prev.charAt(i) == prev.charAt(i+1)){
                count++;
                i++;
            }
            ans.append(count).append(prev.charAt(i));
            i++;
        }
         
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(say(5));
    }   
}
