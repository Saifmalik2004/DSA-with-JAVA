import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Optimize {

    public static int bookAlocate(ArrayList<Integer> arr,int n, int m) {
        
        if (n < m) return -1;

        long sum = 0;
        for (int elem : arr) {
            sum += elem;
        }
        
        int low = Collections.max(arr); // Get the maximum element
        int high = (int) sum;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(arr, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isValid(ArrayList<Integer> arr, int maxAl, int m) {
        int student = 1, pages = 0;

        for (int num : arr) {
            if (pages + num > maxAl) {
                student++;
                pages = num;
                if (student > m) return false; // More students required
            } else {
                pages += num;
            }
        }
        return student <= m;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(bookAlocate(arr,arr.size(), 2));
    }
}
