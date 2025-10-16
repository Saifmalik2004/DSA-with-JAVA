class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();
        long len = 0; // ✅ Use long, not double

        // First pass: find total length
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                len++;
            } else {
                len *= (ch - '0');
            }
        }

        // Second pass: reverse simulation
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            k %= len; // Reduce k to range

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
}
