import java.util.Stack;

public class StackJFC {

    // Method to find the next greater element for each element in the array
    public static void nextGreater(int arr[], int nextG[]) {
        Stack<Integer> s = new Stack<>();  // Stack to store indices of array elements
        
        // Traverse the array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            
            // Pop elements from the stack while they are less than or equal to the current element
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            
            // If the stack is empty, there is no greater element to the right, set -1
            if (s.isEmpty()) {
                nextG[i] = -1;
            } else {
                // If the stack is not empty, the next greater element is the one at the index on top of the stack
                nextG[i] = arr[s.peek()];
            }
            
            s.push(i);  // Push the current index onto the stack
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 3, 4, 0, 7, 8};  // Array of integers
        int nextG[] = new int[arr.length];  // Array to store the next greater element for each element

        nextGreater(arr, nextG);  // Find the next greater element for each element in the array

        // Print the next greater element for each element in the array
        for (int i = 0; i < nextG.length; i++) {
            System.out.print(nextG[i] + " ");
        }
        System.out.println();
    }
}
