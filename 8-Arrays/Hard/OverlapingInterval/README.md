# 🚀 Merging Overlapping Intervals - A Complete Guide

## **Problem Statement 🎯**
Given a set of intervals, merge all overlapping intervals and return a list of non-overlapping intervals that cover all the input intervals.

## **Example Input & Output 🔍**
### **Example 1:**
**Input:** `[[1,3], [2,6], [8,10], [15,18]]`

**Output:** `[[1,6], [8,10], [15,18]]`

### **Example 2:**
**Input:** `[[1,4], [4,5]]`

**Output:** `[[1,5]]`

---

## **Brute Force Approach 🛠️**

### **Explanation:**
1. First, sort the intervals based on the starting time.
2. Iterate through the sorted intervals and check for overlaps.
3. If intervals overlap, merge them by updating the end time.
4. Add merged intervals to the result list.

### **Pseudocode:**
```java
Sort intervals based on start time
Initialize result list
For each interval in intervals:
    If the result is empty OR current interval does not overlap with last result interval:
        Add current interval to result
    Else:
        Merge intervals by updating end time
Return result list
```

### **Dry Run Example:**
| Step | Intervals Processed | Merged Intervals |
|------|---------------------|-----------------|
| 1    | `[1,3]`             | `[[1,3]]`       |
| 2    | `[2,6]`             | `[[1,6]]`       |
| 3    | `[8,10]`            | `[[1,6], [8,10]]` |
| 4    | `[15,18]`           | `[[1,6], [8,10], [15,18]]` |

### **Brute Force Code Implementation:**
```java
import java.util.*;
public class Brute {
    public static List<List<Integer>> overlapInterval(int arr[][]) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j][0] <= end) end = Math.max(end, arr[j][1]);
                else break;
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println(overlapInterval(arr));
    }
}
```

### **Complexity Analysis:**
- **Time Complexity:** `O(N^2)` (due to nested loop for merging)
- **Space Complexity:** `O(N)` (for storing merged intervals)

---

## **Optimized Approach 🚀**
### **Explanation:**
1. Sort intervals by start time.
2. Use a result list to track merged intervals.
3. If an interval overlaps with the last added interval, merge them.
4. Otherwise, add it as a new interval.

### **Pseudocode:**
```java
Sort intervals by start time
Initialize result list
For each interval:
    If no overlap with last interval in result:
        Add to result
    Else:
        Merge intervals
Return result
```

### **Optimized Code Implementation:**
```java
import java.util.*;
public class Optimize {
    public static List<List<Integer>> overlapInterval(int arr[][]) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                ans.get(ans.size() - 1).set(1, Math.max(arr[i][1], ans.get(ans.size() - 1).get(1)));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println(overlapInterval(arr));
    }
}
```

### **Complexity Analysis:**
- **Time Complexity:** `O(N log N)`, dominated by sorting.
- **Space Complexity:** `O(N)` (for storing merged intervals)

---

## **Comparison Table 📊**
| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| Brute Force | `O(N^2)` | `O(N)` |
| Optimized | `O(N log N)` | `O(N)` |

---

## **Real-World Applications 🌍**
1. **Scheduling Systems:** Merging overlapping meeting times.
2. **Event Planning:** Handling time slots for events.
3. **Memory Allocation:** Managing overlapping memory blocks.

---

## **Key Takeaways 🎯**
✔ Sorting helps simplify interval-based problems.
✔ Merging can be optimized using a result list.
✔ Avoid unnecessary iterations for efficiency.

---

## **Hands-on Practice 📂**
📌 [Check the hands-on practice files here](./practice/)

