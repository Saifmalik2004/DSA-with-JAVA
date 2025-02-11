# 🚀 Next Permutation - Mastering the Art of Lexicographic Ordering

## 📌 Problem Description

Given an array of integers that represents a permutation of numbers, the task is to find the **next lexicographical permutation**. If no such permutation exists (i.e., the array is sorted in descending order), return the **smallest permutation** (sorted in ascending order).

### 🔍 Example

#### ✅ Input:
```
nums = [2, 1, 5, 4, 3, 0, 0]
```

#### 🎯 Output:
```
[2, 3, 0, 0, 1, 4, 5]
```

---

## 🐢 Brute Force Approach

### 💡 Idea
Generate all possible permutations of the array, sort them in lexicographic order, and return the **next** permutation after the given one.

### 📝 Pseudocode
```plaintext
1. Generate all permutations of the array.
2. Sort them in lexicographical order.
3. Find the given permutation in the sorted list.
4. Return the next permutation; if it's the last, return the first permutation.
```

### ⏳ Time Complexity
- **O(N!)** (Generating all permutations is costly!)
- **Space Complexity:** O(N!) (Storing all permutations)

---

## ⚡ Optimized Approach (Efficient Algorithm) 🚀

### 💡 Idea
Instead of generating all permutations, we can efficiently determine the next permutation using the following approach:

1. **Find the breakpoint:** Traverse the array from the end and locate the first decreasing element.
2. **Find the swap candidate:** Find the smallest number greater than this element on its right.
3. **Swap them.**
4. **Reverse the remaining portion** after the swapped index to get the smallest lexicographical order.

### 📝 Pseudocode
```plaintext
1. Find the first index 'i' from the right where nums[i] < nums[i+1].
2. If no such index is found, reverse the array and return (smallest permutation).
3. Find the smallest number greater than nums[i] in the right portion.
4. Swap these two numbers.
5. Reverse the array from index i+1 to the end to get the next permutation.
```

### 💻 Code Implementation (Java)
```java
public class NextPermutation {
    public static void next(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        // Step 2: If no such element is found, reverse the array
        if (breakPoint == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the smallest element greater than nums[breakPoint]
        for (int i = n - 1; i > breakPoint; i--) {
            if (nums[i] > nums[breakPoint]) {
                swap(nums, breakPoint, i);
                break;
            }
        }

        // Step 4: Reverse the sequence after the breakpoint
        reverse(nums, breakPoint + 1, n - 1);
    }

    // Helper function to swap two elements
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Helper function to reverse an array segment
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        next(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

### ⏳ Complexity Analysis
- **Time Complexity:** O(N) (Single pass to find, swap, and reverse elements)
- **Space Complexity:** O(1) (In-place modifications)

---

## 📊 Complexity Comparison

| Approach | Time Complexity | Space Complexity |
|----------|---------------|----------------|
| Brute Force | O(N!) | O(N!) |
| Optimized | O(N) | O(1) |

---

## 🌍 Real-World Applications

✅ **Scheduling Problems**: Finding the next possible schedule or arrangement.

✅ **String Permutations**: Used in dictionary word ordering.

✅ **Game Theory**: Used in AI decision-making to find the next best move.

---

## 🎯 Key Takeaways
- **Brute force** is inefficient due to factorial complexity.
- **Optimized approach** leverages smart swaps and reversals.
- **Understanding permutations** is useful in various real-world applications!

💡 Keep practicing and happy coding! 🚀

