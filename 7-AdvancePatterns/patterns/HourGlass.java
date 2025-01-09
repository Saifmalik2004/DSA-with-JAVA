//output of this pattern is:
// ***********
//  *********
//   *******
//    *****
//     ***
//      *
//     ***
//    *****
//   *******
//  *********
// ***********
public class HourGlass {
    
    public static void hourGlass(int n) {
       
        for (int i = n; i >= 1; i--) {
           
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
           
            for (int j = 1; j <= (2*i)-1; j++) {
                System.out.print("*");
            }
           
            
            System.out.println();
        }
        for (int i = 2; i <= n; i++) {
           
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
           
            for (int j = 1; j <= (2*i)-1; j++) {
                System.out.print("*");
            }
           
            
            System.out.println();
        }
    }    public static void main(String[] args) {
        hourGlass(6); // Call the method with 6 rows
    }
}
