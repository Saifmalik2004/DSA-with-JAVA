//output of this pattern is:
// 1 
// 2 3 
// 4 5 6 
// 7 8 9 10 
// 11 12 13 14 15 


public class FloydsTriangle {
    
    // Method to print Floyd's triangle
    public static void flyodsTriangle(int n) {
        int num = 1; // Start number for Floyd's triangle
        // Loop through each row
        for (int i = 1; i <= n; i++) {
            // Inner loop to print numbers in the row
            for (int k = 1; k <= i; k++) {
                System.out.print(num + " "); // Print the current number
                num++; // Increment the number for the next position
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

    public static void main(String[] args) {
        flyodsTriangle(6); // Call the method with 6 rows
    }
}
