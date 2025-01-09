//output of this pattern is:
//           * * * * * * 
//         *         *
//       *         *
//     *         *
//   *         *
// * * * * * *
public class HollowRhombus {
    
    public static void hollowRohmbas(int rows)   {
        int cols=rows;
        for(int i=1; i<=rows;i++){
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  "); // two spaces for alignment
            }
           for(int j=1; j<=rows; j++ ){
           if(i == 1 || i == rows || j==1 || j==cols){
            System.out.print("* ");
           } else{
            System.out.print("  ");
           }
            
           }
           for (int j = 1; j <= i - 1; j++) {
            System.out.print("  "); // two spaces for alignment
        }
          
           System.out.println();
         }
                 
       
          
      }

    public static void main(String[] args) {
        hollowRohmbas(6); // Call the method with 6 rows
    }
}
