# **Find the Longest Consecutive Sequence**

---

## **Problem Description**  
You are given an unsorted array of integers. Your task is to find the length of the longest sequence of consecutive elements in the array. The sequence must be formed by numbers appearing in any order but must be consecutive.

💡 **Real-Life Analogy**:  
Imagine you have a set of dominoes 🎲, each labeled with different numbers. If you want to create the longest chain of consecutive numbers, you’ll need to find the largest sequence where each number follows the previous one!

---

## **Example Input and Output**  

### **Example 1**  
**Input**:  
`arr = [100, 4, 200, 1, 3, 2]`  

**Output**:  
`4`  

**Explanation**: The longest consecutive sequence is `[1, 2, 3, 4]` with length 4.

### **Example 2**  
**Input**:  
`arr = [9, 1, 4, 7, 3, 2, 6, 5, 8]`  

**Output**:  
`9`  

**Explanation**: The longest consecutive sequence is `[1, 2, 3, 4, 5, 6, 7, 8, 9]` with length 9.

---

## **Approaches**



### **1. Brute Force Approach**

This approach is based on checking each number in the array to find its consecutive sequence, and it uses a nested loop.

#### **Step-by-Step Explanation of Code**  

1. **Sort the Array**  
   Sorting the array ensures that consecutive elements are placed next to each other.

   ```java
   Arrays.sort(arr);
   ```

   - `Arrays.sort(arr);`: This sorts the input array in ascending order. After sorting, the consecutive elements will be adjacent, making it easier to find sequences.

2. **Iterate Through the Array**  
   We loop through each element of the sorted array to check for consecutive numbers.

   ```java
   for (int i = 0; i < n; i++) {
       int curr = arr[i];
       int len = 1;
   ```

   - Here, `i` is the index of the current number `curr` in the sorted array.
   - `len = 1;`: We initialize the sequence length as 1 because we start counting from the current number.

3. **Search for Consecutive Numbers**  
   We check if the next number (current number + 1) is present in the array. If it is, we increment the sequence length.

   ```java
   while (search(arr, n, curr + 1)) {
       curr++;
       len++;
   }
   ```

   - `search(arr, n, curr + 1)`: We use the `search` method to check if the next consecutive number is present in the array. If it is, we increase the count (`len`) and move to the next consecutive number (`curr++`).

4. **Update the Maximum Length**  
   We compare the current sequence length with the maximum length encountered so far and update it.

   ```java
   maxLen = Math.max(maxLen, len);
   ```

   - We update `maxLen` to store the maximum sequence length found.

5. **Return the Maximum Length**  
   After iterating through all the elements, we return the maximum consecutive sequence length.

   ```java
   System.out.println(maxLen);
   ```

#### **Code**  
```java
import java.util.Arrays;

public class Brute {
    public static void maxConsecutive(int arr[]) {
        int n = arr.length;
        int maxLen = 1;
        Arrays.sort(arr);
        
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            int len = 1;

            while (search(arr, n, curr + 1)) {
                curr++;
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }

        System.out.println(maxLen);
    }

    public static boolean search(int arr[], int n, int key) {
        for (int i = 0; i < n; i++) {
            if (key == arr[i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {100, 4, 200, 1, 3, 2};
        maxConsecutive(arr); // Output: 4
    }
}
```

#### **Time and Space Complexity**
- **Time Complexity**: O(N²) (due to the nested loop in the `search` function)
- **Space Complexity**: O(1) (no extra space used)

---

### **2. Sorting Approach**

This approach involves sorting the array and then iterating through it to find the length of the longest consecutive sequence.

#### **Step-by-Step Explanation of Code**  

1. **Sort the Array**  
   Sorting the array places consecutive elements next to each other.

   ```java
   Arrays.sort(arr);
   ```

   - Sorting the array ensures that consecutive numbers are adjacent to each other.

2. **Initialize Variables**  
   We set up variables to track the current sequence length (`len`) and the maximum sequence length (`maxLen`).

   ```java
   int maxLen = 1, len = 1;
   ```

   - `maxLen = 1`: Initialize `maxLen` to 1, since at least one element will be present in the array.
   - `len = 1`: The initial sequence length is 1, as we start counting from the first number.

3. **Iterate Through the Sorted Array**  
   We loop through the sorted array to check if the current number forms a consecutive sequence with the previous number.

   ```java
   for (int i = 0; i < n; i++) {
       if (arr[i] == last + 1) {
           len++;
       } else if (arr[i] != last) {
           len = 1;
       }
       last = arr[i];
       maxLen = Math.max(maxLen, len);
   }
   ```

   - `if (arr[i] == last + 1)`: If the current number is one greater than the previous number, we increase the sequence length (`len++`).
   - `else if (arr[i] != last)`: If the current number is not equal to the previous number, we reset the sequence length (`len = 1`).
   - `maxLen = Math.max(maxLen, len)`: We update the maximum sequence length.

4. **Return the Maximum Length**  
   After iterating through all elements, we return the longest consecutive sequence length.

   ```java
   System.out.println(maxLen);
   ```

#### **Code**  
```java
import java.util.Arrays;

public class Better {
    public static void maxConsecutive(int arr[]) {
        int n = arr.length;
        int maxLen = 1, len = 1;
        Arrays.sort(arr);
        int last = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] == last + 1) {
                len++;
            } else if (arr[i] != last) {
                len = 1;
            }
            last = arr[i];
            maxLen = Math.max(maxLen, len);
        }

        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        int arr[] = {100, 4, 200, 1, 3, 2};
        maxConsecutive(arr); // Output: 4
    }
}
```

#### **Time and Space Complexity**
- **Time Complexity**: O(N log N) (due to sorting)
- **Space Complexity**: O(1) (no extra space used)

---

### **3. Optimized Approach (Using HashSet)**

This approach uses a `HashSet` to store the numbers and checks for the longest consecutive sequence in linear time.

#### **Step-by-Step Explanation of Code**  

1. **Insert All Elements into a HashSet**  
   We insert all elements from the array into a `HashSet` because it provides O(1) time complexity for lookups.

   ```java
   Set<Integer> set = new HashSet<>();
   ```

   - A `HashSet` is used to store unique elements of the array.

2. **Populate the HashSet**  
   Insert every number from the array into the `HashSet`.

   ```java
   for (int num : arr) {
       set.add(num);
   }
   ```

   - This ensures that we have unique elements and that each lookup will be efficient.

3. **Iterate Through the HashSet**  
   We loop through each number in the `HashSet` to find the start of a consecutive sequence.

   ```java
   for (int num : set) {
       if (!set.contains(num - 1)) {
           int currentNum = num;
           int count = 1;
   ```

   - The condition `if (!set.contains(num - 1))` ensures we start counting only from numbers that do not have a predecessor in the set.

4. **Count the Length of the Sequence**  
   Once we find the start of a sequence, we check for the next consecutive number and increase the sequence length.

   ```java
   while (set.contains(currentNum + 1)) {
       currentNum++;
       count++;
   }
   ```

   - The `while` loop checks if the next consecutive number (`currentNum + 1`) is present in the set, and if it is, we increment the current number and the sequence length.

5. **Update Maximum Length**  
   After finding the length of the current sequence, we compare it with the maximum sequence length.

   ```java
   maxLen = Math.max(maxLen, count);
   ```

6. **Return the Maximum Length**  
   Finally, we return the maximum length of the consecutive sequence.

   ```java
   return maxLen;
   ```

#### **Code**  
```java
import java.util.HashSet;
import java.util.Set;

public class Optimize {
    public static int maxConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;

        for (int num : arr) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = {100, 4, 200, 1, 3, 2};
        System.out.println(maxConsecutive(arr)); // Output: 4
    }
}
```

#### **Time and Space Complexity**
- **Time Complexity**: O(N) (using `HashSet` for O(1) lookups)
- **Space Complexity**: O(N) (due to the `HashSet` storing all the elements)

---



## **Final Thoughts**  
✅ **Brute Force** works but is inefficient for large inputs.  
✅ **Sorting** improves efficiency but still takes O(N log N).  
✅ **Using a HashSet** provides the optimal O(N) solution.  

🎯 **Best Approach**: Use the HashSet method for solving this problem efficiently. 🚀  

---
Let me know if you need any improvements! 😃

