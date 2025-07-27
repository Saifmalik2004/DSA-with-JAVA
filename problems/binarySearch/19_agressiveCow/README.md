# 🐄 Aggressive Cows Problem

## 📌 Problem Statement
You are given an array `stalls[]` representing the positions of stalls in a linear field. Your task is to place `k` cows in these stalls such that the minimum distance between any two cows is maximized.

### 🔹 Constraints:
- The number of stalls `n` is at least `2`.
- `k` (number of cows) is always less than or equal to `n`.

## 🔢 Example
### Input:
```java
stalls = [0, 3, 4, 7, 10, 9]
k = 4
```
### Output:
```
3
```
### Explanation:
The best way to place 4 cows while maximizing the minimum distance is at positions `[0, 3, 7, 10]`.

## 💡 Intuition
The key to solving this problem is realizing that:
1. Sorting the `stalls` array helps in placing cows optimally.
2. The problem boils down to finding the **maximum possible minimum distance** between any two cows.
3. This is a **search problem**, and we can apply **Binary Search** to optimize it.

## 🛠 Approach
1. **Sort the stalls** - This helps in deciding the placement order.
2. **Define the search space**:
   - The minimum possible distance between two cows is `1`.
   - The maximum possible distance is `stalls[n-1] - stalls[0]`.
3. **Binary Search on the answer**:
   - Take `mid` as the current candidate for minimum distance.
   - Check if it's possible to place `k` cows with at least `mid` distance.
   - If possible, increase `mid` to find a larger valid distance.
   - Otherwise, decrease `mid`.
4. **Greedy placement of cows**:
   - Place the first cow at `stalls[0]`.
   - Iterate through the stalls and place the next cow only if the distance from the last placed cow is at least `mid`.
   - If we can place all `k` cows successfully, return `true`.

## 🔤 Algorithm (Pseudo Code)
```
1. Sort the stalls array.
2. Set low = 1, high = (stalls[n-1] - stalls[0]).
3. While (low <= high):
     a. mid = (low + high) / 2
     b. If cows can be placed with at least `mid` distance:
          - Store `mid` as a possible answer
          - Increase `low = mid + 1`
     c. Else:
          - Reduce `high = mid - 1`
4. Return the maximum stored answer.
```

## 🔍 Code Explanation Walkthrough
```java
import java.util.Arrays;

public class Optimize {
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);  // Step 1: Sort the stalls
        int low = 1, high = stalls[n - 1] - stalls[0];
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (possibleToPlace(stalls, k, mid)) { // Step 2: Binary search
                ans = mid;
                low = mid + 1;  // Try for a larger minimum distance
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static boolean possibleToPlace(int[] stalls, int k, int dis) {
        int cows = 1;
        int lastPlace = stalls[0];
        for (int i = 1; i < stalls.length; i++) {  // Step 3: Greedy placement
            if (stalls[i] - lastPlace >= dis) {
                cows++;
                lastPlace = stalls[i];
            }
            if (cows == k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {0, 3, 4, 7, 10, 9};
        System.out.println(aggressiveCows(arr, 4)); // Expected output: 3
    }
}
```

## ⏳ Time Complexity Analysis
- **Sorting stalls**: `O(n log n)`
- **Binary Search**: `O(log (max-min))`
- **Checking Placement**: `O(n)` (Greedy approach in `possibleToPlace` function)
- **Total Complexity**: `O(n log n) + O(n log d)` ≈ `O(n log n)`

## 📦 Space Complexity Analysis
- Only a few extra variables are used → **O(1)**.
- The sorting is done in-place.

## 🔥 Key Features
✅ Uses **Binary Search on Answer** to optimize search space.
✅ Greedy placement ensures **efficient cow distribution**.
✅ **Sorting helps** in making valid cow placements easier.
✅ **Logarithmic complexity** makes it efficient for large inputs.

## 💡 Tips
💡 If `k == n`, the answer is `stalls[n-1] - stalls[0]` (Max possible distance).  
💡 Always sort before applying binary search on an answer.  
💡 Try dry-running on different stall arrangements to understand the placement.

## 🎯 Conclusion
This problem is a great example of applying **Binary Search on the Answer** to solve optimization problems efficiently. The combination of **sorting**, **binary search**, and **greedy placement** makes this approach both intuitive and performant.

Hope you found this explanation helpful! 🚀🐄

