
# 🧑‍💻 **Find the Single Element in an Array**

## 1️⃣ **Problem Description**

Imagine you're at a party 🎉, and everyone is paired up with someone. The only problem is, one person showed up alone! 🤔

You are given an array of numbers where every number appears twice, except for one. Your job is to find that single number. Can you spot the lonely person? 🤫

Example:  
Input: `[4, 1, 2, 1, 2]`  
Output: `4` (because 4 is the only number that doesn't have a partner!) 😲

---

## 2️⃣ **Step-by-Step Explanation of the Code**

Let's break this down into easy-to-follow steps:

### Brute Force Approach:
1. **Use a HashMap**: We’ll store each number and how many times it appears.
2. **Count Occurrences**: For each number, we add one to its count in the HashMap.
3. **Find the Lonely Number**: Finally, we check which number has a count of `1`—that’s our answer!

**Code Breakdown**:
```java
public static int getSingleElement(int[] arr) {
    // Step 1: Create a HashMap to store numbers and their counts
    HashMap<Integer, Integer> mpp = new HashMap<>();

    // Step 2: Populate the HashMap with the array values and their counts
    for (int i = 0; i < arr.length; i++) {
        int value = mpp.getOrDefault(arr[i], 0);  // Get the count, defaulting to 0
        mpp.put(arr[i], value + 1);  // Increment the count
    }

    // Step 3: Find the element that occurs only once
    for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
        if (it.getValue() == 1) {
            return it.getKey();  // Return the element that appears only once
        }
    }

    return -1;  // Default return in case no such element exists (shouldn't happen)
}
```

---

## 3️⃣ **Example Walkthrough** 🌟

Let’s go through an example with the array `[4, 1, 2, 1, 2]`.

### Step 1: Build the HashMap
We go through each element in the array:
- `4`: Count = 1
- `1`: Count = 1
- `2`: Count = 1
- `1`: Count = 2
- `2`: Count = 2

After this step, our HashMap looks like this:
```
{4=1, 1=2, 2=2}
```

### Step 2: Find the Single Element
Now, we go through the HashMap to find the key with a count of `1`. That’s the lonely number:
```
4 (count = 1) → Return 4
```

### Final Output:  
The single element is `4`. 🎉

---

## 4️⃣ **Approach** 💡

### Brute Force Approach:
- **How it works**: We use a HashMap to count the occurrences of each number in the array. Then, we scan the HashMap to find the number that occurs only once.
- **Why it works**: This approach is simple but not the most efficient.
  
### Optimized Approach:
- **XOR Trick**: Here’s a clever trick using XOR to do the same thing, but much faster. The key idea is:
    - **Property of XOR**: `a ^ a = 0` (XOR-ing a number with itself gives 0)
    - **Property of XOR**: `a ^ 0 = a` (XOR-ing with 0 keeps the number unchanged)

By XOR-ing all the elements in the array, paired numbers cancel each other out, leaving the single element. 🚀

**Optimized Code**:
```java
public static int getSingleElement(int[] arr) {
    int xor = 0; // Initialize XOR accumulator
    
    // XOR all the elements in the array
    for (int i = 0; i < arr.length; i++) {
        xor = xor ^ arr[i]; // XOR current element with the accumulator
    }
    
    // Return the single element (the one that doesn't get cancelled)
    return xor;
}
```

---

## 5️⃣ **Pseudo Code** 📝

```text
Initialize xor = 0

For each element in the array:
    XOR the element with xor

Return the final value of xor
```

---

## 6️⃣ **Full Code with Comments** 🖥️💬

Here’s the full code with detailed comments to help you understand:

```java
import java.util.*;

public class Better {
    // Method to find the single (non-repeating) element in the array
    public static int getSingleElement(int[] arr) {
        // Create a HashMap to count occurrences of each element
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        // Count occurrences of each element in the array
        for (int i = 0; i < arr.length; i++) {
            int value = mpp.getOrDefault(arr[i], 0);  // Get the current count of arr[i]
            mpp.put(arr[i], value + 1);  // Increment the count
        }
        
        // Find and return the element that appears only once
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {  // If the count is 1, we found the single element
                return it.getKey();
            }
        }
        
        // Return -1 if no such element exists (shouldn't happen)
        return -1;
    }

    public static void main(String args[]) {
        // Input array where every element appears twice except one
        int[] arr = {4, 1, 2, 1, 2};
        
        // Call the method and print the result
        int ans = getSingleElement(arr);
        System.out.println("The single element is: " + ans);  // Output: 4
    }
}

```

---

## 7️⃣ **Complexity Analysis** 🔍

- **Time Complexity**:
    - Brute Force: O(n) (We traverse the array twice—once to build the HashMap and once to find the lonely element)
    - Optimized: O(n) (We only traverse the array once)
  
- **Space Complexity**:
    - Brute Force: O(n) (We store the count of each number in a HashMap)
    - Optimized: O(1) (We use only one variable for XOR)

---

## 8️⃣ **Key Takeaways** 🚀

- **Brute Force**: Using a HashMap is simple and intuitive but not space-efficient. 🏃‍♂️
- **Optimized Approach**: XOR is a clever way to solve this problem in O(n) time and O(1) space. 💡
- **You’re one step closer to mastering problem-solving with arrays! Keep it up! 😄**

---

That's it! 🎉 You've now learned two approaches to solving the "Find the Single Element" problem. Keep practicing and soon, you’ll be solving even trickier problems like a pro! 💪🚀

