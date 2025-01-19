# Majority Element - Divide and Conquer Approach

This repository contains a Java implementation of a program to find the **majority element** in an array using the **Divide and Conquer** approach. The majority element is defined as an element that appears more than `n/2` times in the array, where `n` is the size of the array.

---

## Table of Contents
- [Overview](#overview)
- [Algorithm Explanation](#algorithm-explanation)
- [Code Walkthrough](#code-walkthrough)
- [How to Run](#how-to-run)
- [Sample Input and Output](#sample-input-and-output)
- [Key Insights](#key-insights)

---

## Overview

The implementation solves the problem using the **Divide and Conquer** strategy by recursively splitting the array into smaller subarrays, finding the majority element for each subarray, and combining the results to determine the majority element for the whole array.

---

## Algorithm Explanation

1. **Divide and Conquer**:
   - Split the array into two halves.
   - Recursively find the majority element in each half.

2. **Combine Results**:
   - If both halves agree on the majority element, it is returned as the majority for the entire range.
   - Otherwise, count the occurrences of both candidates in the combined range, and return the one with the higher count.

3. **Base Case**:
   - If the array contains a single element, that element is the majority of its range.

---

## Code Walkthrough

### Main Function
The entry point is the `majorityElement` method:
```java
public static int majorityElement(int[] nums) {
    return divideAndConquer(nums, 0, nums.length - 1);
}
```
This calls the recursive helper function `divideAndConquer`.

### Recursive Function
The `divideAndConquer` function splits the array:
```java
private static int divideAndConquer(int[] nums, int low, int high) {
    if (low == high) {
        return nums[low]; // Base case
    }
    int mid = low + (high - low) / 2;
    int leftMajority = divideAndConquer(nums, low, mid);
    int rightMajority = divideAndConquer(nums, mid + 1, high);

    if (leftMajority == rightMajority) {
        return leftMajority; // Both halves agree
    }

    int leftCount = countInRange(nums, leftMajority, low, high);
    int rightCount = countInRange(nums, rightMajority, low, high);
    return leftCount > rightCount ? leftMajority : rightMajority;
}
```

### Helper Function
The `countInRange` function counts occurrences of an element in a specific range:
```java
private static int countInRange(int[] nums, int num, int low, int high) {
    int count = 0;
    for (int i = low; i <= high; i++) {
        if (nums[i] == num) {
            count++;
        }
    }
    return count;
}
```

### Example Execution
For the input array `{2, 2, 1, 1, 1, 2, 2}`, the function:
1. Splits into `{2, 2, 1}` and `{1, 1, 2, 2}`.
2. Finds majority elements in each half and combines results.

---

## How to Run

1. Clone the repository and navigate to the directory.
2. Compile the program using:
   ```bash
   javac MajorityElement.java
   ```
3. Run the program:
   ```bash
   java MajorityElement
   ```

---

## Sample Input and Output

### Input
```java
int[] nums = {2, 2, 1, 1, 1, 2, 2};
```

### Output
```
Majority Element: 2
```

---

## Key Insights

- **Time Complexity**: \( O(n \log n) \)
   - The array is divided recursively, and each level processes \( O(n) \) elements.
- **Space Complexity**: \( O(\log n) \)
   - Recursion stack space is proportional to the depth of the recursion tree.

This approach effectively leverages the divide and conquer paradigm to handle the majority element problem in an optimal way.