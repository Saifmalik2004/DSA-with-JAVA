
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Brute {
    public static List<List<Integer>>  triplet(int arr[]) {
        int n=arr.length;
        Set<List<Integer>> set =new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k =j+1; k < n; k++) {
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer> temp= Arrays.asList(arr[i],arr[j],arr[k]);
                        temp.sort(null);
                        set.add(temp);
                    }
                }
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
