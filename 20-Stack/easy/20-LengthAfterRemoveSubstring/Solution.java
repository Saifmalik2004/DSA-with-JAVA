public class Solution {
    public int minLength(String s) {
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (str.isEmpty()) {
                str.append(c);
            } else {
                if (str.charAt(str.length() - 1) == 'A' && c == 'B') {
                    str.deleteCharAt(str.length() - 1);
                } else if (str.charAt(str.length() - 1) == 'C' && c == 'D') {
                    str.deleteCharAt(str.length() - 1);
                } else {
                    str.append(c);
                }
            }
        }

        return str.length();
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "ABCD";
        System.out.println("Test Case 1 - Remaining length: " + solution.minLength(s1));
        // Expected Output: 0

        // Test case 2
        String s2 = "AABCCDD";
        System.out.println("Test Case 2 - Remaining length: " + solution.minLength(s2));
        // Expected Output: 2

        // Test case 3
        String s3 = "ACBD";
        System.out.println("Test Case 3 - Remaining length: " + solution.minLength(s3));
        // Expected Output: 2

        // Test case 4
        String s4 = "AAA";
        System.out.println("Test Case 4 - Remaining length: " + solution.minLength(s4));
        // Expected Output: 3
    }
}
