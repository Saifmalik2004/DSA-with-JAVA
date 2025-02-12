public class Brute {

    // Merges two sorted arrays a[] and b[]
    public static void merge(long a[], long b[]) {
        int n = a.length;
        int m = b.length;
        int start1 = 0, start2 = 0, idx = 0;

        // Temporary array to store the merged result
        long[] ans = new long[n + m];

        // Merge the arrays
        while (start1 < n && start2 < m) {
            if (a[start1] <= b[start2]) {
                ans[idx++] = a[start1++];
            } else {
                ans[idx++] = b[start2++];
            }
        }

        // Add any remaining elements from a[]
        while (start1 < n) {
            ans[idx++] = a[start1++];
        }

        // Add any remaining elements from b[]
        while (start2 < m) {
            ans[idx++] = b[start2++];
        }

        // Copy merged result back to original arrays
        for (int i = 0; i < n + m; i++) {
            if (i < n) a[i] = ans[i];  // Copy back to a[]
            else b[i - n] = ans[i];  // Copy back to b[]
        }
    }

    public static void main(String[] args) {
        long[] a = {1, 3, 5, 7};
        long[] b = {0, 2, 6, 8, 9};
        
        // Call the merge function
        merge(a, b);

        // Print merged arrays
        for (long elem : a) {
            System.out.print(elem + " ");
        }
        for (long elem : b) {
            System.out.print(elem + " ");
        }
    }
}
