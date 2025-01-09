// This pattern forms a half pyramid using asterisks (*).
// Each row contains an increasing number of asterisks.
// The output looks like this:
// * 
// * * 
// * * * 
// * * * * 
// * * * * * 



public class starPattern {
    public static void main(String arg[]){
        
         
 for(int i=1; i<=5;i++){
   for(int k=1; k<=i;k++ ){
    System.out.print("* ");
   }
   System.out.println();
 }
     
    }
}
