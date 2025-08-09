public class Solution {

    public static String decodeAtIndex(String s, int k) {
        long len = 0;

        // Step 1: Calculate total length
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                len++;
            } else {
                len *= (ch - '0');
            }
        }

        // Step 2: Reverse simulation
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            k %= len;

            if (k == 0 && Character.isLetter(ch)) {
                return String.valueOf(ch);
            }

            if (Character.isLetter(ch)) {
                len--;
            } else {
                len /= (ch - '0');
            }
        }

        return "";
    }

    public static void main(String[] args) {
       

        // Test cases
        String s1 = "leet2code3";
        int k1 = 10;
        System.out.println("Output: " + decodeAtIndex(s1, k1)); 
        // Expected: "o"

        String s2 = "ha22";
        int k2 = 5;
        System.out.println("Output: " + decodeAtIndex(s2, k2)); 
        // Expected: "h"

        String s3 = "a2345678999999999999999";
        int k3 = 1;
        System.out.println("Output: " + decodeAtIndex(s3, k3)); 
        // Expected: "a"
    }
}
