public class ClearLastBits {

    // Method to clear the last 'i' bits of a given number
    public static int clearLastBits(int n, int i) {
        return n & ((~0) << i);  // Step 1: Shift a bitmask of all 1's left by 'i' to make last 'i' bits 0
                                  // Step 2: Use bitwise AND to clear the last 'i' bits of 'n'
    }

    public static void main(String[] args) {
        System.out.println(clearLastBits(15, 2));  // Example: Clear the last 2 bits of 15 (binary 1111)
    }
}
