public class Optimize {
    // Function to find duplicate and missing elements in the array
    public static int[] find(int a[]) {
        int n = a.length;

        // Calculate the sum of first n natural numbers and sum of squares of first n natural numbers
        long sumN = n * (n + 1) / 2;
        long sumN2 = n * (n + 1) * (2 * n + 1) / 6;

        // Calculate the actual sum and sum of squares from the array
        long sum = 0;
        long sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            sum2 += a[i] * a[i];
        }

        // Find the difference between the expected and actual sums
        long val1 = sum - sumN;
        long val2 = sum2 - sumN2;

        // Calculate the duplicate and missing values using the difference
        val2 = val2 / val1;

        // Solve the equations for duplicate (x) and missing (y)
        long x = (val1 + val2) / 2;
        long y = x - val1;

        // Return the duplicate and missing numbers
        return new int[]{(int) x, (int) y};
    }

    // Main method to test the find function
    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 1, 6, 1};

        // Print the duplicate and missing numbers
        for (int elem : find(arr)) {
            System.out.println(elem);
        }
    }
}
