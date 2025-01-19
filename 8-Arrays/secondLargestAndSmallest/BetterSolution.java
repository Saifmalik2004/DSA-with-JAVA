public class BetterSolution {

    // Optimized method to find the second largest and second smallest elements
    public static int[] secondLargestSmallest(int arr[]) {
        int n = arr.length;
        int largest = Integer.MIN_VALUE; // Initialize the largest element
        int sLargest = Integer.MIN_VALUE; // Initialize the second largest element
        int smallest = Integer.MAX_VALUE; // Initialize the smallest element
        int sSmallest = Integer.MAX_VALUE; // Initialize the second smallest element

        // Traverse the array to find the largest and smallest elements
        for (int i = 0; i < n; i++) {
            largest = Math.max(largest, arr[i]); // Update the largest element
            smallest = Math.min(smallest, arr[i]); // Update the smallest element
        }

        // Traverse the array again to find the second largest and second smallest elements
        for (int i = 0; i < n; i++) {
            if (arr[i] > sLargest && arr[i] != largest) {
                sLargest = arr[i]; // Update the second largest
            } else if (arr[i] < sSmallest && arr[i] != smallest) {
                sSmallest = arr[i]; // Update the second smallest
            }
        }

        return new int[]{sSmallest, sLargest}; // Return the results as an array
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 2, 7, 2}; // Input array

        // Get the result and store it in `ans`
        int ans[] = secondLargestSmallest(arr);

        // Print the result
        for (Object elem : ans) {
            System.out.print(elem=" ");
        }
    }
}
