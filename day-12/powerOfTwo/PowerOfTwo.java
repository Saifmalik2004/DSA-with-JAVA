public class PowerOfTwo {

    // Method to check if a number is a power of 2
    public static boolean power(int n) {
        // If n is a power of 2, it will have exactly one bit set to 1.
        // Example: 4 -> 100, 8 -> 1000, 16 -> 10000
        // n & (n-1) will be 0 if n is a power of 2.
        return n>0 && (n & (31)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(power(32));  // Example: Checking if 32 is a power of 2
    }
}
