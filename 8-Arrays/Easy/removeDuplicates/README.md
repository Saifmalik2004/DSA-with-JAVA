

# 📝 **Remove Duplicates from Sorted Array**

## 1️⃣ **Problem Description**

Imagine you have an array of numbers 📈, but some of the numbers are repeated. Your task is to remove these duplicate values and return the **new length** of the array after the duplicates have been removed.

### Story:
You’re working with a list of customer IDs 🏷️ that a system has collected over time. For some reason, the system has stored some IDs multiple times. You want to clean up the list by removing all the duplicates so you only have unique customer IDs remaining. And here’s the catch: you’re not allowed to use extra memory, so you’ll have to perform the operation **in-place**. 

Let’s see how we can achieve this! 💡

---

## 2️⃣ **Step-by-Step Explanation of the Code**

### Our Goal:  
We need to remove duplicates from a sorted array without using any extra space. Sounds challenging? Don’t worry, we’ll take it step by step!

#### 1. **Initial Setup:**
We’ll have two pointers:  
- **Pointer `i`**: Will move through the array to check each element.
- **Pointer `j`**: Will track the position where the next unique element should go.

#### 2. **Iterate and Compare:**
We will compare each element in the array with the previous unique element and if it’s different, we will shift it into the unique position.

#### 3. **Return the Result:**
Finally, we return the length of the new array (i.e., the number of unique elements).

---

## 3️⃣ **Example Walkthrough**

### Input:  
```
[1, 1, 2, 2, 3, 3, 4]
```

### Step-by-Step Execution:

1. We start with the array `[1, 1, 2, 2, 3, 3, 4]` and two pointers:
   - `i = 1`, `j = 0` (first element is always unique, so we start comparing from the second element).

2. **First Iteration (`i = 1`):**
   - `arr[i] = 1` and `arr[j] = 1`. These are the same, so no change.
   
3. **Second Iteration (`i = 2`):**
   - `arr[i] = 2` and `arr[j] = 1`. These are different, so we increment `j` to `1` and place `2` at position `j+1`.
   - Now, the array is `[1, 2, 2, 2, 3, 3, 4]`.

4. **Third Iteration (`i = 3`):**
   - `arr[i] = 2` and `arr[j] = 2`. These are the same, so no change.
   
5. **Fourth Iteration (`i = 4`):**
   - `arr[i] = 3` and `arr[j] = 2`. These are different, so we increment `j` to `2` and place `3` at position `j+1`.
   - Now, the array is `[1, 2, 3, 2, 3, 3, 4]`.

6. **Continue this process...**
   - After all iterations, the array will look like: `[1, 2, 3, 4, 3, 3, 4]`.

7. **The final unique length is `4`.**  
   The new array with unique elements is `[1, 2, 3, 4]`.

---

## 4️⃣ **Approach**

We are solving this problem by using the **two-pointer technique**:
- One pointer (`j`) keeps track of the last unique element's position.
- The second pointer (`i`) scans through the array. If `arr[i]` is different from `arr[j]`, it means we have found a new unique element and we move it to the next position (`j+1`).

This method allows us to achieve the task **in-place** without using any extra memory. 🎯

---

## 5️⃣ **Pseudo Code**

Here's the simplified version of our approach:

```
function removeDuplicates(arr):
    j = 0
    for i from 1 to arr.length-1:
        if arr[i] != arr[j]:
            j++
            arr[j] = arr[i]
    return j + 1
```

---

## 6️⃣ **Full Code with Comments**

Here’s the complete code for removing duplicates:

```java
public class Optimize {
    // Function to remove duplicates from a sorted array
    public static int removeDuplicates(int[] arr, int n) {
        int j = 0;  // j will track the index of unique elements

        // Loop through the array from the second element
        for (int i = 1; i < n; i++) {
            // Check if the current element is different from the last unique element
            if (arr[i] != arr[j]) {
                j++;  // Move the unique pointer forward
                arr[j] = arr[i];  // Place the new unique element at the new position
            }
        }

        // Return the length of the unique elements array (j+1 because j is an index)
        return j + 1;
    }

    public static void main(String[] args) {
        // Example array with duplicates
        int[] arr = {1, 1, 2, 2, 3, 3, 4};
        int n = arr.length;
        
        // Get the number of unique elements
        int newLength = removeDuplicates(arr, n);
        
        // Print the number of unique elements
        System.out.println("Number of unique elements: " + newLength);
        
        // Print the unique array elements
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");  // Output: 1 2 3 4
        }
    }
}
```

---

## 7️⃣ **Complexity Analysis**

### Time Complexity:  
- **O(n)**: We only loop through the array once, where `n` is the size of the array.

### Space Complexity:  
- **O(1)**: We don’t use any extra space except for the pointers, so the space complexity is constant.

---

## 8️⃣ **Key Takeaways**

✨ **Lessons learned**:
- Two-pointer technique is a great way to solve array problems efficiently.
- You can modify an array in place without using extra space, which is both memory-efficient and fast.

🚀 **Motivational note**: You're one step closer to mastering array manipulation and space optimization! Keep it up!

