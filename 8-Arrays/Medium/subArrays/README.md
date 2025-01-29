
# 🚀 Subarray Sum Explorer in Java 🧮

This program is designed to **explore all possible subarrays** in an array, calculate the **sum of each subarray**, and find the **smallest** and **largest** sums! 💡

Whether you're new to subarrays or just curious about how to find the maximum and minimum sums, this program makes it simple and fun!

---

## 💻 How Does It Work?

Imagine you have an array like this:

```java
int num[] = {1, 2, 3, 4, 5, 8};
```

### What’s a Subarray? 🤔

A subarray is just a **continuous slice** of an array. For example, with the array above:

- One subarray could be `[1, 2]`
- Another subarray could be `[3, 4, 5]`
- Even a single element like `[8]` counts as a subarray!

### Objective of the Program 🎯

For every subarray, the program will:
1. **Print the elements** of the subarray.
2. **Calculate the sum** of the subarray.
3. **Track** the smallest and largest subarray sums found so far.
4. **Print the total number** of subarrays along with the **minimum** and **maximum** subarray sums!

---

## ⚙️ Example Run

Let’s use an example array:

```java
int num[] = {1, 2, 3};
```

### Output:
```bash
1  Sum: 1
1 2  Sum: 3
1 2 3  Sum: 6

2  Sum: 2
2 3  Sum: 5

3  Sum: 3

Total number of subarrays: 6
Minimum sum of subarrays: 1
Maximum sum of subarrays: 6
```

### Explanation:
- The subarray `[1]` has a sum of `1`.
- The subarray `[1, 2]` has a sum of `3`.
- The subarray `[1, 2, 3]` has a sum of `6`.
- The smallest sum is `1`, and the largest sum is `6`.

---

## 🧐 Dry Run of the Code with an Array of 4 Elements

Let’s break down the program with an example array of **4 elements**:

```java
int num[] = {2, 4, 6, 8};
```

### Subarray Breakdown & Dry Run:

1. Start at index 0:
   - Subarray: `[2]`, Sum: `2`
   - Subarray: `[2, 4]`, Sum: `6`
   - Subarray: `[2, 4, 6]`, Sum: `12`
   - Subarray: `[2, 4, 6, 8]`, Sum: `20`

2. Start at index 1:
   - Subarray: `[4]`, Sum: `4`
   - Subarray: `[4, 6]`, Sum: `10`
   - Subarray: `[4, 6, 8]`, Sum: `18`

3. Start at index 2:
   - Subarray: `[6]`, Sum: `6`
   - Subarray: `[6, 8]`, Sum: `14`

4. Start at index 3:
   - Subarray: `[8]`, Sum: `8`

### Results:
- **Total subarrays**: 10
- **Minimum sum**: 2
- **Maximum sum**: 20

---

## 🛠 Different Approaches to Find Maximum Subarray Sum

### 1. Brute Force Approach 🐢

In the brute force approach, we generate all possible subarrays, calculate the sum of each one, and keep track of the maximum sum.

```java
public class MaxInSubArrayBruteForce {
    public static void maxSubArrayBruteForce(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println("Maximum sum of subarrays (Brute Force): " + maxSum);
    }
}
```

#### Complexity:
- **Time Complexity**: O(n^3) — due to three nested loops.
- **Space Complexity**: O(1) — only uses a few variables.

### 2. Prefix Sum Approach 📏

The prefix sum approach optimizes by precomputing sums. We calculate the prefix sum for each element and use it to find the subarray sums more efficiently.

```java
public class MaxInSubArrayPrefixSum {
    public static void maxSubArrayPrefixSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println("Maximum sum of subarrays (Prefix Sum): " + maxSum);
    }
}
```

#### Complexity:
- **Time Complexity**: O(n^2) — two nested loops.
- **Space Complexity**: O(n) — additional space for the prefix array.

### 3. Kadane’s Algorithm 🏆

Kadane’s Algorithm is the most efficient solution. It iterates once through the array, tracking the maximum sum as it goes.

```java
public class MaxInSubArrayKadaneAlgo {
    public static void maxSubArrayKadane(int[] arr) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println("Maximum sum of subarrays (Kadane's Algorithm): " + maxSum);
    }
}
```

#### Complexity:
- **Time Complexity**: O(n) — single loop through the array.
- **Space Complexity**: O(1) — only uses a few variables.

---

## 📜 Code Walkthrough

Here’s a sample implementation that explores all subarrays and finds the maximum and minimum sums:

```java
public class SubArrayExplorer {

    public static void exploreSubArrays(int num[]) {
        int total = 0; // Counter for total subarrays
        int minSum = Integer.MAX_VALUE; // Initially set to a very high value
        int maxSum = Integer.MIN_VALUE; // Initially set to a very low value

        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                int sum = 0; // Sum of the current subarray
                for (int k = i; k <= j; k++) {
                    System.out.print(num[k] + " ");
                    sum += num[k];
                }

                minSum = Math.min(minSum, sum); // Update minSum if current sum is smaller
                maxSum = Math.max(maxSum, sum); // Update maxSum if current sum is larger
                total++;
                System.out.print(" Sum: " + sum);
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total number of subarrays: " + total);
        System.out.println("Minimum sum of subarrays: " + minSum);
        System.out.println("Maximum sum of subarrays: " + maxSum);
    }

    public static void main(String[] args) {
        int num[] = {2, 4, 6, 8};
        exploreSubArrays(num);
    }
}
```

---

## 💡 Key Points:
- **Subarrays** are continuous segments of the array.
- We **print** and **sum** each subarray, tracking the smallest and largest sums.
- The program demonstrates multiple approaches: **Brute Force**, **Prefix Sum**, and **Kadane’s Algorithm** for maximum subarray sum.
- **Kadane's Algorithm** is the most efficient approach for finding the maximum sum of subarrays.

Feel free to experiment with different arrays and see how the subarrays and sums change!

Happy Coding! 😊