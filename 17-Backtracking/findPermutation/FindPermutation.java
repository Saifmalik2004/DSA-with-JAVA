public class FindPermutation {
    
    public static void findPermutation(String str, String ans) {
        
        // Base case: if the input string is empty, print the current permutation
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        
        // Iterate through the string to select each character as the starting point
        for (int i = 0; i < str.length(); i++) {
            // Remove the current character at index `i` and create a new string
            String newString = str.substring(0, i) + str.substring(i + 1);
            
            // Recursive call: append the current character to the answer and find permutations
            findPermutation(newString, ans + str.charAt(i));
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        
        String str = "abc";

        // Call the method to find and print all permutations
        findPermutation(str, "");
    }
}
