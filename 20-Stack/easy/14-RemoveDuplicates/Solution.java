public class Solution {
    public String removeDuplicates(String s) {
        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (res.isEmpty() || res.charAt(res.length() - 1) != c) {
                res.append(c);
            } else {
                res.deleteCharAt(res.length() - 1);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1
        String input1 = "abbaca";
        System.out.println("Test 1: " + sol.removeDuplicates(input1));
        // Expected: "ca"

        // Test 2
        String input2 = "azxxzy";
        System.out.println("Test 2: " + sol.removeDuplicates(input2));
        // Expected: "ay"

        // Test 3
        String input3 = "aabbcc";
        System.out.println("Test 3: " + sol.removeDuplicates(input3));
        // Expected: "" (sab remove ho jaayenge)

        // Test 4
        String input4 = "abcde";
        System.out.println("Test 4: " + sol.removeDuplicates(input4));
        // Expected: "abcde" (kuch bhi duplicate nahi)
    }
}
