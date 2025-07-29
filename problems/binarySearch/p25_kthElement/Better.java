public class Better {

    public static int kth(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0, j = 0, count = 0;

        // Merge like in merge sort until we reach the kth element
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (count == k) return a[i];
                i++;
            } else {
                if (count == k) return b[j];
                j++;
            }
            count++;
        }

        // If elements are left in array a
        while (i < n1) {
            if (count == k) return a[i];
            i++;
            count++;
        }

        // If elements are left in array b
        while (j < n2) {
            if (count == k) return b[j];
            j++;
            count++;
        }

        return -1; // if k is out of bounds
    }

    public static void main(String[] args) {
        int a[] = {1, 4, 5};
        int b[] = {2, 3, 6};
        System.out.println(kth(a, b, 0)); // Output: 1
    }
}
