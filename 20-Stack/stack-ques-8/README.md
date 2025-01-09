

# **Maximum Rectangle Area in Histogram**  

This program calculates the **maximum rectangle area** in a histogram using the concept of **monotonic stacks**. It finds the largest rectangle that can be formed in a histogram, where the histogram's heights are represented by an array.  

---

## **Problem Statement**  
Given an array `arr[]` representing the heights of histogram bars, calculate the maximum rectangle area that can be formed between the bars.  

For example:  
**Input**: `arr[] = [2, 4]`  
**Output**: `4`  
(The maximum rectangle area is formed by the single bar `4` or two bars of height `2`.)  

---

## **Visual Representation**  

Here’s how the histogram is represented:  

For `arr[] = [2, 4]`:  

```
Height: 2       |    
                |    
Height: 4       |         |  
                |         |  
---------------------------
Index:      0         1  
```

### **Key Idea**  
To calculate the maximum rectangle area for any bar, you need:  
1. **Nearest smaller element to the left (nextLS)**  
2. **Nearest smaller element to the right (nextRS)**  

Using these, you can determine the width of the rectangle for each bar and calculate the area.

---

## **Approach**  

The algorithm involves the following steps:  

1. **Find `nextRS[]` (Nearest Smaller to the Right):**  
   Traverse the array from **right to left** using a monotonic stack.  

2. **Find `nextLS[]` (Nearest Smaller to the Left):**  
   Traverse the array from **left to right** using another monotonic stack.  

3. **Calculate the Maximum Area:**  
   For each bar, compute the width and area of the rectangle and keep track of the largest area.  

---

## **Algorithm (Pseudocode)**  

```text
1. Initialize `nextRS[]` and `nextLS[]` arrays.
2. Use two monotonic stacks to compute:
   a. `nextRS[]`: Nearest smaller index to the right for each bar.
   b. `nextLS[]`: Nearest smaller index to the left for each bar.
3. Calculate the width and area for each bar:
   Width = (nextRS[i] - nextLS[i] - 1)
   Area = arr[i] * Width
4. Return the maximum area.
```

### **Complexity Analysis**
- **Time Complexity**: `O(n)`  
  Each bar is pushed and popped from the stack exactly once.  
- **Space Complexity**: `O(n)`  
  Space is used for the stack and the two auxiliary arrays.

---

## **Code Explanation**

Here’s a breakdown of the code and how it solves the problem step-by-step.

### **1. Finding `nextRS`**  
- Traverse the array **from right to left**.
- Use a stack to track indices of smaller elements.  

### **2. Finding `nextLS`**  
- Traverse the array **from left to right**.
- Use a stack to find indices of smaller elements on the left.

### **3. Calculating Maximum Area**  
- For each bar, compute:  
  \[
  \text{Width} = \text{nextRS[i]} - \text{nextLS[i]} - 1
  \]  
  \[
  \text{Area} = \text{Height} \times \text{Width}
  \]  
- Update the maximum area.

---

## **Execution Visualization**

### Example: `arr[] = [2, 4]`

1. **Calculate `nextRS[]`:**  
   Traverse from right to left.  
   ```
   nextRS[] = [2, 2]
   ```

2. **Calculate `nextLS[]`:**  
   Traverse from left to right.  
   ```
   nextLS[] = [-1, 0]
   ```

3. **Calculate Width and Area:**  
   For each bar:  
   ```
   Width = nextRS[i] - nextLS[i] - 1
   Area = arr[i] * Width
   ```
   ```
   i = 0 → Width = 2 - (-1) - 1 = 2 → Area = 2 * 2 = 4  
   i = 1 → Width = 2 - 0 - 1 = 1 → Area = 4 * 1 = 4  
   ```

4. **Maximum Area:**  
   ```
   Max Area = 4
   ```

---

## **Run the Program**

### **Code**  

```java
import java.util.Stack;

public class StackJFC {
    public static void nextRSmallest(int arr[], int nextRL[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            nextRL[i] = s.isEmpty() ? arr.length : s.peek();
            s.push(i);
        }
    }

    public static void nextLSmallest(int arr[], int nextLS[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            nextLS[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
    }

    public static int maxArea(int arr[]) {
        int nextRS[] = new int[arr.length];
        int nextLS[] = new int[arr.length];
        nextRSmallest(arr, nextRS);
        nextLSmallest(arr, nextLS);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int area = arr[i] * (nextRS[i] - nextLS[i] - 1);
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4};
        System.out.println(maxArea(arr));
    }
}
```

---

## **How to Use**

1. Clone the repository and open the code in your Java IDE.  
2. Replace the `arr[]` in the `main` method with your desired histogram heights.  
3. Run the program to see the maximum rectangle area.  

---

## **Visualization**

For better understanding, visualize the process as:  

1. Draw the histogram for your array.  
2. Mark the **nearest smaller elements** to the left and right for each bar.  
3. Calculate the rectangle width and area for each bar.  
4. Highlight the bar(s) that contribute to the **maximum area**.


