import java.util.ArrayList;

public class Optimize {
    // Function to find the union of two sorted arrays
    public static ArrayList<Integer> union(int arr[], int arr1[]) {
        ArrayList<Integer> union = new ArrayList<>(); // Stores the union of two arrays

        int i = 0, j = 0; // Pointers to traverse the arrays

        // Traverse both arrays simultaneously
        while (i < arr.length && j < arr1.length) {
            if (arr[i] <= arr1[j]) {
                // Add the element from arr if it's not already in the union list
                if (union.isEmpty() || union.get(union.size() - 1) != arr[i]) {
                    union.add(arr[i]);
                }
                i++;
            } else {
                // Add the element from arr1 if it's not already in the union list
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[j]) {
                    union.add(arr1[j]);
                }
                j++;
            }
        }

        // Add remaining elements from arr
        while (i < arr.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr[i]) {
                union.add(arr[i]);
            }
            i++;
        }

        // Add remaining elements from arr1
        while (j < arr1.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr1[j]) {
                union.add(arr1[j]);
            }
            j++;
        }

        return union; // Return the resulting union
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6}; // First sorted array
        int arr1[] = {1, 2, 3, 4, 8, 43, 22, 5, 6}; // Second sorted array

        // Get the union of the two arrays
        ArrayList<Integer> result = union(arr, arr1);

        // Print the union
        System.out.println("Union of the two arrays:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
