public class Optimize {
    // Function to calculate power using exponentiation by squaring
    public static int powerExpo(int b, int expo) {
        // Initialize base and answer
        int base = b;
        int ans = 1;

        // Loop until expo becomes 0
        while (expo > 0) {
            // If exponent is odd, multiply the result with the current base
            if (expo % 2 == 1) {
                ans = ans * base;
                expo--; // Decrease the exponent by 1
            } else {
                expo /= 2; // Halve the exponent (divide by 2)
                base *= base; // Square the base for the next iteration
            }
        }

        // Return the final result
        return ans;
    }

    // Main method to test the powerExpo function
    public static void main(String[] args) {
        // Test the powerExpo function with base 10 and exponent 5
        System.out.println(powerExpo(10, 5));
    }
}
