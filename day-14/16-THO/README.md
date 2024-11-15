# README: Solving the Tower of Hanoi Mystery 🏗️🧠

Welcome to the fascinating world of **Tower of Hanoi**, where logic, recursion, and strategy join forces! This program demonstrates how to solve the **Tower of Hanoi puzzle** while keeping track of the total moves made.

---

## **What is the Tower of Hanoi?**

The Tower of Hanoi is a classic problem that involves moving **disks** from one rod (source) to another (destination), following these rules:

1. **Only one disk can be moved at a time.**
2. **A larger disk cannot be placed on top of a smaller disk.**
3. **There is an auxiliary rod that can be used for temporary storage.**

The goal is to move all disks from the **source rod** to the **destination rod** while adhering to these rules.

---

## **The Program's Logic**

The solution is implemented using recursion, where the problem is divided into smaller subproblems. Here's the breakdown of the steps:

### **How It Works**:

1. **Base Case**:
   - If there are no disks (`disk == 0`), no moves are required, and the function simply returns.

2. **Recursive Steps**:
   - **Step 1**: Move all disks except the largest from the source rod to the auxiliary rod.
   - **Step 2**: Move the largest disk directly to the destination rod.
   - **Step 3**: Move the disks from the auxiliary rod to the destination rod.

3. **Move Counter**:
   - The program keeps track of every move made during the process by incrementing a `moveCount` variable.

---

### **Key Highlights**

- **Recursive Function**: The `Honoi` function takes the number of disks and rod identifiers (`src`, `using`, `dest`) along with a `moveCount` to track the number of moves.
- **Dynamic Execution**: The function adjusts the moves and rods dynamically for each recursive call.

---

### Dry Run for Tower of Hanoi with 4 Disks 🏗️

#### **Initial Setup**:
- **Source rod (src)**: 1  
- **Auxiliary rod (using)**: 2  
- **Destination rod (dest)**: 3  
- **Number of disks (disk)**: 4  
- **Move count starts at**: 0  

We will recursively break the problem into smaller subproblems and solve it step-by-step. Let's trace the execution!

---

### **Recursive Calls Breakdown**

#### Step 1: Move 3 disks from rod 1 to rod 2 (using rod 3)
- **Recursive call**: `Honoi(3, 1, 3, 2)`

---

#### Step 1.1: Move 2 disks from rod 1 to rod 3 (using rod 2)
- **Recursive call**: `Honoi(2, 1, 2, 3)`

---

#### Step 1.1.1: Move 1 disk from rod 1 to rod 2 (using rod 3)
- **Recursive call**: `Honoi(1, 1, 3, 2)`
  - **Base case**: Move disk 1 from rod 1 to rod 2.
  - **Move count**: 1

---

#### Step 1.1.2: Move disk 2 from rod 1 to rod 3
- **Move count**: 2

---

#### Step 1.1.3: Move 1 disk from rod 2 to rod 3 (using rod 1)
- **Recursive call**: `Honoi(1, 2, 1, 3)`
  - **Base case**: Move disk 1 from rod 2 to rod 3.
  - **Move count**: 3

---

#### Step 1.2: Move disk 3 from rod 1 to rod 2
- **Move count**: 4

---

#### Step 1.3: Move 2 disks from rod 3 to rod 2 (using rod 1)
- **Recursive call**: `Honoi(2, 3, 1, 2)`

---

#### Step 1.3.1: Move 1 disk from rod 3 to rod 1 (using rod 2)
- **Recursive call**: `Honoi(1, 3, 2, 1)`
  - **Base case**: Move disk 1 from rod 3 to rod 1.
  - **Move count**: 5

---

#### Step 1.3.2: Move disk 2 from rod 3 to rod 2
- **Move count**: 6

---

#### Step 1.3.3: Move 1 disk from rod 1 to rod 2 (using rod 3)
- **Recursive call**: `Honoi(1, 1, 3, 2)`
  - **Base case**: Move disk 1 from rod 1 to rod 2.
  - **Move count**: 7

---

### **Step 2: Move disk 4 from rod 1 to rod 3**
- **Move count**: 8

---

### **Step 3: Move 3 disks from rod 2 to rod 3 (using rod 1)**
- **Recursive call**: `Honoi(3, 2, 1, 3)`

---

#### Step 3.1: Move 2 disks from rod 2 to rod 1 (using rod 3)
- **Recursive call**: `Honoi(2, 2, 3, 1)`

---

#### Step 3.1.1: Move 1 disk from rod 2 to rod 3 (using rod 1)
- **Recursive call**: `Honoi(1, 2, 1, 3)`
  - **Base case**: Move disk 1 from rod 2 to rod 3.
  - **Move count**: 9

---

#### Step 3.1.2: Move disk 2 from rod 2 to rod 1
- **Move count**: 10

---

#### Step 3.1.3: Move 1 disk from rod 3 to rod 1 (using rod 2)
- **Recursive call**: `Honoi(1, 3, 2, 1)`
  - **Base case**: Move disk 1 from rod 3 to rod 1.
  - **Move count**: 11

---

#### Step 3.2: Move disk 3 from rod 2 to rod 3
- **Move count**: 12

---

#### Step 3.3: Move 2 disks from rod 1 to rod 3 (using rod 2)
- **Recursive call**: `Honoi(2, 1, 2, 3)`

---

#### Step 3.3.1: Move 1 disk from rod 1 to rod 2 (using rod 3)
- **Recursive call**: `Honoi(1, 1, 3, 2)`
  - **Base case**: Move disk 1 from rod 1 to rod 2.
  - **Move count**: 13

---

#### Step 3.3.2: Move disk 2 from rod 1 to rod 3
- **Move count**: 14

---

#### Step 3.3.3: Move 1 disk from rod 2 to rod 3 (using rod 1)
- **Recursive call**: `Honoi(1, 2, 1, 3)`
  - **Base case**: Move disk 1 from rod 2 to rod 3.
  - **Move count**: 15

---

### **Final Output**

After all recursive calls and moves are completed:

- **Total moves**: 15  
- **Output on Console**:
```plaintext
Move 1 disc from 1 to 2
Move 2 disc from 1 to 3
Move 1 disc from 2 to 3
Move 3 disc from 1 to 2
Move 1 disc from 3 to 1
Move 2 disc from 3 to 2
Move 1 disc from 1 to 2
Move 4 disc from 1 to 3
Move 1 disc from 2 to 3
Move 2 disc from 2 to 1
Move 1 disc from 3 to 1
Move 3 disc from 2 to 3
Move 1 disc from 1 to 2
Move 2 disc from 1 to 3
Move 1 disc from 2 to 3
Total moves: 15
```

### **How Many Moves Does It Take?**
For `n` disks, the minimum number of moves required is:
\[
2^n - 1
\]

For 5 disks:
\[
2^5 - 1 = 31 \, \text{moves}
\]

---

## **Why Is This Program Cool?** 😎

- **Efficient Solution**: The recursive approach breaks down a complex problem into manageable steps.
- **Move Tracking**: Keeping count of moves helps us understand the efficiency of the solution.
- **Visual Clarity**: Each move is printed to the console, making it easier to follow the solution.

---

## **Try It Out!**

Change the number of disks in the `main` method and see the magic unfold. How many moves does it take for your configuration? 🧩