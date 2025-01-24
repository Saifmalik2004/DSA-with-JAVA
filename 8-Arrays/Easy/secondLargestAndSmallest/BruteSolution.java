import java.util.ArrayList;
import java.util.Collections;

public class BruteSolution {

    // Method to find the second smallest and second largest using a brute force approach
    public static int[] findSlargestAndSamllest(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>(); // Use a list to store the elements

        // Add all elements of the array to the list
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        // Sort the list in ascending order
        Collections.sort(list);

        // Get the second smallest and second largest elements
        int sSmallest = list.get(1);
        int sLargest = list.get(list.size() - 2);

        return new int[]{sSmallest, sLargest}; // Return them as an array
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 2}; // Input array

        // Get the result and store it in `ans`
        int[] ans = findSlargestAndSamllest(arr);

        // Print the result
        for (Object elem : ans) {
            System.out.print(elem+" ");
        }
    }
}
