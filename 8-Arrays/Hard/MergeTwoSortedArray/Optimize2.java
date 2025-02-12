import java.util.Arrays;

public class Optimize2 {

    public static void merge(long a[], long b[]) {
        int n = a.length;
        int m = b.length;
        int len = n + m;
        int gap = (len / 2) + (len % 2); // Calculate initial gap

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                // Case 1: Both elements in array 'a'
                if (left < n && right < n) {
                    if (a[left] > a[right]) {
                        swap(a, left, right);
                    }
                } 
                // Case 2: Left in 'a', Right in 'b'
                else if (left < n && right >= n) {
                    if (a[left] > b[right - n]) {
                        swap(a, b, left, right - n);
                    }
                } 
                // Case 3: Both elements in array 'b'
                else if (left >= n && right >= n) {
                    if (b[left - n] > b[right - n]) {
                        swap(b, left - n, right - n);
                    }
                }

                left++;
                right++;
            }

            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2); // Reduce the gap
        }
    }

    // Swap elements within the same array
    public static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Swap elements between 'a' and 'b'
    public static void swap(long[] a, long[] b, int i, int j) {
        long temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

    public static void main(String[] args) {
        long[] a = {1, 3, 5, 7};
        long[] b = {0, 2, 6, 8, 9};

        merge(a, b);

        System.out.println("Merged arrays:");
        System.out.println("A: " + Arrays.toString(a));
        System.out.println("B: " + Arrays.toString(b));
    }
}
