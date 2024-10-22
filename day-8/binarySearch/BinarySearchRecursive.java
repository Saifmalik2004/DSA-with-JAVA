// RecursiveBinarySearch.java

public class BinarySearchRecursive {

    // Method for performing binary search recursively
    public static int binarySearchRecur(int number[], int key, int start, int end) {
        // Base case: if start index exceeds end index, the key is not found
        if (start <= end) {
            // Calculate the middle index
            int mid = start + (end - start) / 2;

            // If the key is greater than the middle element, search in the right half
            if (key > number[mid]) {
                return binarySearchRecur(number, key, mid + 1, end); // Recursive call for right half
            } 
            // If the key is less than the middle element, search in the left half
            else if (key < number[mid]) {
                return binarySearchRecur(number, key, start, mid - 1); // Recursive call for left half
            } 
            // If the key is equal to the middle element, return the index (1-based)
            else {
                return mid + 1; // Return the index (1-based)
            }
        }
        return -1; // Key not found, return -1
    }

    // Main method to test the recursive binary search
    public static void main(String[] args) {
        // Sample sorted array
        int number[] = {1, 2, 3, 4, 5, 6, 7, 8}; 
        int key = 5; // Key to be searched

        // Call the recursive binary search method and store the result
        int result = binarySearchRecur(number, key, 0, number.length - 1);
        
        // Check if the result is negative, meaning the key was not found
        if (result < 0) {
            System.out.println("Not found"); // Print not found message
        } else {
            // Print the index where the key was found (1-based)
            System.out.println("Key found at index: " + result);
        }
    }
}
