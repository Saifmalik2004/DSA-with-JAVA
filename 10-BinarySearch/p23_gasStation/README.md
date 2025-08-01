# 🚗 Problem: Minimize the Maximum Distance Between Gas Stations

You are given an array of integers `arr` that represents the positions of existing gas stations on a straight road. You are allowed to build `k` additional gas stations anywhere between the existing ones. The goal is to **minimize the maximum distance** between adjacent gas stations after adding all `k` new stations.

---

## ✅ What Does It Mean to Minimize Maximum Distance?

We want to add gas stations such that **no two consecutive stations** are farther apart than the **smallest possible maximum distance**.

---

## 🧠 Example

```java
arr = [1, 13, 17, 23]
k = 5
```

We have 3 gaps:

* (13 - 1) = 12
* (17 - 13) = 4
* (23 - 17) = 6

We need to insert 5 gas stations optimally in these segments to minimize the maximum gap.

---

# 🔢 Approaches

---

## 🔹 1. Brute Force Approach (Simulation)

### 🧠 Intuition

* Keep track of how many gas stations are added between each pair.
* On each iteration, choose the segment with the **largest current gap**, and add a gas station there.

### 📋 Pseudocode

```pseudo
Repeat K times:
    Find segment with max distance
    Add a gas station (increment counter for that segment)
Compute and return max segment length after all additions
```

### ✅ Pros

* Easy to implement
* Intuitive to simulate manually

### ❌ Cons

* Inefficient for large `k` or large arrays
* O(K \* N)

### 💻 Code

```java
public class Brute {
    public static double minMaxDis(int arr[], int k) {
        int n = arr.length;
        int[] howmany = new int[n - 1];

        for (int gas = 1; gas <= k; gas++) {
            double maxVal = -1;
            int maxIdx = -1;

            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double secLen = diff / (howmany[i] + 1);

                if (secLen > maxVal) {
                    maxVal = secLen;
                    maxIdx = i;
                }
            }
            howmany[maxIdx]++;
        }

        double maxVal = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double secLen = diff / (howmany[i] + 1);
            maxVal = Math.max(maxVal, secLen);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2};
        System.out.println(minMaxDis(arr, 5));
    }
}
```

---

## 🔹 2. Better Approach (Priority Queue / Greedy)

### 🧠 Intuition

* Greedy method: break the largest segment using a priority queue.
* Every time, break the segment that currently has the largest subinterval.

### 📋 Pseudocode

```pseudo
Use max heap (priority queue) storing (segment length, segment index)
Repeat k times:
    Pop max segment
    Increment station count for that segment
    Push new segment (divided length)
Return top segment length in heap
```

### ✅ Pros

* Much more efficient than brute force

### ❌ Cons

* Still not optimal for very large `k` (due to `k log n` complexity)

### 💻 Code

```java
import java.util.*;

public class Better {
    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static double gasMin(int arr[], int k) {
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        int[] howMany = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        for (int i = 1; i <= k; i++) {
            Pair tp = pq.poll();
            int secInd = tp.second;

            howMany[secInd]++;
            double initDiff = arr[secInd + 1] - arr[secInd];
            double secLen = initDiff / (howMany[secInd] + 1);
            pq.add(new Pair(secLen, secInd));
        }

        return pq.peek().first;
    }

    public static void main(String[] args) {
        int arr[] = {1, 13, 17, 23};
        System.out.println(gasMin(arr, 5));
    }
}
```

---

## 🔹 3. Optimized Approach (Binary Search on Answer)

### 🧠 Intuition

* Use binary search to guess the minimal max distance.
* For a given distance, calculate how many gas stations are needed.
* If it requires more than `k`, try larger distances. Otherwise, go smaller.

### 📋 Pseudocode

```pseudo
low = 0, high = max difference between stations
while (high - low > 1e-6):
    mid = (low + high) / 2
    cnt = numberOfStationsNeeded(mid)
    if cnt > k:
        low = mid
    else:
        high = mid
return high
```

### ✅ Pros

* Most optimal solution
* Uses binary search efficiently

### ❌ Cons

* Needs good understanding of binary search on real values

### 💻 Code

```java
public class Optmize {
    public static int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }

    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;

        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double)(arr[i + 1] - arr[i]));
        }

        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int cnt = numberOfGasStationsRequired(mid, arr);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int arr[] = {1, 13, 17, 23};
        int k = 5;
        double ans = minimiseMaxDistance(arr, k);
        System.out.println("The answer is: " + ans);
    }
}
```

---

# 🧮 Complexity Table

| Approach  | Time Complexity     | Space Complexity | Best For |
| --------- | ------------------- | ---------------- | -------- |
| Brute     | O(K × N)            | O(N)             | Small k  |
| Better    | O(K log N)          | O(N)             | Medium k |
| Optimized | O(N log(maxDist/ε)) | O(1)             | Large k  |

---

# ✅ Summary

* Brute Force is intuitive but inefficient.
* Better (Heap-based) is greedy and more scalable.
* Optimized (Binary Search) is most efficient and preferred for larger input sizes.

Let me know if you’d like to visualize these or convert into a PDF or markdown guide!
