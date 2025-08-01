

# 📥 Counting Sort Algorithm

## 📝 Problem Statement

**Counting Sort** is a non-comparison-based sorting algorithm that works by counting occurrences of each element. It's efficient for arrays with integer values in a limited range, as it avoids element comparisons by leveraging the frequency of each unique value.

### Real-Life Analogy:
Imagine a classroom with students wearing different-colored shirts, where each color represents a unique number in an array. If you want to count how many students are wearing each color and then line them up in a sorted order by color, **Counting Sort** is like having a shelf with a slot for each color. After counting the number of students per color, you line them up accordingly.

### Example
Given:
```java
arr = [2, 2, 7, 8, 1, 3, 2, 0, 3, 0, 3]
```
After sorting, `arr` should become:
```java
arr = [0, 0, 1, 2, 2, 2, 3, 3, 3, 7, 8]
```

---

## 💡 Approach and Explanation

### Counting Sort Steps

1. **Find the Range**: Determine the maximum value to set the size of the count array.
2. **Initialize Count Array**: Create a count array where each index represents a unique number in the range of the input array, and the value at each index represents the frequency of that number.
3. **Count Occurrences**: Populate the count array by counting each element in the input array.
4. **Build Sorted Array**: Refill the original array based on the values in the count array, placing each value the correct number of times in sorted order.

### Time Complexity
- **Best, Worst, and Average Case**: **O(n + k)** where `n` is the number of elements and `k` is the range of the input values.
- **Space Complexity**: **O(k)**, used for the count array.

---

## 📌 Code Implementation

Here’s how the Counting Sort algorithm is implemented in Java:

```java
public class CountingSort {
    
    // Method to perform counting sort on the array
    public static void countingSort(int[] arr) {
        int largest = Integer.MIN_VALUE;  // Variable to store the largest element in the array

        // Loop to find the largest element in the array
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);  // Update 'largest' if the current element is greater
        }

        // Create a count array to store the frequency of each number up to 'largest'
        int[] count = new int[largest + 1];
        
        // Populate the count array by incrementing the count of each element in 'arr'
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;  // Increase the count of each element's value as index
        }

        int j = 0;  // Variable to track position in the original array

        // Refill the original array in sorted order
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {    // Repeat for each occurrence of the value
                arr[j] = i;           // Place 'i' in the array at index 'j'
                j++;                  // Move to the next index in 'arr'
                count[i]--;           // Decrease the count after placing the value
            }
        }
    }

    // Main method to test the countingSort function
    public static void main(String[] args) {
        int[] arr = {2, 2, 7, 8, 1, 3, 2, 0, 3, 0, 3};  // Define an unsorted array of integers

        countingSort(arr);  // Call the counting sort function on 'arr'
     
        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");  // Output each element followed by a space
        }
        System.out.println();  // Print a new line after the sorted array
    }
}
```

---

## 🔍 Dry Run Example

Let’s go through a detailed dry run with the array `arr = [2, 2, 7, 8, 1, 3, 2, 0, 3, 0, 3]`.

### Initial Array
```
[2, 2, 7, 8, 1, 3, 2, 0, 3, 0, 3]
```

1. **Identify the Largest Element**: 
   - The largest element is `8`, so we create a count array with indexes from `0` to `8`.
   ```
   count = [0, 0, 0, 0, 0, 0, 0, 0, 0]
   ```

2. **Populate the Count Array**:
   - Count each element in `arr` and store the frequencies in `count`.
   ```
   For `2`: count[2]++ → count = [0, 0, 1, 0, 0, 0, 0, 0, 0]
   For `2`: count[2]++ → count = [0, 0, 2, 0, 0, 0, 0, 0, 0]
   For `7`: count[7]++ → count = [0, 0, 2, 0, 0, 0, 0, 1, 0]
   For `8`: count[8]++ → count = [0, 0, 2, 0, 0, 0, 0, 1, 1]
   For `1`: count[1]++ → count = [0, 1, 2, 0, 0, 0, 0, 1, 1]
   For `3`: count[3]++ → count = [0, 1, 2, 1, 0, 0, 0, 1, 1]
   For `2`: count[2]++ → count = [0, 1, 3, 1, 0, 0, 0, 1, 1]
   For `0`: count[0]++ → count = [1, 1, 3, 1, 0, 0, 0, 1, 1]
   For `3`: count[3]++ → count = [1, 1, 3, 2, 0, 0, 0, 1, 1]
   For `0`: count[0]++ → count = [2, 1, 3, 2, 0, 0, 0, 1, 1]
   For `3`: count[3]++ → count = [2, 1, 3, 3, 0, 0, 0, 1, 1]
   ```
   Final `count` array:
   ```
   count = [2, 1, 3, 3, 0, 0, 0, 1, 1]
   ```

3. **Refill the Original Array**:
   - Using the `count` array, refill `arr` with sorted values.
   ```
   Place two `0`s → arr = [0, 0, ..., ...]
   Place one `1`  → arr = [0, 0, 1, ...]
   Place three `2`s → arr = [0, 0, 1, 2, 2, 2, ...]
   Place three `3`s → arr = [0, 0, 1, 2, 2, 2, 3, 3, 3, ...]
   Place one `7`  → arr = [0, 0, 1, 2, 2, 2, 3, 3, 3, 7, ...]
   Place one `8`  → arr = [0, 0, 1, 2, 2, 2, 3, 3, 3, 7, 8]
   ```

Final sorted array:
```
[0, 0, 1, 2, 2, 2, 3, 3, 3, 7, 8]
```

---

## 🔑 Key Points to Remember

- Counting Sort is efficient for integer arrays with a small range.
- It’s not suitable for sorting negative numbers directly, as it relies on array indices.
