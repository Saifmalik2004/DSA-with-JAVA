public class PrintIncNum {

    
    public static void numberPrintInc(int n) {
        // Base case: if n is 1, print it and end recursion
        if (n == 1) {
            System.out.print(n + " "); // Print 1 without trailing space
            return; // End the recursion
        }
        
        // Recursive call with n - 1 to reach the base case
        numberPrintInc(n - 1);
        
        // Print the current value of n after returning from recursion
        System.out.print(n + " ");
    }
    
    public static void main(String[] args) {
        
        numberPrintInc(10);
    }
}
