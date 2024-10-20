//output of this pattern is:
//      1
//     212
//    32123
//   4321234
//  543212345
// 65432123456
public class PalindromePyramid {
    
    // Method to print a palindrome pyramid
    public static void palidromPyramid(int n){
        
        for (int i = 1; i <= n; i++) {
            
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
             // Right side numbers increasing order mein (1 ke baad)
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
          
          
            
            System.out.println();
        }

    }

    public static void main(String[] args) {
        palidromPyramid(6); // Call the method with 6 rows
    }
}
