# Maximum Product Subarray – Brute, Better, and Optimized Approach

## 🧠 Problem Statement

Given an integer array `arr[]`, find the **maximum product** obtainable from any contiguous subarray.

**Example:**

- Input: `[1, 2, 3,[4]`
- Output: `24`  
- Explanation: The entire subarray `[1, 2,[3][4]` yields the maximum product.

## Intuition

The key challenge with maximum product subarrays, as opposed to maximum sum subarrays, is their *sensitivity to negative numbers and zeros*:

- **Negative Numbers:** Multiplying two negatives yields a positive value. Thus, a minimum (very negative) prefix can become the new maximum if a negative number is encountered later.
- **Zeros:** Multiplying by zero always resets the product.

Therefore, **both the current maximum and current minimum products** must be tracked during iteration—unlike sum problems, where only one running value suffices[1][9][13].

## 🪜 Approaches

Below, each approach is individually detailed: the rationale, their strengths, and code with practical commentary.

### 🚀 1. Brute Force Approach – O(N²)

#### ✔️ Idea

Try every possible subarray and calculate its product. Always record the highest product found.

#### 🔧 Steps

- Use two nested loops:
  - Outer loop for subarray start (`i`)
  - Inner loop for subarray end (`j`)
- For each subarray `arr[i...j]`, multiply elements and update `maxProduct` when a larger product is found.

#### 💡 Insight

- Handles negative/zero values naturally by evaluating all subarrays.
- Inefficient for large arrays[1][3][8][17].

#### 💻 Code

```java
public class Brute {
    public static void product(int arr[]) {
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            long product = 1;
            for (int j = i; j < arr.length; j++) {
                product *= arr[j];
                max = Math.max(max, product);
            }
        }
        System.out.println(max); // Output: 24
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        product(arr);
    }
}
```
- **Time Complexity:** O(N²) – every subarray is examined[1][3].
- **Space Complexity:** O(1) – just some variables for products and max.

#### 🧩 When to Use

- Small inputs
- Educational purposes or to build intuition

### ⚡ 2. Better Approach – Prefix and Suffix Traversals (O(N))

#### ✔️ Idea

Leverage the impact of zeros (reset the product) and negatives (flip min/max). By maintaining a running product from both the left and the right, all "restart" points are considered[1][11].

#### 🔧 Steps

- Traverse the array **left-to-right** (prefix) and **right-to-left** (suffix).
- For each pass, maintain a running product; reset to 1 if encountering zero.
- Keep updating the answer with the *maximum* found in any direction.

#### 💡 Insight

- Simple yet powerful: covers splits caused by zeros and flips due to negatives, without explicit DP.
- Traversal in both directions prevents missing subarrays starting after a zero or negative[1][11][3].

#### 💻 Code

```java
public class Better {
    public static int product(int[] nums) {
        int n = nums.length;
        long pre = 1, suff = 1;
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= nums[i];
            suff *= nums[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return (int) ans;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(product(arr)); // Output: 24
    }
}
```
- **Time Complexity:** O(N)
- **Space Complexity:** O(1)

#### 🧩 When to Use

- Quick, robust solution for most cases, especially if dynamic programming is overkill.
- Particularly effective when the data contains zeros or multiple negative regions.

### 🔥 3. Optimized Approach – Dynamic Programming (O(N))

#### ✔️ Idea

At every index, compute both:
- **currMax:** Largest product ending at this index.
- **currMin:** Smallest product (could turn into new max if another negative encountered).

Negative numbers swap the roles of `currMax` and `currMin`.

#### 🔧 Steps

- Initialize `currMax`, `currMin` to 1 and `ans` to the smallest integer value[9][13][15].
- For every element:
  - Calculate all candidate products:
    - The element itself (starting a new subarray)
    - Element × previous `currMax`
    - Element × previous `currMin`
  - Update `currMax`/`currMin` using `max`/`min` respectively.
  - Update global `ans` with `currMax`.

#### 💡 Insight

- Handles flips due to negative values in real time[13][9].
- This approach is **Kadane's Algorithm generalised for products** (instead of sums). Both `currMax` and `currMin` are crucial.
- Efficient and stable for large datasets.

#### 💻 Code

```java
public class Optimize {
    public static int product(int arr[]) {
        int currMax = arr[0], currMin = arr[0], ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int n = arr[i];
            if (n < 0) {
                // Swap, since multiplying by negative flips max/min
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            currMax = Math.max(n, currMax * n);
            currMin = Math.min(n, currMin * n);
            ans = Math.max(ans, currMax);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(product(arr)); // Output: 24
    }
}
```
- **Time Complexity:** O(N)[13][1][9]
- **Space Complexity:** O(1)

#### 🧩 When to Use

- For all production or interview settings.
- Handles all cases in a single left-to-right pass.
- Maintains correctness on arrays with positives, negatives, and zeros.

## 📊 Time and Space Complexity Table

| Approach       | Time Complexity | Space Complexity |
|:---------------|:---------------|:----------------|
| **Brute Force**| O(N²)          | O(1)            |
| **Better**     | O(N)           | O(1)            |
| **Optimized**  | O(N)           | O(1)            |

## 🔍 Approach-by-Approach Insights

- **Brute Force:**  
  Checks every contiguous segment; never misses a case. Infeasible for large N.

- **Better (Prefix/Suffix):**  
  Traverses left and right, effective for arrays with frequent zero resets. Simpler implementation than dynamic programming, but doesn't always provide subarray indices directly.

- **Optimized (DP):**  
  Maintains both current highest and lowest possible products at each step. Most robust; industry standard. Returns both the product and, with slight modification, the actual subarray if needed[1][9][13][15].

## ✅ Best Practice

- Start with Brute Force when learning, to deeply understand the search space.
- Use the Prefix/Suffix method for fast, easy code on typical test cases.
- Apply the DP (Optimized) approach for guaranteed correctness and optimal performance in all scenarios—*especially when negatives and zeros appear*.
