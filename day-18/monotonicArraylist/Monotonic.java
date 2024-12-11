import java.util.ArrayList;

public class Monotonic {

    // Method to check if a list is monotonic (either entirely non-increasing or non-decreasing)
    public static boolean montonic(ArrayList<Integer> list) {
        boolean inc = true; // Flag to track if the list is non-decreasing
        boolean dec = true; // Flag to track if the list is non-increasing

        // Iterate through the list to compare adjacent elements
        for (int i = 0; i < list.size() - 1; i++) {
            // If the current element is less than or equal to the next, it's not strictly decreasing
            if (list.get(i) <= list.get(i + 1)) {
                dec = false;
            } 
            // If the current element is greater than or equal to the next, it's not strictly increasing
            else if (list.get(i) >= list.get(i + 1)) {
                inc = false;
            }
        }

        // Return true if the list is either non-decreasing or non-increasing
        return inc || dec;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // Initialize the input list

        // Add elements to the list
        list.add(1);
        list.add(9);
        list.add(2);
        list.add(3);

        // Call the montonic method and print the result
        System.err.println(montonic(list)); // Output whether the list is monotonic
    }
}