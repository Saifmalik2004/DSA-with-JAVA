import java.util.ArrayList;

public class PairSum {

    // Method to check if there exists a pair in the list whose sum equals the target value
    public static boolean pairSum(ArrayList<Integer> arr, int target) {
        int left = 0; // Pointer starting at the beginning of the list
        int right = arr.size() - 1; // Pointer starting at the end of the list

        // Use a two-pointer technique to find the target pair
        while (left < right) {
            int sum = arr.get(left) + arr.get(right); // Calculate the sum of the current pair

            // If the sum equals the target, return true
            if (sum == target) {
                return true;
            }
            // If the sum is less than the target, move the left pointer to increase the sum
            else if (sum < target) {
                left++;
            }
            // If the sum is greater than the target, move the right pointer to decrease the sum
            else {
                right--;
            }
        }

        // If no pair is found, return false
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(); // Initialize the input list

        // Add elements to the list
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        // Call the pairSum method and print the result
        System.out.println(pairSum(arr, 7)); // Expected output: true
    }
}
