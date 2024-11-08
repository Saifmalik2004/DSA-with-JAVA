public class AddTwoNumber {
    
    // Method to add two numbers without using the + operator
    public static int addToNum(int a, int b) {
        
        // Loop until there is no carry left
        while (b != 0) {
            // Step 1: Calculate the carry
            int temp = (a & b) << 1; // a & b finds common set bits, then << 1 shifts carry to the left by 1
            
            // Step 2: Calculate partial sum without the carry
            a = a ^ b; // XOR adds bits where only one of a or b is 1
            
            // Step 3: Assign carry to b for next iteration
            b = temp; // Update b to the carry to add in the next round
        }
        
        // When carry is zero, a contains the final sum
        return a;
    }
    
    public static void main(String[] args) {
        // Testing the addToNum method with example values
        System.out.println(addToNum(2, 4)); // Output should be 6
    }
}
