import java.util.Scanner;

public class DecimalToBinary {

    // Method to convert decimal number to binary
    public static void decToBin(int decNum) {
        int pow = 0;  // This will keep track of the current power of 10
        int bin = 0;  // This will store the final binary value
        int mynum = decNum;  // Copy of the original decimal number for printing later

        // Loop to convert decimal to binary
        while (decNum > 0) {
            int rem = decNum % 2;  // Find the remainder (binary digit)
            bin = bin + (rem * (int) Math.pow(10, pow));  // Add the binary digit to the final binary number
            pow++;  // Increment power of 10 for the next position
            decNum = decNum / 2;  // Divide the decimal number by 2 to continue the conversion
        }

        // Print the result
        System.out.println("Binary of " + mynum + " = " + bin);
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        try (Scanner sc = new Scanner(System.in)) {
            // Ask the user to input a decimal number
            System.out.print("Enter a decimal number: ");
            int decNum = sc.nextInt();  // Read the input as an integer

            // Call the method to convert decimal to binary
            decToBin(decNum);
        }
    }
}
