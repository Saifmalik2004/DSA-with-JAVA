
public class Optimize {
    public static int minEatingSpeed(int[] piles, int h) {
        // Step 1: Find the maximum value in piles
        int max = 0; // No need for long, max will fit in int range
        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        // Step 2: Binary search on speed (1 to max)
        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (computeTime(piles, h, mid)) {
                high = mid - 1; // Try a smaller speed
            } else {
                low = mid + 1; // Increase speed
            }
        }

        return low;
    }

    public static boolean computeTime(int arr[], int h, int num) {
        long total = 0; // Use long to prevent overflow in summation
        for (int pile : arr) {
            total += (pile + num - 1) / num;
            if (total > h) return false; // Early exit optimization
        }
        return total <= h;
    }
    public static void main(String[] args) {
        int arr[]={3,6,7,11};

        System.out.println(minEatingSpeed(arr, 8));
    }
}
