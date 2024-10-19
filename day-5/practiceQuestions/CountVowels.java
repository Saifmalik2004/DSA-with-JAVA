import java.util.Scanner; // Import the Scanner class for user input

// Explanation: Vowels are the letters A, E, I, O, U (and sometimes Y). Counting the vowels in a string involves checking each character to see if it is a vowel.

public class CountVowels {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string to count its vowels: "); // Prompt user for input
            String text = scanner.nextLine(); // Read the input string
            
            int count = 0; // Initialize count of vowels to zero
            // Loop through each character in the string
            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i); // Get the character at the current index
                // Check if the character is a vowel (both uppercase and lowercase)
                if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
                    ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++; // Increment count for each vowel found
                }
            }
            System.out.println("Number of vowels: " + count); // Display the count of vowels
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid string.");
        }
    }
}