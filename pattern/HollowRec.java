




public class HollowRec {

  public static void hollow_rec(int toRows,int toCols)   {
    
    for(int i=1; i<=toRows;i++){
      //inner loop
       for(int j=1; j<=toCols; j++ ){
       if(i == 1 || i == toRows || j==1 || j==toCols){
        System.out.print("* ");
       } else{
        System.out.print("  ");
       }
        
       }
      
       System.out.println();
     }
             
   
      
  }
    public static void main(String arg[]){
        
         hollow_rec(4, 5);

    }
}
