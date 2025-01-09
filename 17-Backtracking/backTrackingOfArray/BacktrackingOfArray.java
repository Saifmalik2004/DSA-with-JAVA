// Backtracking example with an array in Java
public class BacktrackingOfArray {

    // Recursive backtracking function
    public static void backtrack(int arr[], int i, int val) {
        // Base case: If we reach the end of the array
        if (i == arr.length) {
            // Print the current state of the array
            printArr(arr);
            return;
        }

        // Step 1: Assign the current value to the array
        arr[i] = val;

        // Step 2: Recursive call to the next index with incremented value
        backtrack(arr, i + 1, val + 1);

        // Step 3: Backtracking step - modify the current array value
        arr[i] = arr[i] - 2;
    }

    // Utility function to print the elements of the array
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); 
    }

    // Main function to execute the program
    public static void main(String[] args) {
        // Create an array of size 5
        int arr[] = new int[5];

        backtrack(arr, 0, 1);
        printArr(arr);
    }
}
