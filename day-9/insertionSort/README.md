

# 📥 Insertion Sort Algorithm

## 📝 Problem Statement

The **Insertion Sort** algorithm is a simple and intuitive sorting algorithm that builds the final sorted array one item at a time. It is much less efficient on large lists compared to more advanced algorithms like quicksort, heapsort, or merge sort, but it has several advantages, including its simplicity and effectiveness on small data sets.

### How Insertion Sort Works:
1. The array is divided into two parts: the sorted part (initially consisting of the first element) and the unsorted part (the rest of the array).
2. Take one element from the unsorted part and find the appropriate position in the sorted part.
3. Shift all larger elements to the right and insert the current element into its correct position.
4. Repeat this process until the entire array is sorted.

### Example
Given:
```java
arr = [5, 4, 7, 1]
```
After sorting, `arr` should become:
```java
arr = [1, 4, 5, 7]
```

---

## 💡 Approach and Explanation

### Insertion Sort Steps

1. **Outer Loop**: Iterate over the array starting from the second element (index 1) because a single element (the first) is trivially sorted.
2. **Current Element**: For each iteration, set the current element (`curr`) as the element to be inserted into the sorted section.
3. **Inner Loop**: Compare the current element with the elements in the sorted section (to the left).
   - If the current element is smaller than the compared element, shift the compared element one position to the right.
4. **Insertion**: Place the current element in its correct position once the inner loop finds the appropriate spot.
5. **Repeat** until the entire array is sorted.

### Time Complexity
- **Worst and Average Case**: **O(n²)**, occurs when the array is in reverse order.
- **Best Case**: **O(n)**, occurs when the array is already sorted.

---

## 📌 Code Implementation

Here’s how the Insertion Sort algorithm is implemented in Java:

```java
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        // Iterate through each element in the array starting from the second one
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i]; // Current element to be inserted
            int prev = i - 1;  // Index of the last element in the sorted section

            // Shift elements of the sorted section that are greater than curr
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev]; // Shift element to the right
                prev--; // Move to the next element in the sorted section
            }

            // Insert the current element into its correct position
            arr[prev + 1] = curr; // Insertion step
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 1};

        insertionSort(arr);

        // Print sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

---

## 🔍 Dry Run Example

Let’s walk through an example with `arr = [5, 4, 7, 1]` to see how Insertion Sort sorts the array.

### Initial Array
```
[5, 4, 7, 1]
```

1. **First Pass (i = 1)**:
   - **Current Element**: `4`
   - Compare with `5` (previous element):
     - Since `5 > 4`, shift `5` to the right → `[5, 5, 7, 1]`
   - Insert `4` into its correct position → `[4, 5, 7, 1]`
   - **End of pass 1**: `[4, 5, 7, 1]`

2. **Second Pass (i = 2)**:
   - **Current Element**: `7`
   - Compare with `5` (previous element):
     - `5 < 7`, no shift needed.
   - Insert `7` into its correct position → `[4, 5, 7, 1]`
   - **End of pass 2**: `[4, 5, 7, 1]`

3. **Third Pass (i = 3)**:
   - **Current Element**: `1`
   - Compare with `7` (previous element):
     - Since `7 > 1`, shift `7` to the right → `[4, 5, 7, 7]`
   - Compare with `5`:
     - Since `5 > 1`, shift `5` to the right → `[4, 5, 5, 7]`
   - Compare with `4`:
     - Since `4 > 1`, shift `4` to the right → `[4, 4, 5, 7]`
   - Insert `1` into its correct position → `[1, 4, 5, 7]`
   - **End of pass 3**: `[1, 4, 5, 7]`

Now, the array is fully sorted: `[1, 4, 5, 7]`.

---

## 🧩 Complexity Analysis

- **Time Complexity**: O(n²) in the worst and average cases; O(n) in the best case.
- **Space Complexity**: O(1), as Insertion Sort is an in-place sorting algorithm and does not use extra space.

---

## 🔑 Key Points to Remember

- Insertion Sort is efficient for small datasets and is stable, meaning it preserves the order of equal elements.
- It is particularly useful when the array is already partially sorted, making it faster than more complex algorithms.
- The algorithm's efficiency can be further enhanced by recognizing that if the current element is greater than the last sorted element, no comparisons or shifts are necessary.

