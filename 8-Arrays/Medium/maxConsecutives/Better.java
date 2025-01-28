import java.util.Arrays;

public class Better {
    public static void maxConsecutive(int arr[]) {
        int n = arr.length;
        int maxLen = 1; // Stores the maximum length of consecutive elements
        int len = 0;    // Tracks the current sequence length
        Arrays.sort(arr); // Sort the array to bring consecutive elements together
        int last = Integer.MIN_VALUE; // Keeps track of the last element in the sequence

        for (int i = 0; i < n - 1; i++) {
            int curr = arr[i];
            // If current element is one greater than the last element in the sequence
            if (last == curr - 1) {
                len++; // Increment the sequence length
                last = curr;
            } else if (curr != last) { // Reset length if current is not consecutive
                len = 1;
                last = curr;
            }
            maxLen = Math.max(maxLen, len); // Update the maximum sequence length
        }

        System.out.println(maxLen); // Print the result
    }

    public static void main(String[] args) {
        int arr[] = {102, 4, 100, 1, 101, 3, 2, 1};
        maxConsecutive(arr);
    }
}
