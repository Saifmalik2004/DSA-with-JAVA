# QuickSort Algorithm

## **Introduction**

QuickSort is one of the most efficient and widely-used sorting algorithms. It is based on the **divide-and-conquer** technique, which breaks a problem into smaller sub-problems, solves them independently, and combines the results to solve the original problem.

In this `README`, we'll deeply understand how QuickSort works, with an engaging explanation, dry run, and analysis of its **time complexity**.  

---

## **How QuickSort Works**

1. **Pivot Selection:**  
   Pick an element from the array as the pivot. In our example, we choose the **last element** of the array.

2. **Partitioning the Array:**  
   Rearrange the array such that:  
   - Elements **smaller than or equal to the pivot** are on the left.  
   - Elements **greater than the pivot** are on the right.  

3. **Recursive Sorting:**  
   Apply the same process to the left and right sub-arrays.

4. **Base Case:**  
   The recursion stops when the sub-array has zero or one element since it is already sorted.

---

## **Algorithm Breakdown**

Here’s a step-by-step explanation of the code:

### 1. **Base Case**  
```java
if(si >= ei) {
    return;
}
```
This ensures that the function stops when the array is already sorted (or contains a single element).

---

### 2. **Partition Function**

This is where the magic happens!  
The `partition` function rearranges the array around the pivot.

- **Pivot Selection:**  
  The pivot is chosen as the last element:
  ```java
  int pivot = arr[ei];
  ```

- **Two Pointers:**  
  One pointer, `i`, tracks the boundary of smaller elements.  
  Another pointer, `j`, scans the array to compare elements with the pivot:
  ```java
  int i = si - 1;
  for (int j = si; j < ei; j++) {
      if (arr[j] <= pivot) {
          i++;
          swap(arr, i, j);
      }
  }
  ```

- **Final Swap:**  
  Swap the pivot with the element just after `i`:
  ```java
  arr[ei] = arr[i + 1];
  arr[i + 1] = pivot;
  return i + 1;
  ```

---

### 3. **Recursive Calls**

After partitioning, recursively sort the left and right sub-arrays:
```java
quickSort(arr, si, pIdx - 1);
quickSort(arr, pIdx + 1, ei);
```

---

## **Dry Run with Example**

Let’s take the array:  
**`arr = [6, 3, 9, 8, 2, 5]`**

### Initial Call
```java
quickSort(arr, 0, 5);
```

---

### Partition Step 1
**Pivot:** 5  
- Compare each element with the pivot:  
  - `6 > 5` (No change)  
  - `3 ≤ 5` (Swap with `6` → `[3, 6, 9, 8, 2, 5]`)  
  - `9 > 5` (No change)  
  - `8 > 5` (No change)  
  - `2 ≤ 5` (Swap with `6` → `[3, 2, 9, 8, 6, 5]`)  

**Final Swap:** Pivot `5` is placed in the correct position:  
`[3, 2, 5, 8, 6, 9]`  

**Partition Index (pIdx):** 2

---

### Recursive Calls
1. Left Sub-array: `[3, 2]`  
   - Pivot: `2`  
   - Partition Result: `[2, 3]`

2. Right Sub-array: `[8, 6, 9]`  
   - Pivot: `9`  
   - Partition Result: `[6, 8, 9]`

---

### Final Sorted Array
After all recursive calls, the array becomes:  
**`[2, 3, 5, 6, 8, 9]`**

---

## **Time Complexity**

| Case          | Time Complexity | Explanation                                                                 |
|---------------|-----------------|-----------------------------------------------------------------------------|
| **Best Case** | `O(n log n)`    | Happens when the pivot splits the array into two equal halves repeatedly.   |
| **Worst Case**| `O(n²)`         | Happens when the pivot is the smallest or largest element (poor partition). |
| **Average**   | `O(n log n)`    | Most cases fall into this category.                                         |

---

## **Key Advantages of QuickSort**
- **In-place Sorting:** Does not require extra space like MergeSort.  
- **Fast on Average:** For most inputs, it performs better than other algorithms like BubbleSort or InsertionSort.  

---

## **Conclusion**

QuickSort is an elegant and powerful sorting algorithm, especially when implemented with a good pivot strategy. Understanding its partitioning and recursive nature is crucial for mastering sorting algorithms.

---

Feel free to copy the code, experiment with different inputs, and modify the pivot selection strategy to see its impact on performance! 😊