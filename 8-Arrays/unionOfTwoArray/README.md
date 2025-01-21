

# ✨ **Array Union Problem**  

Combine two arrays into a single collection of unique elements in sorted order. We’ll explore **two approaches** to solve this problem:  

1️⃣ **Set-Based Approach** (Simple and effective for unsorted arrays)  
2️⃣ **Pointer-Based Approach** (Optimized for sorted arrays)  

---

## 1️⃣ **Problem Description**  

Imagine you’re organizing a party 🎉. You have two guest lists:  

- `arr1` 📋: A list of confirmed attendees.  
- `arr2` 📋: A list of pending RSVPs.  

Now, you want to combine these lists into one **unique, sorted guest list** so you don’t accidentally invite anyone twice!  

For example:  

- **Input**:  
  `arr1 = [1, 2, 3, 4, 5, 6]`,  
  `arr2 = [1, 2, 3, 4, 8, 43, 22, 5, 6]`  
- **Output**: `[1, 2, 3, 4, 5, 6, 8, 22, 43]`  

---

## 2️⃣ **Approach 1: Set-Based (Using Hashing)**  

### 🔍 **How It Works**  

The **Set-Based Approach** is simple and effective for **unsorted arrays**. It leverages a `HashSet` to automatically remove duplicates and then sorts the elements. Here's how:  

1. Add all elements from the first array to a `HashSet`.  
2. Add all elements from the second array to the same `HashSet`.  
3. Convert the `HashSet` to a sorted list to get the final unique, sorted result.  

### 🛠️ **Step-by-Step Explanation of the Code**  

```java
// Function to compute the union of two arrays using HashSet
public static ArrayList<Integer> unionWithSet(int arr[], int arr1[]) {
    Set<Integer> set = new HashSet<>();  // HashSet to store unique elements

    // Step 1: Add elements of arr to the set
    for (int num : arr) {
        set.add(num);
    }

    // Step 2: Add elements of arr1 to the set
    for (int num : arr1) {
        set.add(num);
    }

    // Step 3: Convert set to a sorted list
    ArrayList<Integer> result = new ArrayList<>(set);
    Collections.sort(result);  // Ensure the result is sorted

    return result;
}
```

### 🌟 **Example Walkthrough**  

**Input**:  
`arr = [1, 2, 3, 4, 5, 6]`  
`arr1 = [1, 2, 3, 4, 8, 43, 22, 5, 6]`  

**Steps**:  
1. Add `1, 2, 3, 4, 5, 6` from `arr` to the `HashSet`.  
2. Add `8, 43, 22` from `arr1` to the `HashSet`.  
3. Convert the `HashSet` to a sorted list: `[1, 2, 3, 4, 5, 6, 8, 22, 43]`.  

**Output**: `[1, 2, 3, 4, 5, 6, 8, 22, 43]`  

---

### 📝 **Pseudo Code**  

```plaintext
1. Create an empty HashSet to store unique elements.
2. Add all elements of arr to the HashSet.
3. Add all elements of arr1 to the HashSet.
4. Convert the HashSet to a sorted list.
5. Return the sorted list.
```

---

## 3️⃣ **Approach 2: Pointer-Based (Optimized for Sorted Arrays)**  

### 🔍 **How It Works**  

The **Pointer-Based Approach** works best for **already sorted arrays**. It uses two pointers to traverse the arrays simultaneously:  

1. Start with two pointers (`i` and `j`), each pointing to the first element of their respective arrays.  
2. Compare the elements at `arr[i]` and `arr1[j]`.  
3. Add the smaller element to the result and move the corresponding pointer forward.  
4. Skip duplicates by checking if the last element added is the same as the current one.  
5. After one array is exhausted, add the remaining elements from the other array to the result.  

### 🛠️ **Step-by-Step Explanation of the Code**  

```java
// Function to compute the union of two sorted arrays
public static ArrayList<Integer> union(int arr[], int arr1[]) {
    ArrayList<Integer> union = new ArrayList<>();  // To store the unique union
    int i = 0, j = 0;  // Pointers for the two arrays

    // Step 1: Traverse both arrays
    while (i < arr.length && j < arr1.length) {
        if (arr[i] <= arr1[j]) {  // Compare current elements
            if (union.isEmpty() || union.get(union.size() - 1) != arr[i]) {
                union.add(arr[i]);  // Add to union if unique
            }
            i++;  // Move pointer of arr
        } else {
            if (union.isEmpty() || union.get(union.size() - 1) != arr1[j]) {
                union.add(arr1[j]);  // Add to union if unique
            }
            j++;  // Move pointer of arr1
        }
    }

    // Step 2: Add remaining elements of arr
    while (i < arr.length) {
        if (union.isEmpty() || union.get(union.size() - 1) != arr[i]) {
            union.add(arr[i]);
        }
        i++;
    }

    // Step 3: Add remaining elements of arr1
    while (j < arr1.length) {
        if (union.isEmpty() || union.get(union.size() - 1) != arr1[j]) {
            union.add(arr1[j]);
        }
        j++;
    }

    return union;
}
```

### 🌟 **Example Walkthrough**  

**Input**:  
`arr = [1, 2, 3, 4, 5, 6]`  
`arr1 = [1, 2, 3, 4, 8, 43, 22, 5, 6]`  

**Steps**:  
1. Compare `1` from `arr` and `1` from `arr1`. Add `1` to the result.  
2. Compare `2` and `2`. Add `2` to the result.  
3. Repeat for `3`, `4`, `5`, and `6`.  
4. Add the remaining unique elements (`8`, `22`, `43`) from `arr1`.  

**Output**: `[1, 2, 3, 4, 5, 6, 8, 22, 43]`  

---

### 📝 **Pseudo Code**  

```plaintext
1. Initialize two pointers i and j to 0.
2. Create an empty list `union`.
3. While i < arr.length and j < arr1.length:
   - If arr[i] <= arr1[j], add arr[i] to union (if unique) and move i forward.
   - Else, add arr1[j] to union (if unique) and move j forward.
4. Add remaining elements of arr (if unique) to union.
5. Add remaining elements of arr1 (if unique) to union.
6. Return union.
```

---

## 4️⃣ **Complexity Analysis**  

### **Set-Based Approach**:  
- **Time Complexity**: `O(n + m + k log k)` (Insertion in `HashSet` is `O(1)`; sorting is `O(k log k)`, where `k` is the number of unique elements)  
- **Space Complexity**: `O(k)` (HashSet + result list)  

### **Pointer-Based Approach**:  
- **Time Complexity**: `O(n + m)` (Traverse both arrays once)  
- **Space Complexity**: `O(n + m)` (Result array stores all unique elements)  

---

## 5️⃣ **Key Takeaways**  

- The **Set-Based Approach** is flexible and works well for unsorted arrays but is slower due to sorting.  
- The **Pointer-Based Approach** is highly efficient for sorted arrays.  
- Always analyze the input properties (e.g., sorted or unsorted) to choose the best approach.  

🚀 Keep practicing, and soon, you’ll master array problems like a pro! 💪  

--- 