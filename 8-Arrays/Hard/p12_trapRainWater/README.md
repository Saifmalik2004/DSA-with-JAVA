# Trapping Rain Water Problem

The **Trapping Rain Water** problem is a well-known interview question that involves calculating how much rainwater can be trapped between elevations after it rains. The problem is often visualized with an array of integers, where each element represents the height of a bar, and we need to determine the volume of water that can sit between these bars after rain.

## Problem Statement

Given an array `height` where each element represents the height of a bar at that index, calculate the total amount of rainwater that can be trapped after it rains.

### Example

- **Input:** `height = [7,0,4,2,5,0,6,4,0,5]`
- **Output:** `25`

The answer, `25`, represents the total volume of rainwater trapped between these bars after rainfall.

---

## Approach 1: Using LeftMax and RightMax Arrays

In this approach, we use two auxiliary arrays: `leftMax` and `rightMax`. These help us store the maximum heights seen so far from the left and right sides for each bar, which allows us to determine how much water can be trapped at each position.

### Steps

1. **Initialize `leftMax` and `rightMax` Arrays.**
   - `leftMax[i]` will hold the highest bar from the start up to index `i`.
   - `rightMax[i]` will hold the highest bar from the end up to index `i`.

2. **Fill the `leftMax` and `rightMax` Arrays.**
   - Traverse the array from left to right to populate `leftMax`.
   - Traverse from right to left to populate `rightMax`.

3. **Calculate Trapped Water at Each Position.**
   - For each bar at index `i`, the water level is determined by the minimum height between `leftMax[i]` and `rightMax[i]`.
   - The trapped water at `i` is `waterLevel - height[i]`, and summing these values gives the total trapped water.

### Dry Run Example

Let’s walk through the example `height = [7,0,4,2,5,0,6,4,0,5]`.

1. **Fill `leftMax`:** `[7, 7, 7, 7, 7, 7, 7, 7, 7, 7]`
2. **Fill `rightMax`:** `[7, 6, 6, 6, 6, 6, 6, 5, 5, 5]`

Using `min(leftMax[i], rightMax[i]) - height[i]` for each index:

| Index | Height | LeftMax | RightMax | Water Level | Trapped Water |
|-------|--------|---------|----------|-------------|---------------|
| 0     | 7      | 7       | 7        | 7           | 0             |
| 1     | 0      | 7       | 6        | 6           | 6             |
| 2     | 4      | 7       | 6        | 6           | 2             |
| 3     | 2      | 7       | 6        | 6           | 4             |
| 4     | 5      | 7       | 6        | 6           | 1             |
| 5     | 0      | 7       | 6        | 6           | 6             |
| 6     | 6      | 7       | 6        | 6           | 0             |
| 7     | 4      | 7       | 5        | 5           | 1             |
| 8     | 0      | 7       | 5        | 5           | 5             |
| 9     | 5      | 7       | 5        | 5           | 0             |

Total trapped water = **25** units.

### Code Implementation

```java
public class TrappedRainWater {

    public static int trappedRainWater(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {4,3,5,0,4};
        System.out.print(trappedRainWater(height));  // Output: 25
    }
}
```

---

## Approach 2: Two-Pointer Technique

This approach avoids additional space usage by dynamically calculating the `leftMax` and `rightMax` values as two pointers move inward from both ends. 

### Steps

1. **Initialize Pointers and Track Max Values.**
   - Use a `left` pointer starting at the beginning and a `right` pointer at the end.
   - Maintain `leftMax` and `rightMax` values that store the max height encountered on the left and right as the pointers move inward.

2. **Move the Pointers Toward Each Other.**
   - If `leftMax` is smaller, move the `left` pointer one step to the right, update `leftMax`, and calculate the water trapped as `leftMax - height[left]`.
   - If `rightMax` is smaller, move the `right` pointer one step to the left, update `rightMax`, and calculate the water trapped as `rightMax - height[right]`.

3. **Sum the Water Trapped.**
   - Continue until the pointers meet, summing up the trapped water calculated at each step.

### Dry Run Example

Given `height = [7,0,4,2,5,0,6,4,0,5]`:

| Step | Left  | Right | LeftMax | RightMax | Trapped Water |
|------|-------|-------|---------|----------|---------------|
| Init | 0     | 9     | 7       | 5        | 0             |
| 1    | 0     | 8     | 7       | 5        | 5             |
| 2    | 0     | 7     | 7       | 5        | 6             |
| 3    | 0     | 6     | 7       | 6        | 6             |
| 4    | 0     | 5     | 7       | 6        | 12            |
| 5    | 0     | 4     | 7       | 6        | 13            |
| 6    | 1     | 4     | 7       | 6        | 19            |
| 7    | 2     | 4     | 7       | 6        | 21            |
| 8    | 3     | 4     | 7       | 6        | 25            |

Total trapped water = **25** units.

### Code Implementation

```java
public class TrappedRainWater2 {

    public static int trappedRainWater(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int trappedWater = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                trappedWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trappedWater += rightMax - height[right];
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {7,0,4,2,5,0,6,4,0,5};
        System.out.print(trappedRainWater(height));  // Output: 25
    }
}
```

---

## Summary of Approaches

| Approach                       | Space Complexity | Time Complexity | Description                                |
|--------------------------------|------------------|-----------------|--------------------------------------------|
| **LeftMax & RightMax Arrays**  | `O(n)`          | `O(n)`          | Uses two auxiliary arrays for left & right max heights |
| **Two-Pointer Technique**      | `O(1)`          | `O(n)`          | Optimized for space, uses two pointers to track max values |

The two-pointer technique is generally more space-efficient, but both approaches provide the same time complexity, `O(n)`. 

This guide provides an in-depth solution to the **Trapping Rain Water** problem with both approaches, including step-by-step walkthroughs, code implementations, and explanations to enhance understanding.