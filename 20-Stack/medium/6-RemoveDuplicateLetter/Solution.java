class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] isTaken = new boolean[26];
        int n = s.length();
        StringBuilder result = new StringBuilder();

        // Step 1: Store last index of each character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }

        // Step 2: Traverse the string
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (isTaken[ch - 'a']) continue;

            // Remove larger characters which will appear later again
            while (
                result.length() > 0 &&
                ch < result.charAt(result.length() - 1) &&
                lastIndex[result.charAt(result.length() - 1) - 'a'] > i
            ) {
                char removed = result.charAt(result.length() - 1);
                isTaken[removed - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            result.append(ch);
            isTaken[ch - 'a'] = true;
        }

        return result.toString();
    }
}
