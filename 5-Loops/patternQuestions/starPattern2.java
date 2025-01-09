/*
Output:

* * * * *
* * * *
* * *
* *
*

*/

public class starPattern2 {
    public static void main(String arg[]) {
        // Define the number of rows for the pattern
        int n = 5;   

        // Outer loop to iterate through each row
        for (int i = 1; i <= n; i++) {
            // Inner loop to print the asterisks in each row
            // The number of asterisks decreases with each row
            for (int k = 1; k <= n - i + 1; k++) {
                System.out.print("* ");  // Print an asterisk followed by a space
            }
            System.out.println();  // Move to the next line after printing all asterisks in the current row
        }
    }
}
