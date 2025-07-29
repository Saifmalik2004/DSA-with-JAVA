public class Brute {

    public static int kth(int a[], int b[], int k) {

        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;

        int[] merge = new int[n];
        int i = 0, j = 0, idx = 0;

        // Merge both arrays
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                merge[idx++] = a[i++];
            } else {
                merge[idx++] = b[j++];
            }
        }

        // Add remaining elements from array a
        while (i < n1) {
            merge[idx++] = a[i++];
        }

        // Add remaining elements from array b
        while (j < n2) {
            merge[idx++] = b[j++];
        }


        return merge[k]; // Return the k-th element (0-based index)
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5};
        int[] b = {2, 3, 6};

        System.out.println("K-th element is: " + kth(a, b, 5));
    }
}
