
# 🚀 **Greedy Algorithm: Minimum Cost of Cutting Chocolate** 🍫  

Welcome to the fascinating world of greedy algorithms! In this problem, we'll explore how to minimize the cost of cutting a chocolate bar into smaller pieces. Let’s dive in! 🌊  

---

## 1️⃣ **Problem Description**  

Imagine you have a giant chocolate bar 🍫, and you want to break it down into smaller squares.  

- Each vertical cut (`costVer`) and horizontal cut (`costHor`) has a cost associated with it.  
- The goal is to minimize the total cost of breaking the chocolate into pieces.  
- Sounds simple, right? But it involves some smart choices to keep the costs low. Let’s crack it! ✨  

---

## 2️⃣ **Step-by-Step Explanation of the Code**  

### **Sorting the Costs**  
```java  
Arrays.sort(costVer,Collections.reverseOrder());  
Arrays.sort(costHor,Collections.reverseOrder());
```  
First, we sort the cutting costs in descending order. Why? To always prioritize the most expensive cut first for minimizing total cost. Greedy, isn't it? 😉  

### **Initialization**  
```java  
int h =0, v=0;  
int hp=1, vp=1;  
int cost=0;
```  
Here:  
- `h` and `v` track which cut we're processing in `costHor` and `costVer`.  
- `hp` and `vp` are the current number of horizontal and vertical pieces.  
- `cost` accumulates the total cost.  

### **Main Greedy Logic**  
```java  
while(v < costVer.length && h < costHor.length){
    if(costVer[v] <= costHor[h]){
        cost += costHor[h]* vp;
        hp++;
        h++;
    }else{
        cost += costVer[v]* hp;
        vp++;
        v++;
    }
}
```  
We compare the most expensive vertical (`costVer[v]`) and horizontal (`costHor[h]`) cuts.  

- If horizontal cut is more expensive, we take it first. The cost is multiplied by `vp` (the number of vertical pieces it will affect).  
- Otherwise, we take the vertical cut.  

We continue this until one of the lists is exhausted.  

### **Handle Remaining Cuts**  
```java  
while(h<costHor.length){
    cost += costHor[h]* vp;
    hp++;
    h++;
}
while(v<costVer.length){
    cost += costVer[v]* hp;
    vp++;
    v++;
}
```  
When one list runs out, we handle the remaining cuts in the other list.  

### **Print the Result**  
```java  
System.out.println("Min cost is = "+ cost);
```  
Finally, we print the minimum cost! 🎉  

---

## 3️⃣ **Example Walkthrough**  

Let’s break it down with an example:  

**Input:**  
- `costVer = {2, 1, 3, 1, 4}`  
- `costHor = {4, 1, 2}`  

**Steps:**  
1. Sort costs:  
   - `costVer = {4, 3, 2, 1, 1}`  
   - `costHor = {4, 2, 1}`  
2. Start with `cost = 0`, `hp = 1`, `vp = 1`.  
3. First cut: Horizontal (4 × 1), add 4 to `cost`. Now `hp = 2`.  
4. Second cut: Vertical (4 × 2), add 8 to `cost`. Now `vp = 2`.  
5. Continue cutting...  
6. Final `cost = 42`.  

---

## 4️⃣ **Approach**  

This greedy approach ensures we always take the most expensive cut available, multiplying it by the number of pieces it will affect. This minimizes the cost of future cuts! 🧠  

---

## 5️⃣ **Pseudo Code**  

```plaintext  
1. Sort costVer and costHor in descending order.  
2. Initialize cost = 0, hp = 1, vp = 1.  
3. While both arrays are not exhausted:  
   a. Compare current horizontal and vertical costs.  
   b. Take the larger cost, update cost, and increment hp or vp.  
4. Handle remaining cuts in either array.  
5. Print total cost.  
```  

---

## 6️⃣ **Full Code with Comments**  

```java  
import java.util.Arrays;  
import java.util.Collections;  

public class Greedy {  
    public static void main(String[] args) {  
        // Costs of vertical and horizontal cuts  
        Integer costVer[] = {2, 1, 3, 1, 4};  
        Integer costHor[] = {4, 1, 2};  

        // Sort in descending order for greedy approach  
        Arrays.sort(costVer, Collections.reverseOrder());  
        Arrays.sort(costHor, Collections.reverseOrder());  

        // Initialize variables  
        int h = 0, v = 0;  
        int hp = 1, vp = 1;  
        int cost = 0;  

        // Greedy logic for cutting  
        while (v < costVer.length && h < costHor.length) {  
            if (costVer[v] <= costHor[h]) {  
                cost += costHor[h] * vp;  
                hp++;  
                h++;  
            } else {  
                cost += costVer[v] * hp;  
                vp++;  
                v++;  
            }  
        }  

        // Handle remaining horizontal cuts  
        while (h < costHor.length) {  
            cost += costHor[h] * vp;  
            hp++;  
            h++;  
        }  

        // Handle remaining vertical cuts  
        while (v < costVer.length) {  
            cost += costVer[v] * hp;  
            vp++;  
            v++;  
        }  

        // Print final cost  
        System.out.println("Min cost is = " + cost);  
    }  
}  
```  

---

## 7️⃣ **Complexity Analysis**  

- **Time Complexity:**  
  - Sorting: `O(n log n)` for `costVer` and `costHor`.  
  - Greedy loop: `O(n + m)` where `n` and `m` are lengths of `costVer` and `costHor`.  
  - **Overall:** `O(max(n, m) log(max(n, m)))`.  

- **Space Complexity:** `O(1)` (no extra space used).  

---

## 8️⃣ **Key Takeaways**  

- Greedy algorithms are all about making the optimal choice at each step! 🧩  
- Sorting helps us prioritize the most significant costs first.  
- Breaking problems into smaller steps makes them manageable.  

Keep coding, keep learning, and remember—you’re one step closer to mastering algorithms! 🚀✨  

---