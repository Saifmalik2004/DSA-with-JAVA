import java.util.Stack;

public class StackJFC {

    // Method to find the Nearest Smaller Element to the Right (nextRS)
    public static void nextRSmallest(int arr[], int nextRL[]) {
        Stack<Integer> s = new Stack<>(); // Stack to store indices of array elements

        // Traverse the array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {

            // Pop elements from the stack until we find a smaller element or stack is empty
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            // If stack is empty, there is no smaller element to the right
            if (s.isEmpty()) {
                nextRL[i] = arr.length; // Use array length as the boundary
            } else {
                // Top of the stack gives the index of the next smaller element
                nextRL[i] = s.peek();
            }

            // Push the current index onto the stack
            s.push(i);
        }
    }

    // Method to find the Nearest Smaller Element to the Left (nextLS)
    public static void nextLSmallest(int arr[], int nextLS[]) {
        Stack<Integer> s = new Stack<>(); // Stack to store indices of array elements

        // Traverse the array from left to right
        for (int i = 0; i < arr.length; i++) {

            // Pop elements from the stack until we find a smaller element or stack is empty
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            // If stack is empty, there is no smaller element to the left
            if (s.isEmpty()) {
                nextLS[i] = -1; // Use -1 as the boundary
            } else {
                // Top of the stack gives the index of the next smaller element
                nextLS[i] = s.peek();
            }

            // Push the current index onto the stack
            s.push(i);
        }
    }

    // Method to calculate the maximum rectangle area in the histogram
    public static int maxArea(int arr[]) {
        // Arrays to store the nearest smaller element indices
        int nextRS[] = new int[arr.length];
        int nextLS[] = new int[arr.length];

        // Fill the nextRS and nextLS arrays
        nextRSmallest(arr, nextRS);
        nextLSmallest(arr, nextLS);

        int max = 0; // Variable to store the maximum area

        // Calculate the maximum area for each bar
        for (int i = 0; i < arr.length; i++) {
            // Width of the rectangle = distance between nextRS and nextLS indices - 1
            int width = nextRS[i] - nextLS[i] - 1;

            // Area = height of the bar * width
            int area = arr[i] * width;

            // Update the maximum area
            max = Math.max(max, area);
        }

        return max; // Return the maximum rectangle area
    }

    public static void main(String[] args) {
        // Example histogram heights
        int arr[] = {2, 4};

        // Print the maximum rectangle area
        System.out.println(maxArea(arr));
    }
}
