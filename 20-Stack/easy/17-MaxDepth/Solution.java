public class Solution {
    public int maxDepth(String s) {
        int count = 0; // Current depth
        int max = 0;   // Maximum depth observed

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                max = Math.max(max, count);
            } else if (c == ')') {
                count--;
            }
        }

        return max;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();
        String testString = "(1+(2*3)+((8)/4))+1";
        int result = solution.maxDepth(testString);
        System.out.println("Maximum Depth: " + result);
    }
}
