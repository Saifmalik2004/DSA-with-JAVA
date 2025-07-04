# 🚀 Array Rotation Made Easy: Two Approaches to Rotate an Array by `d` Positions

Rotating an array may sound complex, but don't worry! In this README, we'll break down two approaches to rotating an array by `d` positions: a **Brute Force Approach** 🐢 and an **Optimized Approach** 🚀. Let’s dive in! ✨

---

## 1️⃣ **Problem Description**  
Imagine you have an array of numbers, and you want to "rotate" it to the left by `d` positions.  

For example:  
👉 Input: `arr = [1, 2, 3, 4, 5, 6]`, `d = 2`  
👉 Output: `arr = [3, 4, 5, 6, 1, 2]`

### Scenario:  
You’re sorting some items in a circle, like chairs around a table. You want the person sitting in the first chair to move to the last chair, and everyone else to move one chair left. After `d` such rotations, where does everyone end up? Let’s find out! 🪑  

---

## 2️⃣ **Step-by-Step Explanation of the Code**  

### **Brute Force Approach** 🐢  

1. **Store the First `d` Elements**:  
   Create a temporary array (`temp`) to store the first `d` elements of the array.  

2. **Shift the Remaining Elements**:  
   Move the elements from index `d` to the beginning of the array.  

3. **Add Back the Stored Elements**:  
   Copy the stored elements from the temporary array to the end of the original array.  

---
## 3️⃣ **Example Walkthrough** 🌟  

### Input:  
`arr = [1, 2, 3, 4, 5, 6]`, `d = 2`

### **Brute Force Approach** 🐢  

1. **Store First `d` Elements**:  
   `temp = [1, 2]`

2. **Shift Remaining Elements**:  
   `arr = [3, 4, 5, 6, 5, 6]` → Update to → `arr = [3, 4, 5, 6]`

3. **Add Back Stored Elements**:  
   Copy `temp` back: `arr = [3, 4, 5, 6, 1, 2]`

---
## 6️⃣ **Full Code with Comments** 🖥️💬  

### **Brute Force Approach**:
```java
import java.util.ArrayList;

public class Brute {
    public static void roatedByD(int arr[], int d) {
        int n = arr.length;
        d = d % n; // Handle cases where d > n

        // Step 1: Store first 'd' elements in a temporary list
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            temp.add(arr[i]);
        }

        // Step 2: Shift remaining elements to the left
        int start = 0;
        for (int j = d; j < n; j++) {
            arr[start++] = arr[j];
        }

        // Step 3: Copy temporary elements back to the end
        for (int j = n - d; j < n; j++) {
            arr[j] = temp.get(j - (n - d));
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        roatedByD(arr, 2);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```
### **Optimized Approach** 🚀  

The optimized approach uses **reversals** to rotate the array in-place. This eliminates the need for a temporary array.  

1. **Divide the Array into Two Parts**:  
   - First part: From index `0` to `d-1`.  
   - Second part: From index `d` to `n-1`.  

2. **Reverse the First Part**:  
   Reverse the first `d` elements.  

3. **Reverse the Second Part**:  
   Reverse the remaining elements of the array.  

4. **Reverse the Entire Array**:  
   Finally, reverse the whole array to achieve the rotation.  

---
### Optimized:  
```text
1. Reverse the first `d` elements.
2. Reverse the remaining elements from `d` to `n-1`.
3. Reverse the entire array.
```

---
### **Optimized Approach code**:
```java
public class Optimize {
    public static void reverse(int arr[], int first, int last) {
        while (first < last) {
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;
            last--;
        }
    }

    public static void rotatedByk(int arr[], int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k > n

        // Step 1: Reverse the first 'k' elements
        reverse(arr, 0, k - 1);

        // Step 2: Reverse the remaining elements
        reverse(arr, k, n - 1);

        // Step 3: Reverse the entire array
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        rotatedByk(arr, 2);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍  

| Approach        | Time Complexity | Space Complexity |
|-----------------|----------------|-----------------|
| Brute Force     | \(O(n)\)        | \(O(d)\)         |
| Optimized       | \(O(n)\)        | \(O(1)\)         |

---

## 8️⃣ **Key Takeaways** 🚀  

- **Brute Force** is simple and intuitive but uses extra space for temporary storage.  
- **Optimized Approach** is faster in terms of space, as it uses in-place reversal.  
- Understanding array manipulations like rotation strengthens your problem-solving skills. 💪  
- You’re one step closer to mastering array algorithms! 🌟  

🎉 Keep coding and enjoy the journey! 🚀