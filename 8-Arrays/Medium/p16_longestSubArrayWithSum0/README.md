# Maximum Length Subarray with Sum 0

## Problem Statement
Given an integer array, find the length of the longest subarray with a sum of 0. 

## Example
### Input:
```java
int arr[] = {1, -1, 0, 0, 2, 3, -3, 0, 1};
```
### Output:
```
6
```
### Explanation:
The longest subarray with sum 0 is `{1, -1, 0, 0, 2, 3, -3, 0, 1}` where the maximum subarray with sum 0 is `{0, 0, 2, 3, -3, 0}` with length `6`.

## Intuition
The problem is about finding the longest contiguous subarray where the sum of its elements equals 0. We need an efficient way to track subarrays and their sums as we iterate through the array. Using a hashmap can help store previously encountered sums, enabling us to determine if a subarray with sum 0 exists.

## Approach (Step by Step Explanation)
1. **Initialize Variables:**
   - Create a hashmap (`HashMap<Integer, Integer>`) to store the first occurrence of a prefix sum.
   - Use an integer `sum` to track the cumulative sum of elements while iterating.
   - Use an integer `maxi` to keep track of the maximum length found so far.

2. **Iterate through the Array:**
   - Keep adding elements to `sum` as we traverse the array.
   - If `sum == 0`, update `maxi` to `i + 1` because a subarray from the start to `i` has sum 0.
   - If `sum` has been seen before, a subarray with sum 0 exists between the stored index and the current index. Update `maxi` accordingly.
   - Otherwise, store the first occurrence of the `sum` in the hashmap.

3. **Return the Maximum Length:**
   - At the end of traversal, `maxi` contains the length of the longest subarray with sum 0.

## Algorithm (Pseudocode)
```plaintext
function findMaxLengthSubarray(arr, n):
    Initialize hashmap to store prefix sum indices
    Initialize maxi = 0 and sum = 0
    
    For i = 0 to n-1:
        sum += arr[i]
        
        If sum == 0:
            maxi = i + 1
        
        If sum exists in hashmap:
            maxi = max(maxi, i - hashmap[sum])
        Else:
            Store sum with its index in hashmap
    
    Return maxi
```

## Code Walkthrough
```java
import java.util.HashMap;

public class Optimize {
    public static int find(int arr[], int n) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (mpp.get(sum) != null) {
                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {
                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int a[] = {1, -1, 0, 0, 2, 3, -3, 0, 1};
        System.out.println(find(a, a.length));
    }
}
```

## Time Complexity Analysis
- **O(N)**: The loop iterates through the array once, and each lookup and insertion in the hashmap is O(1) on average.
- **Space Complexity: O(N)**: In the worst case, the hashmap stores all `N` elements.

## Key Features
- Uses HashMap to optimize the search for previous sums.
- Efficient O(N) solution compared to a brute-force O(N^2) approach.
- Works for both positive and negative integers in the array.

## Tips
- If the problem asks for the subarray instead of length, store the indices and extract it.
- Edge cases: Arrays with all zeroes should return their full length.
- Handle duplicate prefix sums correctly by keeping track of the first occurrence only.

## Conclusion
This problem is efficiently solved using a hashmap-based approach in O(N) time complexity. Understanding prefix sums is key to mastering subarray-related problems in competitive programming and interviews.