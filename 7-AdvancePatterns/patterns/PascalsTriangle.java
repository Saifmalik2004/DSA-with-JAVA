//output of this pattern is:
//     1 
//    1 1
//   1 2 1
//  1 3 3 1
// 1 4 6 4 1
public class PascalsTriangle {
    
    // Method to print Pascal's triangle
    public static void pascalTriangle(int n){

        for(int i=0;i<n;i++){
            for(int j=0;j<(n-i)-1;j++){
                System.err.print(" ");
            }
            int value=1;
            for(int k=0;k<=i;k++){
                System.out.print(value+" ");
                 value=value*(i-k)/(k+1);
    
            }
            System.out.println("");
        }
    
    }

    public static void main(String[] args) {
        pascalTriangle(5); // Call the method with 6 rows
    }
}

