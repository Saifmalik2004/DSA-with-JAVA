# Pair Sum 2 Problem

## Problem Statement

Given a rotated sorted array (i.e., a sorted array that has been rotated at some unknown pivot), the task is to determine if there exists a pair of numbers in the array that sum up to a given target value.

### Example

**Input 1:**

```
Array: [11, 15, 6, 8, 9, 10]
Target: 16
```

**Output 1:**

```
true
```

Explanation: The pair `(6, 10)` sums up to `16`.

**Input 2:**

```
Array: [11, 15, 6, 8, 9, 10]
Target: 20
```

**Output 2:**

```
false
```

Explanation: No pair in the array sums up to `20`.

## Approach

We are given a rotated sorted array. The problem can be efficiently solved using a **two-pointer technique** with the following approach:

1. **Identify the Breaking Point (Pivot):**
   - The array is rotated at some point. Find the pivot point where the rotation occurred, which is where the order breaks (i.e., where the next element is smaller than the current element).
   
2. **Two-Pointer Approach:**
   - Once the pivot is found, treat the rotated array as two sorted subarrays:
     - The subarray from the smallest element to the pivot.
     - The subarray from the pivot to the largest element.
   - Use two pointers:
     - One pointer (`left`) starts from the smallest element (just after the pivot).
     - The other pointer (`right`) starts from the largest element (pivot).
   - Move these pointers to find a pair of elements that sum to the target:
     - If the sum of the elements at `left` and `right` equals the target, return `true`.
     - If the sum is less than the target, move the `left` pointer right to increase the sum.
     - If the sum is greater than the target, move the `right` pointer left to decrease the sum.
   - This is done in a circular manner using the modulo operator to handle the array's rotation.

## Algorithm (Pseudo Code)

```
1. Initialize 'bp' to -1 (breaking point).
2. Loop through the array to find the breaking point:
   a. If element[i] > element[i+1], mark 'bp' as i.
3. Set 'left' pointer to (bp + 1) % list.size() (pointing to smallest element).
4. Set 'right' pointer to bp (pointing to largest element).
5. While left != right:
   a. Calculate sum = list[left] + list[right].
   b. If sum == target, return true.
   c. If sum < target, move left pointer to the right.
   d. If sum > target, move right pointer to the left.
6. If no pair found, return false.
```

## Code Explanation

```java
import java.util.ArrayList;

public class PairSumRotated {
    // Function to check if a pair exists
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int bp = -1;

        // Find the breaking point (pivot)
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

        // Initialize pointers
        int left = (bp + 1) % list.size(); // Points to smallest element
        int right = bp; // Points to largest element

        // Two-pointer approach
        while (left != right) {
            int sum = list.get(left) + list.get(right);

            // If the sum matches the target, return true
            if (sum == target) {
                return true;
            } 
            // If sum is less than target, move left pointer
            else if (sum < target) {
                left = (left + 1) % list.size();
            } 
            // If sum is greater than target, move right pointer
            else {
                right = (right - 1 + list.size()) % list.size();
            }
        }

        return false; // No valid pair found
    }

    // Main function to test
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(pairSum(list, 16)); // Output: true
        System.out.println(pairSum(list, 20)); // Output: false
    }
}
```

### Walkthrough:

1. **Breaking Point:** The code first finds the pivot point (where the rotation occurred) by iterating through the array. It looks for where the current element is greater than the next one, which indicates the pivot.
   
2. **Two-Pointer Logic:** After finding the pivot, the `left` pointer starts from the smallest element, and the `right` pointer starts from the largest element. These pointers move towards each other, checking sums at each step.

3. **Efficient Pair Search:** Depending on whether the sum is less than or greater than the target, the pointers are adjusted. This ensures that all potential pairs are explored in O(n) time, where n is the size of the array.

## Time Complexity

- **Time Complexity:** O(n), where n is the number of elements in the array. The two-pointer approach ensures that we only traverse the array once.

- **Space Complexity:** O(1), since we are using only a constant amount of extra space for the pointers and other variables.

## Key Features

- Efficient pair search in a rotated sorted array.
- Two-pointer technique ensures minimal space usage.
- Handles the rotation of the array seamlessly using modulo arithmetic.

## Tips

- Ensure that the breaking point (pivot) is found correctly to avoid incorrect pointer placements.
- Use the modulo operation carefully to handle circular array traversal.
- The array needs to be rotated, not necessarily sorted.

## Conclusion

This approach efficiently solves the pair sum problem in a rotated sorted array using the two-pointer technique. By identifying the pivot and using pointers on both ends of the array, we can find the target sum in linear time. This method minimizes space usage, making it optimal for large datasets.