public class Optimize {

    // Function to compute square root using Binary Search
    public static int sqRoot(long x) {

        // Initialize the lower boundary of search space
        long low = 1;

        // Initialize the upper boundary to x/2 for optimization
        long high = x / 2;

        // Binary Search loop runs until the search space is valid
        while (low <= high) {

            // Mid is calculated in a safe way to avoid overflow
            long mid = low + (high - low) / 2;

            // If mid squared is less than or equal to x,
            // search in the right half (larger values)
            if (mid * mid <= x) {
                low = mid + 1;
            } 
            // Else search in the left half (smaller values)
            else {
                high = mid - 1;
            }
        }

        // When loop finishes, 'high' will be the floor value of square root
        return (int) high;
    }

    public static void main(String[] args) {

        // Testing the square root function with value 100
        System.out.println(sqRoot(100));
    }
}
