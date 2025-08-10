public class Solution {

    public static String check(String s) {
        StringBuilder res = new StringBuilder();

        // Add the first character to the result
        res.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            // If the current character and the last added character differ by 32 in ASCII,
            // it means they are the same letter but different cases (e.g., 'a' and 'A').
            if (res.length() > 0 && Math.abs(s.charAt(i) - res.charAt(res.length() - 1)) == 32) {
                // Remove the last character from the result
                res.deleteCharAt(res.length() - 1);
            } else {
                // Otherwise, add the current character to the result
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(check(s)); // Output: "leetcode"
    }
}
