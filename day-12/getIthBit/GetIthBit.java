public class GetIthBit {

    // Method to get the ith bit of a given number
    public static int getIthBit(int n, int i) {
        int bitmask = 1 << i;  // Step 1: Create a bitmask by shifting 1 to the ith position

        // Step 2: Use bitwise AND to check if the ith bit of 'bin' is 0 or 1
        if ((n & bitmask) == 0) {
            return 0;  // If the result is 0, the ith bit is 0
        }
        return 1;  // Otherwise, the ith bit is 1
    }

    public static void main(String[] args) {
        System.out.println(getIthBit(10, 3));  // Example: Get the 3rd bit of 10 (binary 1010)
    }
}
