public class UpdateIthBit {

    // Method to clear (set to 0) the ith bit of a given number
    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);  // Step 1: Create a bitmask by shifting 1 to the ith position and inverting all bits
        return n & bitmask;        // Step 2: Use bitwise AND with the bitmask to clear the ith bit of 'n'
    }

    // Method to set (change to 1) the ith bit of a given number
    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;      // Step 1: Create a bitmask by shifting 1 to the ith position
        return n | bitmask;        // Step 2: Use bitwise OR with the bitmask to set the ith bit of 'n'
    }

    // Method to update the ith bit of a given number to a specific value (0 or 1)
    public static int updateIthBit(int n, int i, int v) {
        n = clearIthBit(n, i);       // Step 1: Clear the ith bit
        int bitMask = v << i;        // Step 2: Create a bitmask with the value shifted to the ith position
        return n | bitMask;          // Step 3: Use bitwise OR to set the ith bit to 'v'
    }

    public static void main(String[] args) {
        System.out.println(updateIthBit(10, 2, 1));  // Example: Update the 2nd bit of 10 (binary 1010) to 1
    }
}
