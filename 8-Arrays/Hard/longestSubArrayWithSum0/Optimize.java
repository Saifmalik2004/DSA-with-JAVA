
import java.util.HashMap;


public class Optimize {
    public static int find(int arr[],int n) {
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0; 

        for(int i = 0;i<n;i++) {

            sum += arr[i]; 

            if(sum == 0) {
                maxi = i + 1; 
            }
            else {
                if(mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum)); 
                }
                else {

                    mpp.put(sum, i); 
                }
            }
        }
        return maxi; 
    }
    public static void main(String[] args) {
        int a[]={1,-1,0,0,2,3,-3,0,1};

       
        System.out.println( find(a, a.length));
     }
}
