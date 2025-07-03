//output of this pattern is:
//     1 
//    1 1
//   1 2 1
//  1 3 3 1
// 1 4 6 4 1

public class p19_PascalsTriangle {

    // Method to print Pascal's triangle
    public static void pascalTriangle(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                System.out.print(" ");
            }
            int value = 1;
            for (int k = 0; k <= i; k++) {
                System.out.print(value + " ");
                value = value * (i - k) / (k + 1);

            }
            System.out.println("");
        }
        
    }
    
    public static void main(String[] args) {
        printP(5); // Call the method with 6 rows
    }
    
    public static void printP(int n) {
        int value;
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 1; j < n-i; j++) {
                System.out.print(" ");
            }
            value = 1;
            for (int k = 0; k <= i; k++) {
                
                System.out.print(value + " ");
                value=value*(i-k)/(k+1);
            }
            System.out.println("");
        }

    }
}

//output of this pattern is:
//     1 
//    1 1
//   1 2 1
//  1 3 3 1
// 1 4 6 4 1
