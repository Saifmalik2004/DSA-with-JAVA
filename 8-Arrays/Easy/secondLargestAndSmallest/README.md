### README: **Find the Second Largest and Second Smallest Numbers** ✨  

---

#### 1️⃣ **Problem Description**  
Imagine you're organizing a friendly competition 🎉. Each participant has a unique score, but you want to reward not just the top scorer but also the runner-up (2nd highest). Similarly, you want to acknowledge the 2nd lowest score for encouragement.  

Your job is to **find the second largest and second smallest numbers in a list of scores**. Sounds simple? Let's dive in! 🏆  

---

#### 2️⃣ **Step-by-Step Explanation of the Code** 🛠️  
We explored three ways to solve the problem:  

1. **Brute Force Approach (Simple but less efficient)**:  
   - Sort the array first.
   - Grab the second smallest and second largest by their positions in the sorted list.  

2. **Better Approach (Efficient and Cleaner)**:  
   - Use two loops:
     - First, find the largest and smallest values.
     - Second, find the second largest and smallest values by ignoring the largest and smallest.  

3. **Optimized Approach (Elegant and Fast)**:  
   - Do everything in one pass:
     - Track both the largest/smallest and second largest/smallest while looping through the array.  

---

#### 3️⃣ **Example Walkthrough** 🌟  
**Input**: `[3, 4, 5, 2]`  

- **Brute Force**:
  - Step 1: Sort the array → `[2, 3, 4, 5]`  
  - Step 2: Second smallest = `3`, Second largest = `4`.  
  - Output: `[3, 4]`  

- **Better Approach**:
  - Step 1: Find the largest = `5` and smallest = `2`.  
  - Step 2: Find second largest = `4` and second smallest = `3`.  
  - Output: `[3, 4]`  

- **Optimized Approach**:  
  - Track largest and smallest in the same loop.  
  - Track second largest and second smallest in one pass.  
  - Output: `[3, 4]`  

---

#### 4️⃣ **Approach** 💡  
| **Approach**       | **Time Complexity** | **Why?**                                                |  
|---------------------|---------------------|--------------------------------------------------------|  
| **Brute Force**     | O(n log n)          | Sorting dominates the runtime.                        |  
| **Better Approach** | O(2n) ≈ O(n)        | Two loops; one for largest/smallest, one for second.  |  
| **Optimized**       | O(n)                | One loop; all logic handled in a single pass.         |  

---

#### 5️⃣ **Pseudo Code** 📝  

**Optimized Approach**:  
```plaintext
1. Initialize largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE.  
2. Initialize smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE.  
3. For each number in the array:
   a. If the number > largest:
      - Update secondLargest = largest.
      - Update largest = number.
   b. Else if the number > secondLargest and number != largest:
      - Update secondLargest = number.
   c. If the number < smallest:
      - Update secondSmallest = smallest.
      - Update smallest = number.
   d. Else if the number < secondSmallest and number != smallest:
      - Update secondSmallest = number.
4. Return [secondSmallest, secondLargest].
```

---

#### 6️⃣ **Full Code with Comments** 🖥️💬  

Here’s the **optimized solution** for clarity:  

```java
public class Optimize {

    // Method to find the second largest and smallest numbers
    public static int[] findSlargestAndSmallest(int arr[]) {
        int largest = Integer.MIN_VALUE;   // Largest initialized to smallest possible value
        int secondLargest = Integer.MIN_VALUE; // Second largest initialized similarly
        int smallest = Integer.MAX_VALUE; // Smallest initialized to largest possible value
        int secondSmallest = Integer.MAX_VALUE; // Second smallest initialized similarly

        // Single loop to find both largest/smallest and second largest/smallest
        for (int num : arr) {
            // Update largest and second largest
            if (num > largest) {
                secondLargest = largest; // Previous largest becomes second largest
                largest = num; // Update largest
            } else if (num > secondLargest && num != largest) {
                secondLargest = num; // Update second largest if conditions met
            }

            // Update smallest and second smallest
            if (num < smallest) {
                secondSmallest = smallest; // Previous smallest becomes second smallest
                smallest = num; // Update smallest
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num; // Update second smallest if conditions met
            }
        }

        return new int[]{secondSmallest, secondLargest}; // Return results
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 2}; // Example input

        // Call the method and store the result
        int[] result = findSlargestAndSmallest(arr);

        // Print the second smallest and second largest
        System.out.println("Second Smallest: " + result[0]);
        System.out.println("Second Largest: " + result[1]);
    }
}
```

---

#### 7️⃣ **Complexity Analysis** 🔍  
- **Time Complexity**:  
  - Brute Force: O(n log n) (due to sorting).  
  - Optimized: O(n) (single loop for all operations).  

- **Space Complexity**:  
  - Brute Force: O(n) (extra space for list).  
  - Optimized: O(1) (constant space).  

---

#### 8️⃣ **Key Takeaways** 🚀  
1. Sorting is easy but often not the most efficient solution.  
2. Optimizing for **single-pass solutions** saves time in larger datasets.  
3. Practice tracking multiple variables in one loop—it’s a great skill for coding interviews!  

✨ **Keep coding! Each step is a step closer to mastery.** 💪  