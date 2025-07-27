import java.util.ArrayList;
import java.util.Arrays;

public class Optimize {

    public static int partion(ArrayList<Integer> arr,int n, int m) {

        int low = 0,high=0;

        for (int elem : arr) {
            low=Math.max(low,elem);
            high += elem;

        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(arr, mid, m)) {
              
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean isValid(ArrayList<Integer> arr, int maxAl, int m) {
        int painters = 1, workspace = 0;

        for (int num : arr) {
            if (workspace + num > maxAl) {
                painters++;
                workspace = num;
                if (painters > m) return false; // More students required
            } else {
                workspace += num;
            }
        }
        return painters <= m;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(partion(arr,arr.size(), 2));
    }
}
