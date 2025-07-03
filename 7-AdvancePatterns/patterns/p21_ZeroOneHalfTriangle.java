//output of this pattern is:
// 1 
// 0 1 
// 1 0 1 
// 0 1 0 1 
// 1 0 1 0 1 

public class p21_ZeroOneHalfTriangle {
    
    // Method to print a triangle with 0s and 1s
    public static void triangleWith01(int n) {
        // Loop through each row
        for (int i = 1; i <= n; i++) {
            // Inner loop to print 0s and 1s
            for (int k = 1; k <= i; k++) {
                // Print 1 or 0 based on the condition
                if ((i + k) % 2 == 0) {
                    System.out.print(1 + " "); // Print 1 for even sum
                } else {
                    System.out.print(0 + " "); // Print 0 for odd sum
                }
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

    public static void main(String[] args) {
        triangleWith01(6); // Call the method with 6 rows
    }
}
