public class Solution {

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length();

        while (i < n && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        // Test case 1
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("Output 1: " + isSubsequence(s1, t1));
        // Expected: true

        // Test case 2
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Output 2: " + isSubsequence(s2, t2));
        // Expected: false

        // Test case 3
        String s3 = "";
        String t3 = "ahbgdc";
        System.out.println("Output 3: " + isSubsequence(s3, t3));
        // Expected: true (empty string is always subsequence)
    }
}
