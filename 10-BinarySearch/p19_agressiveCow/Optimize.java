import java.util.Arrays;

public class Optimize {

    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (possibleToPlace(stalls, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean possibleToPlace(int[] stalls, int k, int dis) {
        int cows = 1;
        int lastPlace = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlace >= dis) {
                cows++;
                lastPlace = stalls[i];
            }

            if (cows == k) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 4, 7, 10, 9};
        System.out.println(aggressiveCows(arr, 4));
    }
}
