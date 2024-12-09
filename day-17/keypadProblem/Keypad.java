import java.util.ArrayList;
import java.util.List;

public class Keypad {

    // Helper method to solve the problem recursively
    public static void solve(String digit, String output, int index, List<String> ans, String[] mapping) {
        
        // Base case: If index reaches the end of the digit string
        if (index >= digit.length()) {
            ans.add(output); // Add the current combination to the result list
            return;
        }
        
        // Get the current digit and its corresponding characters
        int number = digit.charAt(index) - '0'; // Convert char to integer
        String value = mapping[number]; // Get the corresponding characters for this digit
        
        // Loop through all the characters for the current digit
        for (int i = 0; i < value.length(); i++) {
            output += value.charAt(i); // Add the current character to the output
            solve(digit, output, index + 1, ans, mapping); // Recurse for the next digit
            output = output.substring(0, output.length() - 1); // Backtrack: remove the last character
        }
    }

    // Main method to find letter combinations
    public static  List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans; // If input is empty, return an empty list

        String output = ""; // This will hold the current combination
        int index = 0; // Start at the beginning of the digits string
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; // Mapping for each digit
        solve(digits, output, index, ans, mapping); // Start the recursive search for combinations
        return ans; // Return the list of all combinations
    }

    // Main function to run the program
    public static void main(String[] args) {
        
        
        // Example input
        String digits = "";
        
        // Get all letter combinations
        List<String> combinations = letterCombinations(digits);
        
        // Print the result
        if (combinations.isEmpty()) {
            System.out.println("No combinations found.");
        } else {
            System.out.println("Letter combinations: " + combinations);
        }
    }
}
