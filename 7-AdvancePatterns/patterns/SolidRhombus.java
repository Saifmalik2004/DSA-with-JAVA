//output of this pattern is:
//           * * * * * * 
//         * * * * * *
//       * * * * * *
//     * * * * * *
//   * * * * * *
// * * * * * *
public class SolidRhombus {
    
    public static void solidRhombas(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Inner loop for spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("   "); //  spaces for alignment
            }
            // Inner loop for stars
            for (int j = 0; j <rows; j++) {
                System.out.print(" * ");
            }
           
            System.out.println();
        }
    }
    public static void main(String[] args) {
        solidRhombas(6); // Call the method with 6 rows
    }
}
