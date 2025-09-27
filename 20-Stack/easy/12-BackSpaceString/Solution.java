public class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skips = 0;
        int skipt = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skips++;
                    i--;
                } else if (skips > 0) {
                    skips--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipt++;
                    j--;
                } else if (skipt > 0) {
                    skipt--;
                    j--;
                } else {
                    break;
                }
            }

            char first = (i < 0) ? '$' : s.charAt(i);
            char second = (j < 0) ? '$' : t.charAt(j);

            if (first != second) {
                return false;
            }

            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1
        String s1 = "ab#c";
        String t1 = "ad#c";
        System.out.println("Test 1: " + sol.backspaceCompare(s1, t1)); 
        // Expected: true (both become "ac")

        // Test 2
        String s2 = "ab##";
        String t2 = "c#d#";
        System.out.println("Test 2: " + sol.backspaceCompare(s2, t2)); 
        // Expected: true (both become "")

        // Test 3
        String s3 = "a#c";
        String t3 = "b";
        System.out.println("Test 3: " + sol.backspaceCompare(s3, t3)); 
        // Expected: false ("c" vs "b")
    }
}
