class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        boolean isFirst = false;

        for (int i = 0; i < word.length(); i++) {
            if ((int) word.charAt(i) <= 90) { // Uppercase letters ASCII <= 90
                count++;
                if (i == 0) {
                    isFirst = true;
                }
            }
        }

        if (count == 1 && isFirst) return true;
        else return (count == word.length() || count == 0);
        
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Sample inputs
        String[] testWords = {
            "USA",        // true (all caps)
            "leetcode",   // true (all lowercase)
            "Google",     // true (only first capital)
            "FlaG",       // false (random capitals)
            "g",          // true (lowercase single letter)
            "G"           // true (uppercase single letter)
        };

        for (String word : testWords) {
            boolean result = sol.detectCapitalUse(word);
            System.out.println("Input: " + word + " => Output: " + result);
        }
    }
}
