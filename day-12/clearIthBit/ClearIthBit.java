public class ClearIthBit {

    // Method to clear (set to 0) the ith bit of a given number
    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);  // Step 1: Create a bitmask by shifting 1 to the ith position and inverting all bits
        // Step 2: Use bitwise AND with the bitmask to clear the ith bit of 'n'
        return n & bitmask;
    }

    public static void main(String[] args) {
        System.out.println(clearIthBit(10, 1));  // Example: Clear the 1st bit of 10 (binary 1010)
    }
}
