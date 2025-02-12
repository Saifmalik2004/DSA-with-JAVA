import java.util.Arrays;

public class Optimize1 {

    // Optimized merge using two pointers and swapping
    public static void merge(long a[], long b[]) {
        int n = a.length;
        int m = b.length;
        int right = n - 1;  // Pointer for a[] (starting from the largest element)
        int left = 0;  // Pointer for b[] (starting from the smallest element)

        // Compare and swap the largest element from a[] and the smallest element from b[]
        while (right >= 0 && left < m) {
            if (a[right] > b[left]) {
                // Swap the elements
                long temp = a[right];
                a[right] = b[left];
                b[left] = temp;
                right--;
                left++;
            } else {
                break;
            }
        }

        // Sort both arrays after the swap
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        long[] a = {1, 3, 5, 7};
        long[] b = {0, 2, 6, 8, 9};

        // Call the merge function
        merge(a, b);

        // Print merged arrays
        System.out.println("Merged arrays:");
        System.out.println("A: " + Arrays.toString(a));
        System.out.println("B: " + Arrays.toString(b));
    }
}
