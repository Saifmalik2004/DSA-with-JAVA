
# 🗳️ Selection Sort Algorithm

## 📝 Problem Statement

**Selection Sort** is a simple and intuitive sorting algorithm that works by repeatedly selecting the minimum (or maximum, depending on the order) element from the unsorted portion of the array and moving it to the beginning (or end). It is not the most efficient sorting algorithm for large datasets, but it has the advantage of being easy to understand and implement.

### How Selection Sort Works:
1. The algorithm divides the array into two parts: the sorted part (initially empty) and the unsorted part (the entire array).
2. It repeatedly selects the smallest element from the unsorted part and swaps it with the leftmost unsorted element.
3. This process is repeated until the entire array is sorted.

### Example
Given:
```java
arr = [64, 25, 12, 22, 11]
```
After sorting, `arr` should become:
```java
arr = [11, 12, 22, 25, 64]
```

---

## 💡 Approach and Explanation

### Selection Sort Steps

1. **Outer Loop**: Iterate over the array from the first element to the second-to-last element.
2. **Find Minimum**: For each position in the outer loop, assume the current position holds the minimum value, then compare it with the remaining unsorted elements to find the actual minimum.
3. **Swap**: If a smaller element is found, swap it with the element at the current position.
4. **Repeat** until the entire array is sorted.

### Time Complexity
- **Worst and Average Case**: **O(n²)**, occurs when the array is unsorted.
- **Best Case**: **O(n²)**, because it always compares all elements.

---

## 📌 Code Implementation

Here’s how the Selection Sort algorithm is implemented in Java:

```java
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        // Iterate through each element in the array
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i; // Assume the current index is the minimum
            
            // Find the index of the minimum element in the unsorted section
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j; // Update the index of the minimum element
                }
            }

            // Swap the found minimum element with the first unsorted element
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        selectionSort(arr);

        // Print sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

---

## 🔍 Dry Run Example

Let’s walk through an example with `arr = [64, 25, 12, 22, 11]` to see how Selection Sort sorts the array.

### Initial Array
```
[64, 25, 12, 22, 11]
```

1. **First Pass (i = 0)**:
   - **Initial Minimum**: `64`
   - Compare with `25`, `12`, `22`, and `11`:
     - Update minimum to `11`.
   - Swap `64` with `11` → `[11, 25, 12, 22, 64]`
   - **End of pass 1**: `[11, 25, 12, 22, 64]`

2. **Second Pass (i = 1)**:
   - **Initial Minimum**: `25`
   - Compare with `12`, `22`, and `64`:
     - Update minimum to `12`.
   - Swap `25` with `12` → `[11, 12, 25, 22, 64]`
   - **End of pass 2**: `[11, 12, 25, 22, 64]`

3. **Third Pass (i = 2)**:
   - **Initial Minimum**: `25`
   - Compare with `22` and `64`:
     - Update minimum to `22`.
   - Swap `25` with `22` → `[11, 12, 22, 25, 64]`
   - **End of pass 3**: `[11, 12, 22, 25, 64]`

4. **Fourth Pass (i = 3)**:
   - **Initial Minimum**: `25`
   - Compare with `64`:
     - No update needed.
   - No swap needed.
   - **End of pass 4**: `[11, 12, 22, 25, 64]`

Now, the array is fully sorted: `[11, 12, 22, 25, 64]`.

---

## 🌍 Real-Life Example of Selection Sort

**Scenario**: Imagine you are a teacher who needs to rank students based on their scores from a test. The scores are given in a list, and you want to sort them from lowest to highest to determine their rankings.

Using Selection Sort:
1. Start with the first score, find the minimum score in the remaining list.
2. Move the minimum score to the front of the list.
3. Repeat the process until all scores are sorted.

This simple approach allows you to sort a small list of scores easily, making it suitable for ranking students.

---

## 🧩 Complexity Analysis

- **Time Complexity**: O(n²) for all cases (worst, average, and best).
- **Space Complexity**: O(1), as Selection Sort is an in-place sorting algorithm.

---

## 🔑 Key Points to Remember

- Selection Sort is easy to implement and understand but not suitable for large datasets due to its O(n²) time complexity.
- It performs well on small datasets and is an in-place algorithm, meaning it does not require additional storage.
- The algorithm's simplicity makes it a good choice for educational purposes when learning about sorting algorithms.
