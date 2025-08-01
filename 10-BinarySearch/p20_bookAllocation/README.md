
# 📚 Book Allocation Problem

## 🧾 Problem Statement

You are given an array of integers `arr[]` where `arr[i]` represents the number of pages in the `i-th` book. There are `m` students, and the task is to allocate books to the students such that:

- Each book is allocated to exactly one student.
- Each student must be assigned **at least one** book.
- The books are allocated in a **contiguous** manner (i.e., no skipping books for a student).
- The goal is to **minimize the maximum number of pages assigned to a student**.

### 🔢 Input

- `arr = [1, 2, 3, 4]` (number of pages in each book)
- `m = 2` (number of students)

### 🎯 Output

- The **minimum** of the **maximum** number of pages assigned to a student, after allocation.

---

## 🧠 Intuition

We need to **divide books among students**, such that the **student with the maximum pages gets the minimum possible pages**. This is a classic **search space** optimization problem.

Rather than trying all possible distributions (which is inefficient), we’ll use **Binary Search** to find the answer efficiently.

---

## 🧩 Approach (Step-by-Step)

### Step 1️⃣: Understand the Search Space

- **Minimum possible answer (`low`)** = max number of pages in a book (every student gets at least one full book).
- **Maximum possible answer (`high`)** = sum of all pages (only one student gets all books).

### Step 2️⃣: Binary Search

We apply binary search on this range `[low, high]`.

- For a `mid` value (i.e., a candidate for max pages per student), we check:
  - **Is it possible to allocate books** such that no student gets more than `mid` pages?
- If **yes**, try a smaller value (`high = mid - 1`) to minimize further.
- If **no**, try a larger value (`low = mid + 1`).

### Step 3️⃣: Validity Check (Greedy)

To check whether a candidate `mid` is valid:
- Start assigning books to the current student.
- If adding a book exceeds `mid`, allocate the book to the next student.
- If number of students needed > `m`, then `mid` is invalid.

---

## 💻 Code

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Optimize {

    public static int bookAlocate(ArrayList<Integer> arr, int n, int m) {
        if (n < m) return -1;

        long sum = 0;
        for (int elem : arr) {
            sum += elem;
        }

        int low = Collections.max(arr); // Maximum pages in a single book
        int high = (int) sum;           // Sum of all pages
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(arr, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isValid(ArrayList<Integer> arr, int maxAl, int m) {
        int student = 1, pages = 0;

        for (int num : arr) {
            if (pages + num > maxAl) {
                student++;
                pages = num;
                if (student > m) return false;
            } else {
                pages += num;
            }
        }
        return student <= m;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(bookAlocate(arr, arr.size(), 2)); // Output: 6
    }
}
````

---

## 🔎 Example Walkthrough

Input: `arr = [1, 2, 3, 4]`, `m = 2`

### Step 1: Initial Range

* `low = max(arr) = 4`
* `high = sum(arr) = 10`

### Step 2: Binary Search Iterations

* `mid = (4+10)/2 = 7`

  * Can we allocate with max 7 pages per student?
  * Yes → Try smaller → `high = 6`, `ans = 7`
* `mid = (4+6)/2 = 5`

  * Not possible → `low = 6`
* `mid = (6+6)/2 = 6`

  * Yes → Try smaller → `high = 5`, `ans = 6`

Now `low > high`, so loop ends and final answer = `6`

📘 Allocation: `[1, 2, 3]` to student 1, `[4]` to student 2 → max = 6

---

## ⏱️ Time and Space Complexity

| Type             | Complexity     |
| ---------------- | -------------- |
| Time Complexity  | O(N \* log(S)) |
| Space Complexity | O(1)           |

### Where:

* `N = number of books`
* `S = sum of pages - max page count` → search space range

---

## 🧠 Key Concepts

* Binary Search on Answer
* Greedy allocation strategy
* Optimization under constraints

---

## ✅ Final Notes

This is a great example of applying **Binary Search on the Answer** — a powerful pattern in algorithmic problem-solving. Understanding the **search space** and **greedy check** are crucial here.

```
