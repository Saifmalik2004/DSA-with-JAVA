public class SubArrays {

    public static void printSubArray(int[] num) {
        int total = 0;
      
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
               
                for (int k = i; k <= j; k++) {
                    System.out.print(num[k] + " ");
                  
                }
                total++;
                System.out.println();
            }
        }

        System.out.println("Total number of subarrays: " + total);
    }
    

    public static void main(String[] args) {
        int[] num = {2, -4, 6, 8, };
        printSubArray(num);
    }

   
}
