// IterativeBinarySearch.java

public class BinarySearchIterative {

   
    public static int binarySearch(int number[], int key) {
        int start = 0; 
        int end = number.length - 1; 

        // Loop until the start index is less than or equal to the end index
        while (start <= end) {
            // Calculate the middle index
            int mid = (start + end) / 2;

            // If the key is greater than the middle element, search in the right half
            if (key > number[mid]) {
                start = mid + 1; // Move start to mid + 1
            } 
            // If the key is less than the middle element, search in the left half
            else if (key < number[mid]) {
                end = mid - 1; // Move end to mid - 1
            } 
            // If the key is equal to the middle element, return the index (1-based)
            else {
                return mid + 1; // Return the index (1-based)
            }
        }
        return -1; // Key not found, return -1
    }

  
    public static void main(String[] args) {
        
        int number[] = {1, 2, 3, 4, 5, 6, 7, 8}; 
        int key = 5; 

        
        int result = binarySearch(number, key);
        
        // Check if the result is negative, meaning the key was not found
        if (result < 0) {
            System.out.println("Not found");
        } else {
           
            System.out.println("Key found at index: " + result);
        }
    }
}
