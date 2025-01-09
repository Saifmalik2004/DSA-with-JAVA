public class BinaryString {
    
    // Function to generate binary strings of length `n` with no consecutive 1's
    public static void binaryString(int n, int last, String str) {
        // Base case: If no more characters are needed (`n == 0`)
        if (n == 0) {
            System.out.println(str); // Print the binary string created so far
            return; // Exit the function
        }
        
        // Recursive call to add '0' to the current string
        binaryString(n - 1, 0, str + "0"); // Reduce `n` by 1, add '0', set `last` as 0

        // Conditional recursive call to add '1' to the current string
        if (last == 0) { // Only add '1' if the previous character was '0'
            binaryString(n - 1, 1, str + "1"); // Reduce `n` by 1, add '1', set `last` as 1
        }
    }

    public static void main(String[] args) {
        // Starting the function with a string length of 3, initial last character as '0', and an empty string
        binaryString(3, 0, ""); 
    }
}
