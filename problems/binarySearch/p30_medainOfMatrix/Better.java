public class Better {
    public static int median(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Finding the minimum and maximum elements
        for (int i = 0; i < n; i++) {
            low = Math.min(low, arr[i][0]);
            high = Math.max(high, arr[i][m - 1]);
        }

        // Binary search on the value range
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int less = countLessThanEqual(arr, mid);

            if (less <= (n * m) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    // Counts number of elements <= x in the entire matrix
    public static int countLessThanEqual(int[][] arr, int x) {
        int count = 0;
        for (int[] row : arr) {
            count += upperBound(row, x);
        }
        return count;
    }

    // Returns index of first element greater than x
    public static int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        System.out.println("Median (Better): " + median(matrix));
    }
}
