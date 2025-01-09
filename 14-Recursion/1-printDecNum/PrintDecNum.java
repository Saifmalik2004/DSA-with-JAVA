public class PrintDecNum {
    
    
    public static void numberPrintDec(int n) {
        // Base case: if n is 1, print it and stop recursion
        if(n == 1) {
            System.out.print(n); // Print without trailing space
            return; // End the recursion
        }
        
        // Print the current value of n followed by a space
        System.out.print(n + " ");
        
        // Recursive call with n-1 to move towards the base case
        numberPrintDec(n - 1);
    }
    
    public static void main(String[] args) {
       
        numberPrintDec(10);
    }
}
