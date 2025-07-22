import java.util.Arrays;

public class Optimize2 {

    /**
     * Merges two sorted arrays a[] and b[] in-place using the Gap method.
     * This avoids using extra space while maintaining sorted order.
     */
    public static void merge(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        int len = n + m;

        // Initial gap is half of total length (rounded up)
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            // Compare and swap elements with gap difference
            while (right < len) {
                if (left < n && right >= n) {
                    // Left in 'a' and Right in 'b'
                    swapIfGreater(a, b, left, right - n);
                } else if (left >= n) {
                    // Both in 'b'
                    swapIfGreater(b, b, left - n, right - n);
                } else {
                    // Both in 'a'
                    swapIfGreater(a, a, left, right);
                }
                left++;
                right++;
            }

            // Reduce gap using ceiling division
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    /**
     * Swaps elements a[i] and b[j] if a[i] > b[j]
     */
    public static void swapIfGreater(int[] a, int[] b, int i, int j) {
        if (a[i] > b[j]) {
            int temp = a[i];
            a[i] = b[j];
            b[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {0, 2, 6, 8, 9};

        merge(a, b);

        System.out.println("Merged arrays:");
        System.out.println("A: " + Arrays.toString(a));
        System.out.println("B: " + Arrays.toString(b));
    }
}
