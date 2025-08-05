import java.util.*;

class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, "", res);
        return res;
    }

    private void backtrack(String s, int idx, int parts, String curr, List<String> res) {
        if (parts == 4 && idx == s.length()) {
            res.add(curr.substring(0, curr.length() - 1)); // remove last dot
            return;
        }

        if (parts > 4 || idx >= s.length()) return;

        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
            String segment = s.substring(idx, idx + len);
            if (isValid(segment)) {
                backtrack(s, idx + len, parts + 1, curr + segment + ".", res);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test input
        String input = "25525511135";
        List<String> result = solution.restoreIpAddresses(input);

        // Print result
        System.out.println("Possible IP addresses for \"" + input + "\":");
        for (String ip : result) {
            System.out.println(ip);
        }
    }
}
