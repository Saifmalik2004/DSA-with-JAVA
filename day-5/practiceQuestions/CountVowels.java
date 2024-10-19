import java.util.Scanner; // Import the Scanner class for user input

// Explanation: Vowels are the letters A, E, I, O, U (and sometimes Y). Counting the vowels in a string involves checking each character to see if it is a vowel.
public class CountVowels {
    // Function to count vowels in a string
    public static int countVowels(String str) {
        int count = 0;  // Initialize count of vowels to zero
        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);  // Get the character at the current index
            // Check if the character is a vowel (both uppercase and lowercase)
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
                ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;  // Increment count for each vowel found
            }
        }
        return count;  // Return the total count of vowels
    }

    // Executor to test the function
    public static void main(String[] args) {
        // Try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a string to count its vowels: ");
            String text = scanner.nextLine();  // Read the input string
            
            // Display the count of vowels in the entered string
            System.out.println("Number of vowels in \"" + text + "\": " + countVowels(text));
        } catch (Exception e) {
            // Handle any exceptions that may occur
            System.out.println("Invalid input! Please enter a valid string.");
        }
    }
}
