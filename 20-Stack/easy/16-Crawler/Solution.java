public class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for (String s : logs) {
            if (s.charAt(0) != '.') {   // case: go into a folder
                count++;
            } else if (s.equals("../") && count != 0) {  // case: go back if possible
                count--;
            }
            // case: "./" do nothing
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1
        String[] logs1 = {"d1/","d2/","../","d21/","./"};
        System.out.println("Test 1: " + sol.minOperations(logs1));
        // Expected: 2

        // Test 2
        String[] logs2 = {"d1/","d2/","./","d3/","../","d31/"};
        System.out.println("Test 2: " + sol.minOperations(logs2));
        // Expected: 3

        // Test 3
        String[] logs3 = {"d1/","../","../","../"};
        System.out.println("Test 3: " + sol.minOperations(logs3));
        // Expected: 0
    }
}
