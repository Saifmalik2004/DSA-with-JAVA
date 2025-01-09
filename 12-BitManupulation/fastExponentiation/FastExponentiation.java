public class FastExponentiation {

    // Method to calculate a^n using fast exponentiation
    public static int power(int a, int n) {
        int result = 1; // Initialize result to hold the answer

        // Loop while n > 0
        while (n > 0) {
            // Check if the current bit of n is 1 (odd) using bitwise AND
            if ((n & 1) != 0) { // (n & 1) checks if n is odd
                result = result * a; // Multiply result by a when n is odd
            }
            a = a * a; // Square a for the next round
            n = n >> 1; // Right-shift n to process the next bit
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(3, 4)); // Outputs 81 (3^4 = 81)

        // Extra bitwise trick demonstration:
        int x = 0;
        System.out.println("result " + -~x); // This demonstrates a unique trick to add 1 to x using bitwise NOT (~)
    }
}
