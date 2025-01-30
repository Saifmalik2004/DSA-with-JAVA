
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Better {
    public static List<List<Integer>>  triplet(int arr[]) {
        int n=arr.length;
        Set<List<Integer>> set =new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet =new HashSet<>();
            for (int j = i+1; j < n; j++) {
                
                int third =-(arr[i]+arr[j]);
                 
                if(hashSet.contains(third)){
                    List<Integer> temp= Arrays.asList(arr[i],arr[j],third);
                        temp.sort(null);
                        set.add(temp);
                }
                hashSet.add(arr[j]); 
                
            }
        }
        List<List<Integer>> ans =new ArrayList<>(set);
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={-1,0,1,2,-1,4};

        List<List<Integer>> result=triplet(arr);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
