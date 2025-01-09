

# Max Area of Water Container

## Problem Statement

Imagine you have a series of vertical lines drawn on a 2D plane, and these lines represent the heights of different barriers. Your goal is to determine the maximum area of water that can be trapped between these lines. The water will be held by two lines, so the area is determined by the shorter line multiplied by the distance between the two lines.

### Example

Given an array of heights:  
`height = [3, 4, 2, 1, 3, 5, 4]`

The maximum area of water that can be contained is the area formed between lines at indices 1 and 5 (heights 4 and 5) with a distance of 4 units. Thus, the area is `min(4, 5) * (5 - 1) = 4 * 4 = 16`.

## Approach

We will use a two-pointer technique to efficiently find the maximum area. The two pointers will start at both ends of the array and move towards each other based on the heights of the lines. 

1. **Initialize Pointers**: Set two pointers, `left` at the beginning and `right` at the end of the array.
2. **Calculate Area**: In each iteration, calculate the area formed by the lines at the `left` and `right` pointers.
3. **Update Maximum Area**: Keep track of the maximum area found.
4. **Move Pointers**: Move the pointer pointing to the shorter line inward to potentially find a taller line that could increase the area.

### Time Complexity

This approach runs in **O(n)** time complexity, where `n` is the number of elements in the height array. We only traverse the array once with the two pointers.

---

## Dry Run Walkthrough

Let's dry run our example `height = [3, 4, 2, 1, 3, 5, 4]` using the two-pointer approach:

### Initial Setup
- `maxArea = 0`
- `left = 0` (height[0] = 3)
- `right = 6` (height[6] = 4)

### Iteration 1
- Calculate area:  
  `Area = min(height[left], height[right]) * (right - left) = min(3, 4) * (6 - 0) = 3 * 6 = 18`  
  Update `maxArea = max(0, 18) = 18`
- Since height[left] < height[right], move `left` pointer to the right.  
  `left = 1`

### Iteration 2
- `left = 1` (height[1] = 4), `right = 6` (height[6] = 4)
- Calculate area:  
  `Area = min(4, 4) * (6 - 1) = 4 * 5 = 20`  
  Update `maxArea = max(18, 20) = 20`
- Move `right` pointer to the left since height[left] == height[right].  
  `right = 5`

### Iteration 3
- `left = 1` (height[1] = 4), `right = 5` (height[5] = 5)
- Calculate area:  
  `Area = min(4, 5) * (5 - 1) = 4 * 4 = 16`  
  `maxArea = max(20, 16) = 20`
- Move `left` pointer to the right.  
  `left = 2`

### Iteration 4
- `left = 2` (height[2] = 2), `right = 5` (height[5] = 5)
- Calculate area:  
  `Area = min(2, 5) * (5 - 2) = 2 * 3 = 6`  
  `maxArea = max(20, 6) = 20`
- Move `left` pointer to the right.  
  `left = 3`

### Iteration 5
- `left = 3` (height[3] = 1), `right = 5` (height[5] = 5)
- Calculate area:  
  `Area = min(1, 5) * (5 - 3) = 1 * 2 = 2`  
  `maxArea = max(20, 2) = 20`
- Move `left` pointer to the right.  
  `left = 4`

### Iteration 6
- `left = 4` (height[4] = 3), `right = 5` (height[5] = 5)
- Calculate area:  
  `Area = min(3, 5) * (5 - 4) = 3 * 1 = 3`  
  `maxArea = max(20, 3) = 20`
- Move `left` pointer to the right.  
  `left = 5`

### Conclusion
The `left` pointer now equals the `right` pointer, and the loop ends. The maximum area of water that can be contained is **20**.

---

## Full Code

Here is the complete code to run the solution:

```java
public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea ma = new MaxArea();
        int[] height = {3, 4, 2, 1, 3, 5, 4};
        int result = ma.maxArea(height);
        System.out.println("The maximum area of water that can be contained is: " + result);
    }
}
```

