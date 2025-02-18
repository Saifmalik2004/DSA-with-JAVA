public class Optimize {
    // Function to find minimum required ship capacity
    public static int minShipingDay(int[] weight, int days) {
        int low = Integer.MIN_VALUE;
        long high = 0;
        
        // Determine initial search bounds
        for (int elem : weight) {
            low = Math.max(low, elem); // Minimum ship capacity should be at least the max package weight
            high += elem; // Maximum ship capacity could be sum of all packages
        }

        // Binary Search to find optimal ship capacity
        while (low <= high) {
            int mid = low + (int) (high - low) / 2;

            if (computeDays(weight, mid) <= days) {
                high = mid - 1; // Try for a smaller capacity
            } else {
                low = mid + 1; // Increase capacity
            }
        }
        return low;
    }

    // Helper function to compute the number of days required for a given capacity
    public static int computeDays(int arr[], int cap) {
        int days = 1;
        int load = 0;
        
        for (int packageWeight : arr) {
            if (load + packageWeight > cap) {
                days++; // Move to next day
                load = packageWeight;
            } else {
                load += packageWeight;
            }
        }
        return days;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(minShipingDay(arr, 5));
    }
}