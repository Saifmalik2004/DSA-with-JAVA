import java.util.ArrayList;

public class Brute {
    // Method to remove duplicates using an ArrayList
    public static int removeDuplicates(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();  // List to store unique elements
        
        // Loop through the array
        for (int i = 0; i < arr.length; i++) {
            // If the list does not contain the current element
            if (!list.contains(arr[i])) {
                list.add(arr[i]);  // Add it to the list
            }
        }
        
        // Return the size of the list, which represents the number of unique elements
        return list.size();
    }

    public static void main(String[] args) {
        // Sample array
        int[] arr = {1, 1, 2, 2, 3, 3, 4};
        int n = arr.length;
        
        // Calling the method and getting the result
        int uniqueCount = removeDuplicates(arr, n);
        
        // Print the count of unique elements
        System.out.println("Number of unique elements: " + uniqueCount);
    }
}
