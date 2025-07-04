// LinearSearch.java

public class LinearSearch {
    
    // Method to perform linear search in the array
    public static int linearSearchFunc(int numbers[], int key) {
        // Iterate through the entire array
        for (int i = 0; i < numbers.length; i++) {
            // Check if the current element matches the key
            if (key == numbers[i]) {
                return i + 1; // Return index + 1 if found (1-based index)
            }
        }
        return -1; // Return -1 if the key is not found
    }

    // Main method to test the linear search function
    public static void main(String[] args) {
        int num[] = {2, 4, 6, 8, 10, 992, 14, 16, 18, 20}; // Sample array
        int key = 8; // The key to search for
        
        // Perform linear search
        int result = linearSearchFunc(num, key);
        
        // Print the result
        if (result < 0) {
            System.out.println("Not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
