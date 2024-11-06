public class OddEven {

    // Method to check if a number is odd or even
    public static void oddEven(int num) {
        int bitmask = 1;  // Bitmask with the least significant bit set to 1 (binary 0001)

        // Using bitwise AND to check if the least significant bit is 0 or 1
        // If the result is 0, the number is even; if the result is 1, the number is odd.
        if ((num & bitmask) == 0) {
            System.out.println("even number");
        } else {
            System.out.println("Odd number");
        }
    }

    public static void main(String[] args) {
        oddEven(9);  // Test with an odd number
        oddEven(2);  // Test with an even number
        oddEven(3);  // Test with an odd number
    }
}
