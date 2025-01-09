import java.util.ArrayList;
import java.util.Collections;

public class LonelyNum {
    // Function to find all lonely numbers in the ArrayList
    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
        // Step 1: Sort the ArrayList to ensure neighbors are in order
        Collections.sort(nums);

        // Step 2: Create a list to store lonely numbers
        ArrayList<Integer> list = new ArrayList<>();

        // Step 3: Traverse the sorted list to find lonely numbers
        for (int i = 1; i < nums.size() - 1; i++) {
            // Check if the current number is lonely
            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                list.add(nums.get(i));
            }
        }

        // Step 4: Handle edge cases for first and last elements
        if (nums.size() == 1) {
            // If there's only one number, it's lonely by default
            list.add(nums.get(0));
        }
        if (nums.size() > 1) {
            // Check if the first number is lonely
            if (nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }
            // Check if the last number is lonely
            if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
                list.add(nums.get(nums.size() - 1));
            }
        }

        // Step 5: Return the list of lonely numbers
        return list;
    }

    public static void main(String[] args) {
        // Example input ArrayList
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(3);

        // Call the findLonely function and store the result
        ArrayList<Integer> result = findLonely(nums);

        // Print the result
        System.out.println(result);
    }
}

