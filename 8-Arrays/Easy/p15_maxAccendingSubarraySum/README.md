

# Maximum Ascending Subarray Sum

## Problem Statement

Given an array of positive integers `nums`, you are tasked with finding the **maximum sum** of an **ascending subarray**. An **ascending subarray** is a contiguous subarray where each element is strictly greater than the previous element. A single-element subarray is also considered an ascending subarray.

### Input:
- An array of positive integers `nums`.

### Output:
- The maximum sum of an ascending subarray in the array.

---

## Example

### Input:
```java
[10, 20, 30, 5, 10, 15, 16]
```

### Output:
```java
60
```

### Explanation:
- Ascending subarrays:
  - `[10, 20, 30]` with sum = 60
  - `[5, 10, 15, 16]` with sum = 46
- The maximum sum of any ascending subarray is **60**.

---

## Approach

Let's break down the approach step by step:

1. **Initialization**:
   - Start by initializing two variables: 
     - `curr` to the first element of the array. This variable tracks the sum of the current ascending subarray.
     - `ans` to the first element as well. This variable keeps track of the maximum sum found so far.

2. **Iterate Through the Array**:
   - Begin iterating over the array starting from the second element (index 1).
   - **If the current element is greater than the previous one** (i.e., `nums[i] > nums[i-1]`), it means we are still in an ascending subarray. In this case:
     - Add the current element to `curr` (i.e., `curr = curr + nums[i]`).
   - **Otherwise**, if the current element is not greater, it means the ascending subarray has ended:
     - Update the maximum sum (`ans = Math.max(ans, curr)`).
     - Reset `curr` to the current element (i.e., `curr = nums[i]`) to start a new ascending subarray.

3. **Final Comparison**:
   - After iterating through the entire array, we need one last comparison:
     - Update the result (`ans = Math.max(ans, curr)`) to ensure we account for any ascending subarray that might end at the last element.

4. **Return the Result**:
   - The value of `ans` at the end will hold the maximum sum of an ascending subarray.

---

## Pseudo Code

```text
1. Initialize curr = nums[0]
2. Initialize ans = nums[0]

3. For i = 1 to nums.length - 1:
     a. If nums[i] > nums[i - 1]:
          i. curr = curr + nums[i]
     b. Else:
          i. ans = max(ans, curr)
          ii. curr = nums[i]

4. ans = max(ans, curr)

5. Return ans
```

---

## Code Explanation (Walkthrough)

### Java Code:

```java
class Solution {
    public int maxAscendingSum(int[] nums) {
        // Step 1: Initialize the current sum and answer with the first element.
        int curr = nums[0], ans = nums[0];
        
        // Step 2: Iterate through the array starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // Step 3: If the current number is greater than the previous one, add it to the current sum.
            curr = nums[i] > nums[i - 1] ? curr + nums[i] : nums[i];
            
            // Step 4: Update the maximum sum found so far.
            ans = Math.max(ans, curr);
        }
        
        // Step 5: Return the maximum sum of the ascending subarrays.
        return ans;
    }
}
```

### Explanation:

- **Initialization**: 
   - We initialize `curr` and `ans` with the first element of the array to ensure that the first ascending subarray is considered.

- **For Loop**:
   - We loop through the array starting from the second element. 
   - If the current element is greater than the previous one, we add it to `curr` because it's part of an ascending subarray.
   - If the current element is not greater, we compare `curr` with `ans` to update the maximum sum, and then reset `curr` to the current element to start a new subarray.

- **Final Comparison**:
   - After the loop, we compare `curr` with `ans` again to ensure that the last ascending subarray (which may have ended at the last element) is accounted for.

- **Return Result**:
   - The value of `ans` is returned as the result, representing the maximum sum of an ascending subarray.

---

## Time Complexity and Space Complexity Analysis

### Time Complexity:
- **O(n)**: We only make a single pass through the array to calculate the result, where `n` is the number of elements in the array.

### Space Complexity:
- **O(1)**: We are using only a constant amount of extra space for variables `curr` and `ans`, which are both integers.

---

## Key Features

- **Optimal Solution**: The algorithm runs in linear time, which is optimal for this problem.
- **Simple Approach**: The solution uses simple iteration and comparison, making it easy to understand and implement.
- **Constant Space Usage**: The solution only uses two extra variables (`curr` and `ans`), making it space-efficient.

---


## Tips

1. **Start with the First Element**: Always start the sum calculations with the first element, as even a single element subarray is valid.
2. **Remember Edge Cases**: 
   - If the array has only one element, it is automatically the maximum ascending subarray.
   - If the array is completely ascending, the entire array will be the maximum subarray.

---

## Conclusion

This solution efficiently calculates the maximum sum of an ascending subarray in **O(n)** time with **O(1)** space. The approach is simple and works for both small and large input arrays. By keeping track of the current sum of the ascending subarray and updating the maximum sum as we iterate, we ensure that we capture the largest possible sum without needing additional space or complex algorithms.
