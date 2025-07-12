public class Better {
    /**
     * Sorts an array containing only 0s, 1s, and 2s using the counting method.
     * This approach counts the occurrences of each number and then fills the array accordingly.
     */
    public static void sort012(int arr[]) {
        int zero = 0, one = 0;

        // Count occurrences of 0s, 1s, and 2s
        for (int num : arr) {
            switch (num) {
                case 0 -> zero++;
                case 1 -> one++;
            }
        }

        // Overwrite the array based on counted values
        for (int i = 0; i < arr.length; i++) {
            if (zero > 0) {
                arr[i] = 0;
                zero--;
            } else if (one > 0) {
                arr[i] = 1;
                one--;
            } else {
                arr[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 2, 2, 0, 0, 1, 1, 0, 1, 2, 0, 0};
        sort012(arr);

        // Print sorted array
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }
}
