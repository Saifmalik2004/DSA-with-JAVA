public class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        StringBuilder res = new StringBuilder();
        int i = 0;
        
        // Find the index of the first occurrence of ch
        while (i < n && word.charAt(i) != ch) i++;
        
        // If ch is not found, return the original word
        if (i == n) return word;
        
        int j = i + 1;
        
        // Append the reversed prefix
        while (i >= 0) res.append(word.charAt(i--));
        
        // Append the remaining part of the word
        while (j < n) res.append(word.charAt(j++));
        
        return res.toString();
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String word1 = "abcdefd";
        char ch1 = 'd';
        System.out.println("Test Case 1: " + solution.reversePrefix(word1, ch1));
        // Expected Output: "dcbaefd"

        // Test case 2
        String word2 = "xyzt";
        char ch2 = 'a';
        System.out.println("Test Case 2: " + solution.reversePrefix(word2, ch2));
        // Expected Output: "xyzt" (ch not found)

        // Test case 3
        String word3 = "leetcode";
        char ch3 = 'e';
        System.out.println("Test Case 3: " + solution.reversePrefix(word3, ch3));
        // Expected Output: "eelctode"
    }
}
