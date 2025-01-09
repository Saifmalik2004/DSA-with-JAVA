public class PalindromeString {
    // Defines a class named PalindromeString

    public static boolean checkPalindrome(String str) {
        // Declares a static method 'checkPalindrome' that takes a String 'str' as input
        // and returns a boolean value indicating if the string is a palindrome.

        for (int i = 0; i < str.length() / 2; i++) {
            // Loops from 0 up to half the length of the string. 
            // We only need to check up to the middle because a palindrome is symmetric.

            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                // Compares characters from the start and end of the string moving towards the center.
                // If characters at positions 'i' from the start and 'i' from the end don’t match,
                // it’s not a palindrome.

                System.err.println("not palindrome");
                // Prints "not palindrome" to indicate that the input string is not a palindrome.

                return false;
                // Returns false to indicate the string is not a palindrome and exits the method.
            }
        }
        System.err.println("palindrome");
        // If the loop completes without finding any mismatched characters, prints "palindrome".

        return true;
        // Returns true, indicating that the string is a palindrome.
    }

    public static void main(String[] args) {
        // Main method to run the program.

        String str = "saas";
        // Declares a string variable 'str' with the value "saas".

        checkPalindrome(str);
        // Calls the 'checkPalindrome' method with 'str' as the argument.
    }
}
