# Allocation Books Problem 📚

## 1️⃣ **Problem Description**
Imagine you’re a librarian 📖 tasked with distributing `n` books, each containing a certain number of pages, among `m` students. Your ultimate goal is to minimize the maximum number of pages assigned to any single student. However, there are certain rules and constraints to follow:

1. **Each student must receive at least one book.**
   - You cannot leave any student without books.
2. **Each book can only be assigned to one student.**
   - Books cannot be shared between students.
3. **Books assigned to a student must be contiguous.**
   - If a student receives books, they must be in a sequence without skipping.

The problem is to determine an optimal way to distribute the books such that the maximum number of pages assigned to a single student is minimized. This ensures fairness in workload distribution.

### Real-Life Analogy
Imagine a group of students in a library preparing for an exam. The books have varying levels of content (pages), and you, as the librarian, want to assign the books such that no student feels overwhelmed. For instance:

- Books = `[1, 1, 2]` (pages)
- Students = `m = 2`

If you assign the books as follows:
- Student 1: `[1, 1]` (total pages = 2)
- Student 2: `[2]` (total pages = 2)

This distribution minimizes the maximum workload (pages) assigned to any single student. The result is `2`.


---

## 2️⃣ **Step-by-Step Explanation of the Code** 🛠️

### Step 1: Checking if a Distribution is Valid
To determine if a distribution is possible with a maximum allocation (`maxAllocation`):
- Assign books to students one by one.
- If the pages allocated to a student exceed `maxAllocation`, move to the next student.
- If the number of students exceeds `m`, the distribution is invalid.

```java
public static boolean isValid(int arr[], int n, int m, int maxAllocation) {
    int student = 1, pages = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] > maxAllocation) {
            return false; // A single book exceeds max allocation
        }
        if (pages + arr[i] <= maxAllocation) {
            pages += arr[i]; // Add pages to current student
        } else {
            student++; // Move to the next student
            pages = arr[i];
        }
    }
    return student <= m; // Check if within the student limit
}
```

---

### Step 2: Binary Search for Optimal Allocation
Using binary search, we find the minimum `maxAllocation`:
- Start with `start = 0` (minimum possible allocation).
- End with `end = sum of all pages` (maximum possible allocation).
- For each mid-point, check if the distribution is valid. If valid, update the answer and search for a smaller maximum.

```java
public static int allocationBooks(int arr[], int n, int m) {
    if (m > n) {
        return -1; // More students than books
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += arr[i];
    }

    int ans = -1;
    int start = 0, end = sum;

    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (isValid(arr, n, m, mid)) {
            ans = mid; // Update answer
            end = mid - 1; // Try smaller maximum
        } else {
            start = mid + 1; // Increase minimum
        }
    }

    return ans;
}
```

---

## 3️⃣ **Example Walkthrough** 🌟

### Input:
Books: `[1, 1, 2]`  
Students: `m = 2`

### Step-by-Step Execution:
1. **Initial Calculation:**
   - Sum of all pages = `4`.
   - Start = `0`, End = `4`.

2. **Binary Search Iterations:**
   - Mid = `(0 + 4) / 2 = 2`:
     - Check if valid:
       - Student 1: `[1, 1]` → Pages = `2`.
       - Student 2: `[2]` → Pages = `2`.
       - Valid, update `ans = 2`, End = `1`.
   - Mid = `(0 + 1) / 2 = 0`:
     - Invalid (no distribution possible).
   - Mid = `1`:
     - Valid, update `ans = 1`, End = `0`.

3. **Result:** Minimum Maximum Pages = `2`.

---

## 4️⃣ **Approach** 💡
We use a binary search on the range of possible allocations. For each mid-point, we check if it’s a valid allocation using the helper function `isValid`. This approach ensures we efficiently find the minimum possible maximum allocation.

---

## 5️⃣ **Pseudo Code** 🖋
```plaintext
function isValid(arr, n, m, maxAllocation):
    student = 1, pages = 0
    for i from 0 to n-1:
        if arr[i] > maxAllocation:
            return false
        if pages + arr[i] <= maxAllocation:
            pages += arr[i]
        else:
            student++
            pages = arr[i]
    return student <= m

function allocationBooks(arr, n, m):
    if m > n:
        return -1
    sum = sum of arr
    start = 0, end = sum, ans = -1
    while start <= end:
        mid = (start + end) / 2
        if isValid(arr, n, m, mid):
            ans = mid
            end = mid - 1
        else:
            start = mid + 1
    return ans
```

---

## 6️⃣ **Full Code with Comments** 💻✨
```java
public class Greedy {
    public static boolean isValid(int arr[], int n, int m, int maxAllocation) {
        int student = 1, pages = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxAllocation) {
                return false; // A single book exceeds max allocation
            }
            if (pages + arr[i] <= maxAllocation) {
                pages += arr[i]; // Add pages to current student
            } else {
                student++; // Move to the next student
                pages = arr[i];
            }
        }
        return student <= m; // Check if within the student limit
    }

    public static int allocationBooks(int arr[], int n, int m) {
        if (m > n) {
            return -1; // More students than books
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int ans = -1;
        int start = 0, end = sum;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(arr, n, m, mid)) {
                ans = mid; // Update answer
                end = mid - 1; // Try smaller maximum
            } else {
                start = mid + 1; // Increase minimum
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2};
        int n = 3, m = 2;

        System.out.println(allocationBooks(arr, n, m)); // Output: 2
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍

### Time Complexity:
- Binary search on the range: \(O(\log(sum))\)
- Validity check: \(O(n)\)
- **Overall:** \(O(n \log(sum))\).

### Space Complexity:
- Constant space: \(O(1)\).

---

## 8️⃣ **Key Takeaways** 🚀
- The binary search approach reduces the problem’s complexity drastically.
- Helper functions like `isValid` make it easy to modularize the solution.
- Thinking in terms of ranges and validity is crucial for optimization problems.

You’re doing awesome! Keep solving problems and sharpening your skills! 🌟💪



