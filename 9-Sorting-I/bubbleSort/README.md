

# 🧼 Bubble Sort Algorithm

## 📝 Problem Statement

The **Bubble Sort** algorithm is a simple, comparison-based sorting algorithm that sorts an array by repeatedly stepping through it, comparing adjacent elements, and swapping them if they are in the wrong order. This process repeats until the array is fully sorted.

### How Bubble Sort Works:
1. Traverse through the array, comparing each pair of adjacent elements.
2. If the left element is greater than the right element, swap them.
3. Repeat this process for each element until no swaps are needed, which means the array is sorted.

Given an array, your goal is to **sort the elements in ascending order** using the Bubble Sort algorithm.

### Example
Given:
```java
arr = [5, 4, 7, 6, 1, 2, 9, 11, 3]
```
After sorting, `arr` should become:
```java
arr = [1, 2, 3, 4, 5, 6, 7, 9, 11]
```

---

## 💡 Approach and Explanation

### Bubble Sort with Optimization

Bubble Sort has a simple improvement to make it more efficient by stopping the algorithm if no elements were swapped in a complete pass, indicating that the array is already sorted. We call this the **optimized Bubble Sort**.

### Steps to Implement Bubble Sort
1. **Outer Loop**: Iterate over each element (index `i`) of the array from the beginning to the second-to-last element.
2. **Inner Loop**: For each `i`, perform comparisons and swaps up to the last unsorted element (decreasing length each time).
3. **Swap Check**: Use a `swap` boolean flag. If no swaps are made during an iteration of the outer loop, the array is sorted, and the algorithm can stop early.

### Time Complexity
- **Worst and Average Case**: **O(n²)**, when the array is in reverse order or unsorted.
- **Best Case**: **O(n)**, if the array is already sorted.

---

## 📌 Code Implementation

Here’s how the Bubble Sort algorithm with optimization looks in Java:

```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false; // Flag to detect if a swap occurred

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if elements are out of order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            
            // If no swaps occurred, the array is already sorted
            if (!swap) return;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 6, 1, 2, 9, 11, 3};

        bubbleSort(arr);

        // Print sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

---

## 🔍 Dry Run Example

Let’s walk through an example with `arr = [5, 4, 7, 6, 1]` to see how Bubble Sort sorts the array.

### Initial Array
```
[5, 4, 7, 6, 1]
```

1. **First Pass**:
   - Compare `5` and `4`, swap → `[4, 5, 7, 6, 1]`
   - Compare `5` and `7`, no swap
   - Compare `7` and `6`, swap → `[4, 5, 6, 7, 1]`
   - Compare `7` and `1`, swap → `[4, 5, 6, 1, 7]`
   - **End of pass 1**: `[4, 5, 6, 1, 7]`

2. **Second Pass**:
   - Compare `4` and `5`, no swap
   - Compare `5` and `6`, no swap
   - Compare `6` and `1`, swap → `[4, 5, 1, 6, 7]`
   - **End of pass 2**: `[4, 5, 1, 6, 7]`

3. **Third Pass**:
   - Compare `4` and `5`, no swap
   - Compare `5` and `1`, swap → `[4, 1, 5, 6, 7]`
   - **End of pass 3**: `[4, 1, 5, 6, 7]`

4. **Fourth Pass**:
   - Compare `4` and `1`, swap → `[1, 4, 5, 6, 7]`
   - **End of pass 4**: `[1, 4, 5, 6, 7]`

No further swaps are required, and the array is now sorted: `[1, 4, 5, 6, 7]`.

---

## 🧩 Complexity Analysis

- **Time Complexity**: O(n²) in the worst case, but optimized to O(n) if the array is already sorted.
- **Space Complexity**: O(1), as Bubble Sort is an in-place sorting algorithm and does not use extra space.

---

## 🔑 Key Points to Remember

- Bubble Sort repeatedly compares and swaps adjacent elements to push larger values to the end of the array in each pass.
- Using a flag to detect swaps, the optimized Bubble Sort can finish early if the array becomes sorted before completing all passes.
- Although not as efficient as other sorting algorithms like Quick Sort or Merge Sort, Bubble Sort is easy to understand and useful for small datasets.

With this `README.md`, you should be able to understand the Bubble Sort algorithm, how it works step-by-step, and its efficiency in sorting arrays!