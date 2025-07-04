import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Brute {
    // Function to find the union of two arrays using LinkedHashMap
    // Function to compute the union of two arrays using HashSet
public static ArrayList<Integer> unionWithSet(int arr[], int arr1[]) {
    Set<Integer> set = new HashSet<>();  // HashSet to store unique elements

    // Step 1: Add elements of arr to the set
    for (int num : arr) {
        set.add(num);
    }

    // Step 2: Add elements of arr1 to the set
    for (int num : arr1) {
        set.add(num);
    }

    // Step 3: Convert set to a sorted list
    ArrayList<Integer> result = new ArrayList<>(set);
    Collections.sort(result);  // Ensure the result is sorted

    return result;
}


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6}; // First array
        int arr1[] = {1, 2, 3, 4, 8, 13, 22}; // Second array

        // Call the union method
        ArrayList<Integer>  ans = unionWithSet(arr, arr1);
        for (int num :ans ) {
            System.out.print(num+" ");
        }
    
    }

    public static void union(int a[],int b[]){
        
    }
}
