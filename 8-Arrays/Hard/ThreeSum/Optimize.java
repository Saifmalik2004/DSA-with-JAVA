
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Optimize {
    public static List<List<Integer>>  triplet(int[] arr) {
        int n=arr.length;
         List<List<Integer>> res = new ArrayList<>();
        
        
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
           if(i>0 && arr[i]==arr[i-1]) continue;
            int j=i+1;
            int k=n-1;
           while(j<k){
            int sum =arr[i]+arr[j]+arr[k];
            if(sum>0){
                k--;
            }else if(sum<0){
                j++;
            }else{
               res.add(Arrays.asList(arr[i], arr[j], arr[k]));
               j++;
               while(j<k && arr[j]==arr[j-1]) j++;
                
            }
            
           }
        }
        
        return res;
    }
    public static void main(String[] args) {
        int arr[]={-1,0,1,2,-1,4};

        List<List<Integer>> result=triplet(arr);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
