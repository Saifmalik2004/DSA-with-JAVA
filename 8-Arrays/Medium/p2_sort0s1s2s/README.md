

# **README: Sorting Array of 0s, 1s, and 2s Using Counting Method** ✨

---

### **Problem Description** 🤔

Imagine you’re organizing a parade 🎉, and the float colors are strictly 0s (red), 1s (blue), and 2s (green). Now, your task is to arrange all the red floats (0s) in the front, followed by all the blue floats (1s), and lastly the green floats (2s). Can you do this in a quick and efficient way? 🧐

In programming terms, you’re given an array with only the numbers 0, 1, and 2, and your goal is to sort the array such that all 0s come first, followed by all 1s, and finally all 2s.

This problem is often referred to as the **Dutch National Flag Problem**, and it's an essential algorithmic exercise that helps you work with sorting and optimization techniques. 🌟

---

### **Better Approach** 💡

Here’s a clever approach to solving the problem—**the Counting Method**. It’s an intuitive method that avoids unnecessary comparisons by simply counting the occurrences of 0s, 1s, and 2s in the array. After counting, we simply overwrite the array with the correct number of 0s, 1s, and 2s, in that order.

#### Steps:
1. **Count the occurrences** of 0s, 1s, and 2s.
2. **Overwrite** the original array based on the counted values:
   - Fill the array with all 0s first.
   - Then fill with all 1s.
   - Lastly, fill with all 2s.

By counting first and then updating the array, we avoid multiple passes or sorting algorithms, making it **time-efficient**! 😎

---

### **Pseudo Code** 📝

Here’s a simple breakdown of the approach in pseudo code:

```
1. Initialize counters for 0s, 1s, and 2s.
2. Traverse the array and count how many 0s, 1s, and 2s exist.
3. Overwrite the array:
   - First, fill with all 0s.
   - Then, fill with all 1s.
   - Finally, fill with all 2s.
4. Done! The array is sorted.

```

---

### **Step-by-Step Explanation of the Code** 🛠️

Let’s break down the code in a way that’s easy to follow! 👇

1. **Count the Occurrences**:
   - We iterate through the array and count how many 0s, 1s, and 2s exist using three counters (`zero`, `one`, and `two`).

2. **Overwrite the Array**:
   - After counting, we overwrite the original array in three phases:
     - First, fill in the 0s.
     - Then, place the 1s in the remaining spots.
     - Lastly, the 2s will automatically fill the remaining positions.

---

### **Example Walkthrough** 🌟

Let’s walk through an example to see how the algorithm works:

#### Input:
```
[0, 1, 1, 2, 2, 0, 0, 1, 1, 0, 1, 2, 0, 0]
```

1. **Count Occurrences**:
   - `zero = 6`
   - `one = 5`
   - `two = 3`

2. **Overwrite the Array**:
   - **Step 1**: Fill with 6 zeros: `[0, 0, 0, 0, 0, 0, _, _, _, _, _, _, _]`
   - **Step 2**: Fill with 5 ones: `[0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, _, _]`
   - **Step 3**: Fill with 3 twos: `[0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2]`

#### Output:
```
[0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2]
```

---



### **Full Code with Comments** 🖥️✨

Here’s the complete code with comments to explain each step:

```java
public class Better {
    /**
     * Sorts an array containing only 0s, 1s, and 2s using the counting method.
     * This approach counts the occurrences of each number and then fills the array accordingly.
     */
    public static void sort012(int arr[]) {
        int zero = 0, one = 0, two = 0;

        // Count occurrences of 0s, 1s, and 2s
        for (int num : arr) {
            switch (num) {
                case 0 -> zero++;  // Count the number of 0s
                case 1 -> one++;   // Count the number of 1s
                default -> two++;  // Count the number of 2s
            }
        }

        // Overwrite the array based on counted values
        for (int i = 0; i < arr.length; i++) {
            if (zero > 0) {
                arr[i] = 0;
                zero--;  // Decrease the count for 0
            } else if (one > 0) {
                arr[i] = 1;
                one--;   // Decrease the count for 1
            } else {
                arr[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 2, 2, 0, 0, 1, 1, 0, 1, 2, 0, 0};
        sort012(arr);

        // Print sorted array
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }
}
```

---


### **Complexity Analysis** ⏱️📦

- **Time Complexity**: O(n), where n is the length of the array. We traverse the array twice: once for counting and once for overwriting.
- **Space Complexity**: O(1), as we only use a few integer counters for the 0s, 1s, and 2s.

--



### **Optimize Approach** 💡

 **Using Dutch National Flag Algorithm** ✨

The **Dutch National Flag Algorithm (DNF)** is the perfect strategy to solve this problem. It uses **three pointers** (`low`, `mid`, `high`) to partition the array into three sections:

1. **Low section**: This section contains all 0s.
2. **Mid section**: This section contains all 1s.
3. **High section**: This section contains all 2s.

The algorithm scans through the array and, based on the value of the element at the `mid` pointer, moves it to the appropriate section. This method guarantees **O(n)** time complexity and **O(1)** space complexity.

---

### **Pseudo Code** 📝

Here’s a simplified version of the pseudo-code for DNF sorting:

```
1. Initialize pointers: low = 0, mid = 0, high = n-1.
2. While mid <= high:
    a. If arr[mid] == 0:
        - Swap arr[low] and arr[mid].
        - Increment low and mid.
    b. If arr[mid] == 2:
        - Swap arr[mid] and arr[high].
        - Decrement high.
    c. If arr[mid] == 1:
        - Increment mid.
3. Done! The array is sorted.
```

---

### **Step-by-Step Explanation of the Code** 🛠️

Let's break down the code into digestible steps. 👇

1. **Initialize Pointers**:  
   - `low = 0`: This pointer will mark the boundary for 0s.
   - `mid = 0`: This pointer will traverse the array.
   - `high = n-1`: This pointer will mark the boundary for 2s.

2. **Main Loop**:  
   - As long as `mid <= high`, the loop continues.
   - If `arr[mid] == 0`, swap `arr[low]` and `arr[mid]`, and increment both `low` and `mid`.
   - If `arr[mid] == 2`, swap `arr[mid]` and `arr[high]`, and decrement `high`.
   - If `arr[mid] == 1`, just increment `mid`.

3. **End Condition**:  
   - Once `mid` surpasses `high`, the array is sorted. All 0s are in the front, followed by all 1s, and 2s are at the end.

---

### **Example Walkthrough** 🌟

Let’s walk through the algorithm with an example input:

#### Input:
```
[0, 1, 1, 2, 2, 0, 0, 1, 1, 0, 1, 2, 0, 0]
```

1. **Initial Pointers**:
   - `low = 0`, `mid = 0`, `high = 13` (end of array).

2. **First Step**:
   - `arr[mid] == 0`, so swap `arr[low]` and `arr[mid]`.  
   - Increment both `low` and `mid`.  
   - New pointers: `low = 1`, `mid = 1`.

3. **Second Step**:
   - `arr[mid] == 1`, so just increment `mid`.  
   - New pointers: `mid = 2`.

4. **Third Step**:
   - `arr[mid] == 1`, so just increment `mid`.  
   - New pointers: `mid = 3`.

5. **Fourth Step**:
   - `arr[mid] == 2`, so swap `arr[mid]` and `arr[high]`.  
   - Decrement `high`.  
   - New pointers: `high = 12`.

6. **Repeat** the steps until `mid` exceeds `high`.

#### Output:
```
[0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2]
```

---

### **How This Will Work** 🖥️💬

The DNF algorithm is particularly useful in situations where you have an array with **fixed categories** (like 0s, 1s, and 2s), and you want to **sort it in one pass**. This could be applied to:

- **Sorting ballots** in an election with three parties.
- **Sorting products** on a shelf based on color (if the color categories are fixed).
- **Categorizing customer reviews** as positive, neutral, and negative.

---

### **Full Code with Comments** 🖥️✨

Here’s the complete code with detailed comments:

```java
public class DNFAlgo {
    /**
     * Sorts an array containing only 0s, 1s, and 2s using the Dutch National Flag Algorithm.
     * This approach uses three pointers (low, mid, high) for in-place sorting.
     */
    public static void sort012(int arr[]) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 2) {
                // Swap arr[mid] and arr[high]
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 2, 2, 0, 0, 1, 1, 0, 1, 2, 0, 0};
        sort012(arr);

        // Print sorted array
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }
}
```

---


### **Complexity Analysis** ⏱️📦

- **Time Complexity**: O(n), where `n` is the length of the array. The algorithm performs a **single pass** through the array.
- **Space Complexity**: O(1), as the algorithm uses only a few extra variables (`low`, `mid`, `high`).

---



---

### **Time Complexity Comparison** ⏱️

- **Counting Sort Approach**:
  - **Time Complexity**: O(n) – You make one pass through the array to count the occurrences, and then another pass to overwrite the array.
  - **Space Complexity**: O(1) for direct array manipulation. However, if you explicitly count, you might need O(3) space for the three counters.

- **Dutch National Flag Algorithm (DNF)**:
  - **Time Complexity**: O(n) – The algorithm performs a **single pass** through the array.
  - **Space Complexity**: O(1) – No extra space is used other than a few pointers.

---

### **Key Takeaways** 🚀

- The **Dutch National Flag Algorithm** (DNF) is the most efficient way to sort an array of 0s, 1s, and 2s.
- It uses only **constant space** and works in **linear time**, making it ideal for scenarios with constrained resources.
- By understanding the differences in time complexity, you can choose the most suitable approach based on the problem constraints.

---

🎉 **Awesome!** You've mastered another fundamental sorting technique! Keep exploring and applying your knowledge! 🚀