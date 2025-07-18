import java.util.ArrayList;
import java.util.List;

// Class to find leaders in an array using an optimized approach.
public class Optimize {

    // Method to find and print leaders in the given array.
    public static void leader(int arr[]) {
        int n = arr.length; // Length of the array.
        ArrayList<Integer> leader = new ArrayList<>(); // List to store leaders.
        int max = Integer.MIN_VALUE; // Initialize max as the smallest possible value.

        // Traverse the array from right to left.
        for (int i = n - 1; i >= 0; i--) {
            // If the current element is greater than the max seen so far, it's a leader.
            if (arr[i] > max) {
                leader.add(arr[i]); // Add the leader to the list.
            }
            // Update the max value to the maximum of the current element and the previous max.
            max = Math.max(arr[i], max);
        }

        // Print all leaders stored in the list.
        for (Integer elem : leader) {
            System.out.print(elem + " ");
        }
    }

    // Main method to test the functionality.
    public static void main(String[] args) {
        int arrr[] = {10, 22, 12, 3, 0, 6}; // Input array.
        lead(arrr); // Call the leader method.
    }
//one more approach
    public static void lead(int arr[]) {
        List<Integer> list= new ArrayList<>();
        list.add(arr[arr.length-1]);
        for (int i = arr.length-2; i >=0; i--) {
                if(arr[i]>list.get(list.size()-1)){
                    list.add(arr[i]);
                }
            
        }

         for (Integer elem : list) {
            System.out.print(elem + " ");
        }

        
        
    }
}
