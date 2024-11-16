# **Day 14: Mastering Recursion** 🎯  

Welcome to **Day 14**, where we unravel the magic of **Recursion**! 🌟 Recursion is one of the most powerful and elegant concepts in programming. It allows us to solve complex problems by breaking them into smaller, more manageable pieces. By the end of today, you’ll be a recursion pro and will have solved **16 diverse and exciting problems**!  

---

## **What You’ll Learn Today**  
1. **Understanding Recursion**: The art of solving a problem by making a function call itself.  
2. **Recursive Structure**:  
   - **Base Case**: The simplest case where the recursion stops.  
   - **Recursive Case**: The case where the function calls itself to work towards the base case.  
3. How recursion simplifies problems like **mathematics**, **searching**, **sorting**, and even **game strategies**.  
4. Tackling practical problems using recursion.  

---

## **Why Recursion is a Game-Changer?**  
Think of recursion as a series of magical Russian dolls 🪆—each doll reveals the next smaller one until you find the tiniest doll (the base case). Once you find it, you start putting the dolls back together (returning results). It’s elegant, powerful, and simplifies problems that are otherwise hard to visualize!  

---

## **Folder Structure for Day 14**  

Each problem is organized into its folder. Follow the sequence step-by-step to master recursion!  

### **1. 1-printDecNum**  
**Problem**: Print numbers from `n` to `1` using recursion.  
**Example**:  
Input: `n = 5`  
Output: `5, 4, 3, 2, 1`  
Here, the recursive call reduces `n` until it reaches `1` (base case).  

---

### **2. 2-printIncNum**  
**Problem**: Print numbers from `1` to `n` using recursion.  
**Example**:  
Input: `n = 5`  
Output: `1, 2, 3, 4, 5`  
This is the reverse of the previous problem. The recursive call starts from `1` and works its way up.  

---

### **3. 3-factorial**  
**Problem**: Calculate the factorial of a number.  
**Example**:  
Input: `n = 4`  
Output: `24` (since 4! = 4 × 3 × 2 × 1)  
This problem demonstrates how recursion simplifies repeated multiplications.  

---

### **4. 4-sumOfNum**  
**Problem**: Find the sum of the first `n` natural numbers.  
**Example**:  
Input: `n = 4`  
Output: `10` (since 4 + 3 + 2 + 1 = 10)  
Recursive calls help break the summation into smaller parts until `n = 1`.  

---

### **5. 5-fibnocci**  
**Problem**: Find the nth Fibonacci number using recursion.  
**Example**:  
Input: `n = 6`  
Output: `8` (Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8...)  
This classic recursion problem demonstrates overlapping subproblems (a key concept in dynamic programming).  

---

### **6. 6-checkSortedArray**  
**Problem**: Check if an array is sorted in ascending order.  
**Example**:  
Input: `{1, 2, 3, 4}`  
Output: `true`  
This problem simplifies by comparing two adjacent elements and moving through the array recursively.  

---

### **7. 7-firstOccurence**  
**Problem**: Find the first occurrence of a target element in an array.  
**Example**:  
Input: `{1, 2, 3, 4, 3}, target = 3`  
Output: `2` (index starts from 0)  

---

### **8. 8-lastOccurence**  
**Problem**: Find the last occurrence of a target element in an array.  
**Example**:  
Input: `{1, 2, 3, 4, 3}, target = 3`  
Output: `4`  

---

### **9. 9-pow**  
**Problem**: Calculate `x` raised to the power of `n` using recursion.  
**Example**:  
Input: `x = 2, n = 3`  
Output: `8` (since \(2^3 = 8\))  

---

### **10. 10-tiling**  
**Problem**: Solve the tiling problem for a 2xN board.  
**Example**:  
Input: `n = 3`  
Output: `3` (ways to tile the board)  
This problem uses recursion to explore the two choices for tiling: vertical or horizontal placement.  

---

### **11. 11-removeDuplicateString**  
**Problem**: Remove duplicate characters from a string.  
**Example**:  
Input: `"aabbcc"`  
Output: `"abc"`  

---

### **12. 12-friendsPairing**  
**Problem**: Solve the friends pairing problem using recursion.  
**Example**:  
Input: `n = 3`  
Output: `4` (ways to pair or keep friends single)  

---

### **13. 13-binaryString**  
**Problem**: Generate all binary strings of length `n`.  
**Example**:  
Input: `n = 3`  
Output: `000, 001, 010, 011, 100, 101, 110, 111`  

---

### **14. 14-Indices**  
**Problem**: Find all indices of an element in an array.  
**Example**:  
Input: `{1, 2, 3, 3, 4}, target = 3`  
Output: `[2, 3]`  

---

### **15. 15-findSubstring**  
**Problem**: Count palindromic substrings in a string.  
**Example**:  
Input: `"zz"`  
Output: `3` (substrings: `"z", "z", "zz"`)  

---

### **16. 16-THO**  
**Problem**: Solve **Tower of Hanoi** or **Tree Height Optimization** (depending on context).  
**Example**:  
Tower of Hanoi for 3 disks:  
Move disk 1 from A to C, Move disk 2 from A to B, Move disk 1 from C to B...  

---

## **How to Use This Repository**  
1. Start from **1-printDecNum** and progress sequentially.  
2. Each folder contains:  
   - **README.md**: A detailed explanation of the problem and solution.  
   - **Code file**: The Java implementation for the solution.  

---

## **Pro Tips for Mastering Recursion**  
1. **Visualize**: Use pen and paper to trace the recursive calls.  
2. **Understand Base Cases**: Without a proper base case, recursion won’t stop and will result in stack overflow.  
3. **Debug Step-by-Step**: Use print statements or a debugger to track recursive calls.  
4. **Practice**: Solve problems with varying difficulty levels to build confidence.  

---

### **Let’s Begin the Adventure! 🚀**  
Click into **1-printDecNum** and start mastering recursion! By the end of Day 14, you’ll be a recursion wizard 🧙‍♂️. Happy coding! 😊