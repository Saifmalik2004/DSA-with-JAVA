public class FindFirstPalin {

   
    public static String firstPalindrome(String[] words) {
        // Loop through all the words in the array
        for (int i = 0; i < words.length; i++) {
            // Flag variable to check if the current word is a palindrome
            int flag = 0;
            
            // Get the length of the current word
            int n = words[i].length();
            
            // Loop through the first half of the word and compare each character
            for (int j = 0; j < n / 2; j++) {
                // If characters from both ends do not match, it's not a palindrome
                if (words[i].charAt(j) != words[i].charAt(n - j - 1)) {
                    // Set the flag to indicate the word is not a palindrome
                    flag = 1;
                    break; // Break the loop as we don't need to check further
                }
            }
            
            // If the flag is 0, it means the word is a palindrome
            if (flag == 0) {
                return words[i]; // Return the first palindrome word
            }
        }
        
        // If no palindrome is found, return an empty string
        return "";
    }

    public static void main(String[] args) {
        // Define an array of words to test the function
        String[] words = {"abc", "def", "ghi", "aba"};
        
        // Call the firstPalindrome method and print the result
        System.out.println(firstPalindrome(words)); // Output: aba
    }
}
