import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Brute {
    // Function to merge overlapping intervals
    public static List<List<Integer>> overlapInterval(int arr[][]) {
        
        // Sort the intervals based on the starting time
        Arrays.sort(arr, (int a[], int b[]) -> a[0] - b[0]);

        // Initialize an empty list to store the merged intervals
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through the sorted intervals
        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0]; // Start of the current interval
            int end = arr[i][1];   // End of the current interval

            // Skip if the current interval ends before or when the last merged interval ends
            // (this ensures we don't merge intervals unnecessarily)
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue; // Skip this interval as it doesn't contribute to the merged result
            }

            // Check for overlaps with the next intervals
            for (int j = i + 1; j < arr.length; j++) {
                // If there is an overlap (i.e., the next interval starts before or when the current one ends)
                if (arr[j][0] <= end) {
                    // Extend the end time to the maximum end of the overlapping intervals
                    end = Math.max(end, arr[j][1]);
                } else {
                    break; // No more overlapping intervals, break out of the inner loop
                }
            }

            // Add the merged interval to the answer list
            ans.add(Arrays.asList(start, end));
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
