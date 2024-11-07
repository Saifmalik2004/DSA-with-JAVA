public class SetIthBit {

    // Method to set the ith bit of a given number 'n' to 1
    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;  // Step 1: Create a bitmask by shifting 1 to the ith position
        return n | bitmask;    // Step 2: Use bitwise OR to set the ith bit of 'n' to 1
    }

    public static void main(String[] args) {
        System.out.println(setIthBit(10, 2));  // Example: Set the 2nd bit of 10 (binary 1010)
    }
}
