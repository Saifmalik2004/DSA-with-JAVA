public class ClearIRangeBits {

    // Clears bits from position i to j in the binary representation of n
    public static int clearIRangeBits(int n, int i, int j) {
        // Step 1: Create a mask with all 1s before position j and after position i
        int a = (~0) << (j + 1);  // All bits set to 1 before j
        int b = (1 << i) - 1;     // All bits set to 1 after i
        
        // Step 2: Combine 'a' and 'b' to create a mask with 0s between i and j
        int bitmask = a | b;

        // Step 3: Use the mask to clear bits from i to j in 'n'
        return n & bitmask;
    }

    public static void main(String[] args) {
        System.out.println(clearIRangeBits(31, 1, 3));  // Example: Clear bits from position 1 to 3 in number 31
    }
}