import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Optimize {
    // Function to merge overlapping intervals (optimized approach)
    public static List<List<Integer>> overlapInterval(int arr[][]) {
        
        // Sort the intervals based on the starting time
        Arrays.sort(arr, (int a[], int b[]) -> a[0] - b[0]);

        // Initialize an empty list to store the merged intervals
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through the sorted intervals
        for (int i = 0; i < arr.length; i++) {
            
            // If the list of merged intervals is empty, or if the current interval does not overlap
            // with the last merged interval, add the current interval to the result
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                // Otherwise, merge the current interval with the last one by extending the end time
                int maxEnd = Math.max(arr[i][1], ans.get(ans.size() - 1).get(1));
                ans.get(ans.size() - 1).set(1, maxEnd); // Update the last interval's end time
            }
        }
       
        return ans; // Return the merged intervals
    }

    public static void main(String[] args) {
        // Test intervals with some overlaps
        int arr[][] = {{2, 4}, {16, 17}, {2, 6}, {8, 9}, {9, 1}, {15, 18}, {8, 10}, {1, 3}};
        
        // Call the function to merge intervals
        List<List<Integer>> result = overlapInterval(arr);
        
        // Print the result (merged intervals)
        System.out.println(result);
    }
} 
