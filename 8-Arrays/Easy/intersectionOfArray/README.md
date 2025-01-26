
# 🌟 Find Array Intersection  

---

## 📝 Problem Description  
Imagine you have two lists of numbers (sorted arrays), and you want to find the common elements between them—like matching pairs in a card game! 🎴  
- Your goal is to identify all elements that exist in both arrays, preserving the order and handling duplicates carefully.  

Why does this matter?  
This problem is a great introduction to basic array operations and helps you understand two important techniques: brute force and optimization. ✨  

---

## 💡 Approach 1: Brute Force  

### Explanation  
In the brute force method, we compare each element of the first array with every element of the second array. If they match and haven't been "visited," we add the element to the result.  
- **Why it's simple**: This approach is easy to understand but might not be efficient for large arrays.  
- **When to use**: Use this approach when you want to focus on understanding the problem without worrying too much about performance.  

---

### 📝 Pseudo Code  

```plaintext  
1. Initialize an empty result list.  
2. Use a boolean array to track visited elements in the second array.  
3. For each element in the first array:  
   - Compare it with every element in the second array.  
   - If they match and the element in the second array isn't visited:  
       - Add the element to the result list.  
       - Mark the second array element as visited.  
   - Break early if the current element of the second array is greater (arrays are sorted).  
4. Return the result list.  
```  

---

### 🔍 Step-by-Step Explanation  

**Example Input**:  
`arr1 = [1, 2, 2, 3, 4]`  
`arr2 = [2, 2, 3, 5]`  

1. Compare `1` with all elements in `arr2` → No match.  
2. Compare `2` with all elements in `arr2`:  
   - Match found with `2` (at `arr2[0]`). Add `2` to result.  
   - Mark `arr2[0]` as visited.  
3. Compare the next `2` in `arr1`:  
   - Match found with `2` (at `arr2[1]`). Add `2` to result.  
   - Mark `arr2[1]` as visited.  
4. Compare `3` in `arr1`:  
   - Match found with `3` (at `arr2[2]`). Add `3` to result.  
   - Mark `arr2[2]` as visited.  
5. Compare `4` in `arr1`:  
   - No match.  

**Result**: `[2, 2, 3]`  

---

### 🧪 Dry Run  

| `arr1[i]` | `arr2[j]` | Match? | Visited Array | Result |  
|-----------|-----------|--------|---------------|--------|  
| `1`       | `2`       | No     | `[false, false, false, false]` | `[]`    |  
| `2`       | `2`       | Yes    | `[true, false, false, false]`  | `[2]`   |  
| `2`       | `2`       | Yes    | `[true, true, false, false]`   | `[2, 2]`|  
| `3`       | `3`       | Yes    | `[true, true, true, false]`    | `[2, 2, 3]`|  
| `4`       | `5`       | No     | `[true, true, true, false]`    | `[2, 2, 3]`|  

---

### ⏱️ Complexity Analysis  

- **Time Complexity**: `O(n * m)` (for every element in `arr1`, we iterate over `arr2`).  
- **Space Complexity**: `O(m)` (for the visited array).  

---

## 💡 Approach 2: Optimized Using Two Pointers  

### Explanation  
By leveraging the fact that both arrays are sorted, we can use two pointers to efficiently find the intersection.  
- **How it works**: Start with pointers at the beginning of both arrays. Compare elements, move the pointers accordingly, and collect matches.  
- **Why it's better**: Reduces the need for nested loops, making it much faster.  

---

### 📝 Pseudo Code  

```plaintext  
1. Initialize two pointers, one for each array.  
2. While neither pointer has reached the end of its array:  
   - If elements at both pointers match:  
       - Add the element to the result list.  
       - Move both pointers forward.  
   - If the element in the first array is smaller:  
       - Move the pointer of the first array forward.  
   - Else:  
       - Move the pointer of the second array forward.  
3. Return the result list.  
```  

---

### 🔍 Step-by-Step Explanation  

**Example Input**:  
`arr1 = [1, 2, 2, 3, 4]`  
`arr2 = [2, 2, 3, 5]`  

1. Compare `1` (arr1) with `2` (arr2):  
   - `1 < 2`, move pointer in `arr1`.  

2. Compare `2` (arr1) with `2` (arr2):  
   - Match found. Add `2` to result and move both pointers.  

3. Compare `2` (arr1) with `2` (arr2):  
   - Match found. Add `2` to result and move both pointers.  

4. Compare `3` (arr1) with `3` (arr2):  
   - Match found. Add `3` to result and move both pointers.  

5. Compare `4` (arr1) with `5` (arr2):  
   - `4 < 5`, move pointer in `arr1`.  

**Result**: `[2, 2, 3]`  

---

### 🧪 Dry Run  

| `arr1[i]` | `arr2[j]` | Match? | Result |  
|-----------|-----------|--------|--------|  
| `1`       | `2`       | No     | `[]`   |  
| `2`       | `2`       | Yes    | `[2]`  |  
| `2`       | `2`       | Yes    | `[2, 2]`|  
| `3`       | `3`       | Yes    | `[2, 2, 3]`|  
| `4`       | `5`       | No     | `[2, 2, 3]`|  

---

### 🖥️ Full Code with Comments  

```java  
import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.Objects;  

public class Optimize {  
    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {  
        ArrayList<Integer> ans = new ArrayList<>();  
        int i = 0;  
        int j = 0;  

        while (i < n && j < m) {  
            if (Objects.equals(arr1.get(i), arr2.get(j))) {  
                ans.add(arr1.get(i));  
                i++;  
                j++;  
            } else if (arr1.get(i) < arr2.get(j)) {  
                i++;  
            } else {  
                j++;  
            }  
        }  
        return ans;  
    }  

    public static void main(String[] args) {  
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4));  
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 2, 3, 5));  

        ArrayList<Integer> result = findArrayIntersection(arr1, arr1.size(), arr2, arr2.size());  
        System.out.println("Intersection: " + result);  
    }  
}  
```  

---

### ⏱️ Complexity Analysis  

- **Time Complexity**: `O(n + m)` (linear traversal of both arrays).  
- **Space Complexity**: `O(1)` (no extra space used).  

---

## 🌈 Key Takeaways  

- Sorting and leveraging two pointers can drastically improve efficiency.  
- Always analyze the problem constraints to choose the best approach.  

---

## 💖 Thank You and Keep Going!  

*"Great job tackling this problem! 🚀 Every challenge you overcome makes you sharper. Keep learning, keep growing—you’re doing amazing! 💪✨"*  

---