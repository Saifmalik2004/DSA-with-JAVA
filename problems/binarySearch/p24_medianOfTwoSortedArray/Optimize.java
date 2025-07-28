public class Optimize {
    public static double median(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;

        // Always binary search on the smaller array
        if (n1 > n2) {
            return median(b, a);
        }

        int n = n1 + n2;
        int left = (n + 1) / 2;
        int low = 0;
        int high = n1;

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;

            int l1 = mid1 > 0 ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? b[mid2 - 1] : Integer.MIN_VALUE;

            int r1 = mid1 < n1 ? a[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0.0; // Should never reach here
    }

    public static void main(String[] args) {
        int arr1[] = {1, 4, 5};
        int arr2[] = {2, 3, 6};
        System.out.println(median(arr1, arr2)); // Output should be 3.5
    }
}
