public class Optimize {

    public static int findKthElement(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;

        // Always binary search on smaller array
        if (n1 > n2) {
            return findKthElement(b, a, k);
        }

        // 1-based indexing for kth element
        int low = Math.max(0, k - n2);
        int high = Math.min(n1, k);

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = k - mid1;

            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;

            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2); // K-th element
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 4, 5};
        int arr2[] = {2, 3, 6};

        // Let's find 4th smallest element (expected: 4)
        System.out.println(findKthElement(arr1, arr2, 4));
    }
}
