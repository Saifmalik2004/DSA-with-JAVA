public class Optimize {

    // Method to sort an array containing only 0s and 1s
    public static void sortZeroesAndOne(int[] arr) {
        int nextZero = 0; // Pointer to track the position of the next zero
        
        // Iterate through the array
        for(int i = 0; i < arr.length; i++) {

            // If the current element is 0, swap it with the element at nextZero index
            if(arr[i] == 0) {
                int temp = arr[nextZero];  // Store value at nextZero
                arr[nextZero] = arr[i];    // Move 0 to the correct position
                arr[i] = temp;             // Swap original value with zero
                nextZero += 1;             // Move the nextZero pointer forward
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0}; // Input array containing 0s and 1s
        
        sortZeroesAndOne(arr); // Call method to sort the array
        
        // Print the sorted array
        for (int elem : arr) {      
            System.out.print(elem + " "); // Print each element with a space
        }
    }
}
