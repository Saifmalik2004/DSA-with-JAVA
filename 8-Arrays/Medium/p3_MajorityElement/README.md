# Majority Element in an Array

## Problem Statement
Given an array of integers, find the majority element. A majority element is an element that appears more than `n/2` times in the array (where `n` is the size of the array). If no such element exists, return `-1`.

### Example
#### Input:
```
arr = [2, 3, 3, 1, 1, 1, 1]
```
#### Output:
```
1
```

## Approach 1: Using HashMap (Better Approach)
This approach uses a HashMap to store the frequency of each element and checks if any element appears more than `n/2` times.

### Algorithm
1. Create a HashMap to store the frequency of each element.
2. Traverse the array and update the frequency count.
3. Iterate through the HashMap to check if any element appears more than `n/2` times.
4. If found, print the element; otherwise, return `-1`.

### Code Implementation
```java
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Better {
    public static void majorityElement(int arr[]) {
        Map<Integer, Integer> countFreq = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            countFreq.put(arr[i], countFreq.getOrDefault(arr[i], 0) + 1);
        }
        
        for (Entry<Integer, Integer> elem : countFreq.entrySet()) {
            if (elem.getValue() > arr.length / 2) {
                System.out.println(elem.getKey());
                return;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 1, 1, 1, 1};
        majorityElement(arr);
    }
}
```

### Complexity Analysis
- **Time Complexity:** `O(n)`, as we traverse the array once and iterate through the HashMap.
- **Space Complexity:** `O(n)`, due to storing elements in the HashMap.

---

## Approach 2: Boyer-Moore Voting Algorithm (Optimized Approach)
This approach finds the majority element in `O(n)` time with `O(1)` space using a two-pass method:
1. **Candidate Selection:** Iterate through the array and determine a potential majority element.
2. **Verification:** Count occurrences of the selected candidate to confirm if it is indeed a majority element.

### Algorithm
1. Initialize `elem` as a candidate for the majority element and `count` as 0.
2. Traverse the array:
   - If `count` is `0`, update `elem` to the current element and reset `count` to `1`.
   - If `elem` matches the current element, increment `count`.
   - Otherwise, decrement `count`.
3. Verify if `elem` is actually a majority element by counting its occurrences.
4. If it appears more than `n/2` times, return it; otherwise, return `-1`.

### Code Implementation
```java
public class Optimize {
    public static int majorityElement(int[] nums) {
        int elem = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                elem = nums[i];
                count = 1;
            } else if (nums[i] == elem) {
                count++;
            } else {
                count--;
            }
        }
        
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == elem) {
                count++;
            }
        }
        
        return (count > nums.length / 2) ? elem : -1;
    }
    
    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 1, 1, 1, 1};
        System.out.println(majorityElement(arr));
    }
}
```

### Complexity Analysis
- **Time Complexity:** `O(n)`, as we iterate over the array twice.
- **Space Complexity:** `O(1)`, since we only use a few variables.

## Summary
| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| HashMap  | O(n)           | O(n)             |
| Boyer-Moore | O(n)        | O(1)             |

The Boyer-Moore Voting Algorithm is more efficient in terms of space, making it the preferred approach for large datasets.

---

Let me know if you need any modifications! 🚀

