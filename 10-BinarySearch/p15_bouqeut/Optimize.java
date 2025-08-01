public class Optimize {
    public static int minDayBloom(int[] arr, int m, int k) {
        long val = (long) m * k;
        if (val > arr.length) return -1; // Impossible case

        int min = arr[0], max = arr[0];

        // Find min and max in a single loop
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int low = min, high = max;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (possible(arr, mid, m, k)) {
                high = mid; // Try a smaller day count
            } else {
                low = mid + 1; // Increase days
            }
        }
        return low;
    }

    public static boolean possible(int[] days, int day, int m, int flower) {
        int count = 0, noOFBouquet = 0;

        for (int num : days) {
            if (num <= day) { 
                count++; // Valid flower
                if (count == flower) { 
                    noOFBouquet++; // Bouquet formed
                    count = 0; // Reset count
                    if (noOFBouquet == m) return true; // Early stopping
                }
            } else {
                count = 0; // Reset if broken sequence
            }
        }

        return noOFBouquet >= m;
    }

    public static void main(String[] args) {
        int days[] = { 1, 2, 1, 2, 7, 2, 2, 3, 1};

        System.out.println(minDayBloom(days,2,3 )); // Expected Output: Minimum days needed
    }
}
