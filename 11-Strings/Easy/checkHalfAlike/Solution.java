import java.util.Set;

public class Solution {
    public static boolean check(String s){
       Set<Character> vowels = Set.of('a','e','i','o','u','A','E','I','O','U');
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (vowels.contains(s.charAt(i))) count++;
            if (vowels.contains(s.charAt(n - 1 - i))) count--;
        }

        return count == 0;
    }

    public static void main(String[] args) {
        String s="saif";
        

        System.out.println(check(s));
    }
}
