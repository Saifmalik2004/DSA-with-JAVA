class Solution {
    public String clearDigits(String s) {
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) { // If it's not a letter (i.e., a digit or other symbol)
                if (!str.isEmpty()) {
                    str.deleteCharAt(str.length() - 1); // Remove last letter
                }
            } else {
                str.append(c); // Add letters to the StringBuilder
            }
        }
        return str.toString();
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "abc1d2e";
        System.out.println("Test Case 1: " + solution.clearDigits(s1));
        // Expected Output: "a"

        // Test case 2
        String s2 = "hello3world4";
        System.out.println("Test Case 2: " + solution.clearDigits(s2));
        // Expected Output: "helwor"

        // Test case 3
        String s3 = "abcd";
        System.out.println("Test Case 3: " + solution.clearDigits(s3));
        // Expected Output: "abcd" (no digits, string stays same)

        // Test case 4
        String s4 = "1a2b3c";
        System.out.println("Test Case 4: " + solution.clearDigits(s4));
        // Expected Output: "" (all letters removed)
    }
}
