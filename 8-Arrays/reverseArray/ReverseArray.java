import java.util.Arrays;

public class ReverseArray {

    // Method to reverse the array
    public static void reverseArray(int number[]) {
        int first = 0;               // Pointer to the first element
        int end = number.length - 1;  // Pointer to the last element
        int temp;                     // Temporary variable for swapping

        // Loop until the first index crosses the end index (i.e., until the middle is reached)
        while (first < end) {
            // Step 1: Store the value of the first element in a temporary variable
            temp = number[first];

            // Step 2: Replace the first element with the value of the last element
            number[first] = number[end];

            // Step 3: Replace the last element with the original value of the first element (stored in temp)
            number[end] = temp;

            // Move the first pointer to the right and the end pointer to the left
            first++; 
            end--;
        }
    }

    // Main method to test the reverse logic
    public static void main(String[] args) {
        int number[] = {1, 2, 3, 4, 5, 6};  // Example array

        reverseArray(number);  // Call to reverse the array

        // Output the reversed array
        System.out.println(Arrays.toString(number));
    }
}
