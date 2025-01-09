# Container with Most Water Problem

## Problem Statement

Given an array of integers where each element represents the height of a vertical line drawn on a coordinate plane, find two lines such that they together form a container with the maximum amount of water. The width of the container is the distance between the two lines, and the height is determined by the shorter line.

### Example

#### Input:
```text
heights = [3, 4, 2, 1, 3, 5, 4]
```

#### Output:
```text
The maximum area of water that can be contained is: 15
```

### Explanation:
- The two lines that form the container with the maximum water are at indices 1 and 5 (heights 4 and 5).
- Width = 5 - 1 = 4
- Height = min(4, 5) = 4
- Area = Width * Height = 4 * 4 = 16

---

## Visual Representation
![Container with Most Water](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg)
*(Illustration of the container with the most water formed between two lines)*

---

## Approach
To solve this problem efficiently, we use the **two-pointer technique**:

### Step-by-Step Explanation:
1. Initialize two pointers: `left` at the beginning of the array and `right` at the end.
2. Calculate the area of water between the two pointers using the formula:
   
   ```
   Area = min(height[left], height[right]) * (right - left)
   ```
3. Keep track of the maximum area encountered so far.
4. Move the pointer pointing to the shorter line inward:
   - If `height[left] < height[right]`, increment `left`.
   - Else, decrement `right`.
5. Repeat steps 2-4 until the two pointers meet.
6. Return the maximum area.

---

## Algorithm (Pseudo Code)

```text
function maxArea(height):
    maxArea = MIN_VALUE
    left = 0
    right = height.length - 1

    while left < right:
        currentArea = min(height[left], height[right]) * (right - left)
        maxArea = max(maxArea, currentArea)

        if height[left] < height[right]:
            left++
        else:
            right--

    return maxArea
```

---

## Code Explanation Walkthrough

### Code:
```java
public class MostWater {
    public static int maxArea(ArrayList<Integer> height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.size() - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height.get(left), height.get(right)) * (right - left));

            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(3);
        height.add(4);
        height.add(2);
        height.add(1);
        height.add(3);
        height.add(5);
        height.add(4);

        int result = maxArea(height);
        System.out.println("The maximum area of water that can be contained is: " + result);
    }
}
```

### Walkthrough:
1. **Initialization**:
   - Start with two pointers (`left` and `right`) and a variable `maxArea` initialized to a very small value.
2. **Iterative Calculation**:
   - Calculate the current area using the heights at the two pointers.
   - Update `maxArea` if the current area is greater.
3. **Pointer Movement**:
   - Move the pointer pointing to the shorter height inward to explore the possibility of a larger container.
4. **Termination**:
   - Stop the process when the two pointers meet.
5. **Output**:
   - Print the maximum area.

---

## Time Complexity and Space Complexity Analysis

### Time Complexity:
- **O(n)**: We traverse the array once with the two-pointer technique.

### Space Complexity:
- **O(1)**: No additional data structures are used.

---

## Key Features
- Efficient two-pointer approach eliminates the need for nested loops.
- Reduces the problem's complexity from **O(n²)** to **O(n)**.
- Handles edge cases like arrays with very few elements gracefully.

---

## Tips
- Always compare the heights of the two pointers and move the shorter one inward.
- If the input array is not sorted, the approach still works because sorting is not required.
- Visualize the two-pointer process to understand how the solution evolves.

---

## Conclusion
The **Container with Most Water** problem demonstrates the power of the two-pointer technique to solve optimization problems efficiently. By focusing on the shorter line and maximizing the area step-by-step, we achieve an elegant and performant solution.

