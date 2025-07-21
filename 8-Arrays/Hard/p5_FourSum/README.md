
# 🔢 4Sum Problem - Find Unique Quadruplets Summing to Target

## 📜 Problem Statement

Given an array `nums` of `n` integers, return all **unique quadruplets** `[nums[a], nums[b], nums[c], nums[d]]` such that:

* `a`, `b`, `c`, and `d` are **distinct indices**
* `nums[a] + nums[b] + nums[c] + nums[d] == target`

You must return the **list of quadruplets** without any **duplicates**.

---

## 🧠 Intuition

This is an extension of the classic 2Sum and 3Sum problems. The naive way is to check all combinations (brute force), but we can improve it using **hashing** and eventually **two-pointer** technique on a **sorted array**.

---

# 🥇 Approach 1: Brute Force (O(N⁴·logK))

### ✅ Intuition:

* Check every possible combination of 4 elements using **4 nested loops**.
* If their sum is equal to the target (say `0`), store it in a `Set` to ensure uniqueness.

### 📦 Time Complexity:

* **O(N⁴)** for 4 nested loops + **O(logK)** for inserting sorted list in a set.

### ✅ Code:

```java
import java.util.*;

public class Brute {
    public static List<List<Integer>> fourSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == 0) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            temp.sort(null);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(arr));
    }
}
```

---

# 🥈 Approach 2: Better using HashSet (O(N³·logK))

### ✅ Intuition:

* Fix the **first two numbers** using two loops.
* For the next two, use a **HashSet** to find the fourth number by subtracting the sum from the target.
* Store sorted quadruplets in a set to handle duplicates.

### ⚠ Note:

* This still may contain duplicate calculations due to re-use of same element combinations.

### ✅ Code:

```java
import java.util.*;

public class Better {
    public static List<List<Integer>> four(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        int target = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashSet = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = target - sum;

                    if (hashSet.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        temp.sort(null);
                        set.add(temp);
                    }
                    hashSet.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, -1, 0, -2, 2};
        System.out.println(four(arr));
    }
}
```

---

# 🥇🥇 Approach 3: Optimized (Two-Pointer + Sorting) - O(N³)

### ✅ Intuition:

* Sort the array to use **two pointers**.
* Fix two numbers using two nested loops.
* Use two pointers to find the remaining two numbers.
* **Skip duplicates** at every level to avoid repetition.

### 🔥 This is the most efficient solution for the 4Sum problem.

### ✅ Code:

```java
import java.util.*;

public class Optimize {
    public static List<List<Integer>> four(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1, l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 4, 1, 2, 5, 4};
        System.out.println(four(arr, 8));
    }
}
```

---

## 📊 Comparison Table

| Approach      | Time Complexity | Space Complexity | Avoids Duplicates  | Technique Used      |
| ------------- | --------------- | ---------------- | ------------------ | ------------------- |
| Brute Force   | O(N⁴·logK)      | O(K)             | Yes (via Set)      | 4 nested loops      |
| Better (Hash) | O(N³·logK)      | O(N + K)         | Yes (via Set)      | 2 Loops + HashSet   |
| Optimized     | O(N³)           | O(K)             | Yes (via pointers) | Sorting + 2-Pointer |

---

## 💡 Final Notes

* Always **sort** the array in optimized methods to manage duplicates and use two pointers efficiently.
* Using **HashSet** helps avoid redundant quadruplets but has higher space usage.
* Optimized approach is best for large inputs, and handles duplicates well with minimal extra space.

---
