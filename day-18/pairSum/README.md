# Pair Sum Problem

## Problem Statement

Given a sorted array of integers, the task is to determine if there exists a pair of numbers in the array that sum up to a given target value.

### Example

**Input 1:**

```
Array: [1, 2, 3, 4, 5, 6]
Target: 7
```

**Output 1:**

```
true
```

Explanation: The pair `(1, 6)` sums up to `7`.

**Input 2:**

```
Array: [1, 2, 3, 4, 5, 6]
Target: 10
```

**Output 2:**

```
false
```

Explanation: No pair in the array sums up to `10`.

## Approach

We are given a **sorted array** and tasked with finding whether two numbers in the array sum up to a given target. We can efficiently solve this problem using the **two-pointer technique** with the following approach:

1. **Two Pointers:**
   - Initialize two pointers, one starting from the beginning of the array (`left`) and the other from the end of the array (`right`).
   
2. **Traverse the Array:**
   - Calculate the sum of the elements at `left` and `right`.
   - If the sum equals the target, return `true`.
   - If the sum is less than the target, move the `left` pointer to the right to increase the sum.
   - If the sum is greater than the target, move the `right` pointer to the left to decrease the sum.
   
3. **Stop Condition:**
   - Continue moving the pointers towards each other until they meet. If no pair is found that sums up to the target, return `false`.

## Algorithm (Pseudo Code)

```
1. Initialize left = 0 and right = arr.size() - 1.
2. While left < right:
   a. Calculate sum = arr[left] + arr[right].
   b. If sum == target, return true.
   c. If sum < target, increment left.
   d. If sum > target, decrement right.
3. If no pair is found, return false.
```

## Code Explanation

```java
import java.util.ArrayList;

public class PairSum {

    // Method to check if there exists a pair in the list whose sum equals the target value
    public static boolean pairSum(ArrayList<Integer> arr, int target) {
        int left = 0; // Pointer starting at the beginning of the list
        int right = arr.size() - 1; // Pointer starting at the end of the list

        // Use a two-pointer technique to find the target pair
        while (left < right) {
            int sum = arr.get(left) + arr.get(right); // Calculate the sum of the current pair

            // If the sum equals the target, return true
            if (sum == target) {
                return true;
            }
            // If the sum is less than the target, move the left pointer to increase the sum
            else if (sum < target) {
                left++;
            }
            // If the sum is greater than the target, move the right pointer to decrease the sum
            else {
                right--;
            }
        }

        // If no pair is found, return false
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(); // Initialize the input list

        // Add elements to the list
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        // Call the pairSum method and print the result
        System.out.println(pairSum(arr, 7)); // Expected output: true
    }
}
```

### Walkthrough:

1. **Initialize Pointers:**
   - The `left` pointer starts at the beginning of the array (`0` index) and the `right` pointer starts at the last element (`arr.size() - 1`).

2. **Two-Pointer Logic:**
   - The sum of the elements at the `left` and `right` pointers is calculated.
   - If the sum equals the target, we return `true`.
   - If the sum is less than the target, we increment the `left` pointer to move towards larger numbers.
   - If the sum is greater than the target, we decrement the `right` pointer to move towards smaller numbers.

3. **Efficient Pair Search:** 
   - This process ensures we check all possible pairs in linear time, as the two pointers will only traverse the array once.

## Time Complexity

- **Time Complexity:** O(n), where n is the number of elements in the array. The two-pointer approach ensures that each element is checked at most once.

- **Space Complexity:** O(1), since we only use a constant amount of extra space for the pointers and other variables.

## Key Features

- Efficient pair search in a sorted array.
- Uses the two-pointer technique, which is space-efficient.
- Works only on sorted arrays, but guarantees optimal time complexity.

## Tips

- The array must be sorted for this approach to work correctly.
- If the array is unsorted, you may need to sort it first, which would add an additional O(n log n) complexity.
- The two-pointer approach is particularly effective when dealing with large arrays.

## Conclusion

This approach efficiently solves the pair sum problem in a sorted array using the two-pointer technique. By moving the pointers towards each other based on the sum, we can find the target pair in linear time, making it optimal for large datasets.