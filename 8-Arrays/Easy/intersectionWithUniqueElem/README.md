

# **Intersection of Two Arrays**

## **Problem Statement**  
Given two arrays `nums1` and `nums2`, find their intersection. The result should contain **unique** elements that appear in both arrays.  

## **Example**  
### **Input:**  
```java
nums1 = [1, 2, 2, 3, 4]
nums2 = [2, 2, 3, 5]
```
### **Output:**  
```
[2, 3]
```

## **Intuition**  
We need to find common elements in both arrays **without duplicates**.  
- We can use a **boolean array** (`nums[1001]`) to store whether an element exists in `nums1`.  
- Then, we iterate through `nums2` and check if an element is in `nums1`.  
- If found, we add it to the result and mark it as **false** to prevent duplicates.  

## **Approach (Step-by-Step)**  
### **1. Use a Boolean Array for Fast Lookups**  
- Since the numbers range from **0 to 1000**, we use a `boolean[1001]` to store presence in `nums1`.  
- Mark `nums[num] = true` for all elements in `nums1`.  

### **2. Iterate Through `nums2`**  
- Check if `nums[num]` is `true`.  
- If yes, add `num` to the result array and set `nums[num] = false` to avoid duplicates.  

### **3. Return the Valid Portion of the Array**  
- Since the result array `ans[]` is initialized with max possible size, we use `Arrays.copyOfRange(ans, 0, index)` to return only the filled elements.  

## **Algorithm (Pseudo Code)**
```
1. Create a boolean array `nums[1001]` and an integer array `ans[]` of min size.
2. Mark all elements of `nums1` in `nums[]`.
3. Iterate through `nums2`, if element exists in `nums[]`, add to `ans[]` and mark `nums[] = false`.
4. Return only the filled portion of `ans[]`.
```

## **Code**
```java
import java.util.Arrays;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        final boolean[] nums = new boolean[1001]; // Step 1: Boolean array for quick lookup
        final int[] ans = new int[Math.min(nums1.length, nums2.length)]; // Step 2: Result array
        
        for (int num : nums1) nums[num] = true; // Step 3: Mark nums1 elements
        
        int index = 0;
        for (int num : nums2) { // Step 4: Check in nums2
            if (nums[num]) { // Step 5: If found in nums1
                ans[index++] = num; // Step 6: Add to result
                nums[num] = false; // Step 7: Avoid duplicates
            }
        }
        
        return Arrays.copyOfRange(ans, 0, index); // Step 8: Return valid part
    }
}
```

## **Code Walkthrough**
1. **Initialize Data Structures**  
   - `boolean[] nums = new boolean[1001]` → To track presence in `nums1`.  
   - `int[] ans = new int[min(nums1.length, nums2.length)]` → To store the result.  

2. **Fill Boolean Array with `nums1` Elements**  
   ```java
   for (int num : nums1) nums[num] = true;
   ```
   - This marks the presence of each element in `nums1`.  

3. **Find Intersection**  
   ```java
   for (int num : nums2) {
       if (nums[num]) {
           ans[index++] = num;
           nums[num] = false;
       }
   }
   ```
   - If `nums[num]` is `true`, it means the element exists in `nums1`, so we add it to `ans`.  
   - Then, set `nums[num] = false` to avoid duplicates.  

4. **Return the Valid Portion of `ans[]`**  
   ```java
   return Arrays.copyOfRange(ans, 0, index);
   ```
   - Trims `ans[]` to only the valid elements.  

## **Time & Space Complexity Analysis**
| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Marking `nums1` elements | **O(N)** | **O(1)** (constant size array) |
| Checking `nums2` elements | **O(M)** | **O(1)** (modifying result in-place) |
| Returning valid array part | **O(K)** | **O(K)** (final result array) |
| **Total Complexity** | **O(N + M)** | **O(K)** |

## **Key Features**
✅ **Efficient Lookup with Boolean Array** → `O(1)` lookup time.  
✅ **Avoids Duplicates** → Marks `nums[num] = false` after adding.  
✅ **Optimized Space** → Uses only a fixed-size array.  
✅ **Handles Large Inputs Well** → Works for numbers `0 - 1000` in `O(N + M)`.  

## **Tips**
- If `nums1` and `nums2` are very large but elements are small (bounded in range), this approach is optimal.  
- If numbers are unbounded, use **HashSet** instead of `boolean[]`.  
- Always trim the result array using `Arrays.copyOfRange()`.  

## **Conclusion**
This approach efficiently finds the unique intersection of two arrays using **Boolean Marking**, ensuring an **O(N + M)** time complexity while using minimal extra space. 🚀🔥  

---
