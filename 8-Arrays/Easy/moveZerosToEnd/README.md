

# **Move All Zeros to the End of the Array**  

---

## **Problem Description**  
The goal is to rearrange an array such that all zero elements are moved to the end while maintaining the relative order of non-zero elements.  

💡 **Real-Life Analogy**:  
Think of tidying up a messy room 🛋️—you want to move all the clutter (zeroes) to the corner while keeping everything else in its proper place.  

---

## **Example Input and Output**  

### **Example 1**  
**Input**:  
`arr = [1, 2, 0, 3, 0, 4, 5]`  
**Output**:  
`arr = [1, 2, 3, 4, 5, 0, 0]`  

### **Example 2**  
**Input**:  
`arr = [0, 0, 1, 0, 2, 3]`  
**Output**:  
`arr = [1, 2, 3, 0, 0, 0]`  

---

## **Link to Problem**  
There is no external platform for this problem. You can try solving it in your IDE! 🎯  

---

## **Approach 1: Brute Force**  

### **Explanation**  
1. Create an auxiliary list to store all non-zero elements.  
2. Traverse the array, adding each non-zero element to the list.  
3. Replace the array elements with the values from the list, filling the remaining positions with zeroes.  

---

### **Pseudo Code**  
```  
1. Initialize an empty list to store non-zero elements.  
2. Loop through the array:  
   - If the current element is non-zero, add it to the list.  
3. Traverse the array again:  
   - Place the non-zero elements at the front.  
   - Fill remaining positions with zeroes.  
```  

---

### **Dry Run**  
**Input**: `[1, 2, 0, 2, 0, 3]`  

| Step         | Array List | Array After Modification |  
|--------------|------------|--------------------------|  
| Initial      | `[]`       | `[1, 2, 0, 2, 0, 3]`    |  
| After Step 1 | `[1, 2, 2, 3]` | `[1, 2, 2, 3, 0, 0]` |  

---

### **Code**  
```java  
import java.util.ArrayList;  

public class Brute {  
    public static void move(int arr[]) {  
        int n = arr.length;  
        ArrayList<Integer> li = new ArrayList<>();  
          
        for (int i = 0; i < n; i++) {  
            if (arr[i] != 0) {  
                li.add(arr[i]);  
            }  
        }  
          
        for (int i = 0; i < n; i++) {  
            if (i < li.size()) {  
                arr[i] = li.get(i);  
            } else {  
                arr[i] = 0;  
            }  
        }  
    }  
}  
```  

---

### **Time and Space Complexity**  
- **Time Complexity**: O(N) (Two traversals of the array)  
- **Space Complexity**: O(N) (Auxiliary space for the list)  

---

## **Approach 2: Optimized (Two Pointers)**  

### **Explanation**  
1. Use two pointers to solve the problem in-place:  
   - One pointer tracks the position of the first zero.  
   - The other pointer scans for non-zero elements and swaps them with the first pointer.  
2. This avoids the need for extra space and ensures a single traversal.  

---

### **Pseudo Code**  
```  
1. Initialize a pointer to find the first zero.  
2. If no zero exists, return as the array is already organized.  
3. Loop through the array:  
   - If the current element is non-zero, swap it with the element at the zero pointer.  
   - Move the zero pointer to the next position.  
```  

---

### **Dry Run**  
**Input**: `[0, 1, 2, 0, 3, 0]`  

| Step | i | j | Array After Swap     |  
|------|---|---|----------------------|  
| Init | 0 | 0 | `[0, 1, 2, 0, 3, 0]` |  
| Swap | 1 | 0 | `[1, 0, 2, 0, 3, 0]` |  
| Swap | 2 | 1 | `[1, 2, 0, 0, 3, 0]` |  
| Swap | 4 | 2 | `[1, 2, 3, 0, 0, 0]` |  

---

### **Code**  
```java  
public class Optimize {  
    public static void move(int arr[], int n) {  
        int start = -1;  
        for (int i = 0; i < n; i++) {  
            if (arr[i] == 0) {  
                start = i;  
                break;  
            }  
        }  
          
        if (start == -1) {  
            return;  
        }  
          
        for (int i = start + 1; i < n; i++) {  
            if (arr[i] != 0) {  
                int temp = arr[start];  
                arr[start] = arr[i];  
                arr[i] = temp;  
                start++;  
            }  
        }  
    }  
}  
```  

---

### **Time and Space Complexity**  
- **Time Complexity**: O(N) (Single traversal of the array)  
- **Space Complexity**: O(1) (No additional space used)  

---

## **Key Takeaways**  
- The brute force approach is simple to implement but uses extra space.  
- The optimized approach reduces the space complexity to O(1) while maintaining efficiency.  
- Practice using two-pointer techniques for similar array manipulation problems.  

---

## **Motivational Note**  
🎉 **Amazing job on tackling this problem!** Remember, every step you take improves your problem-solving skills. Keep experimenting, and don’t hesitate to revisit concepts if needed. You’re doing great—keep it up! 🚀