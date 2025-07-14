import java.util.ArrayList;

// Class to find leaders in an array using a brute-force approach.
public class LeadersInArray {

    // Method to find and print leaders in the given array.
    public static void leader(int arr[]) {
        int n = arr.length; // Length of the array.
        ArrayList<Integer> leader = new ArrayList<>(); // List to store leaders.

        // Iterate through the array to check each element.
        for (int i = 0; i < n; i++) {
            int curr = arr[i]; // Current element.
            boolean flag = true; // Flag to determine if the current element is a leader.

            // Compare the current element with all elements to its right.
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > curr) { // If any element to the right is greater, it's not a leader.
                    flag = false;
                    break;
                }
            }

            // If the element is a leader, add it to the list.
            if (flag) {
                leader.add(arr[i]);
            }
        }

        // Print all leaders stored in the list.
        for (Integer elem : leader) {
            System.out.print(elem + " ");
        }
    }

    // Main method to test the functionality.
    public static void main(String[] args) {
        int arrr[] = {10, 22, 12, 3, 0, 6}; // Input array.
        leader(arrr); // Call the leader method.
    }


    
}
