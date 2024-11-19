import java.util.Scanner;

public class BinaryToDecimal {

    // Method to convert binary number to decimal
    public static void binToDec(int binNum) {
        int pow = 0;  // This will keep track of the current power of 2
        int decimal = 0;  // This will store the final decimal value
        int mynum = binNum;  // Copy of original binary number for printing later

        // Loop through each digit of the binary number
        while (binNum > 0) {
            int lastdigit = binNum % 10;  // Extract the last digit (0 or 1)
            decimal += (lastdigit * (int) Math.pow(2, pow));  // Calculate the decimal value for this digit

            pow++;  // Increment power for the next position
            binNum = binNum / 10;  // Remove the last digit by dividing the binary number by 10
        }

        // Print the result
        System.out.println("Decimal of " + mynum + " = " + decimal);
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        try (Scanner sc = new Scanner(System.in)) {
            // Ask the user to input a binary number
            System.out.print("Enter a binary number: ");
            int binNum = sc.nextInt();  // Read the input as an integer

            // Call the method to convert binary to decimal
            binToDec(binNum);
        }
    }
}
