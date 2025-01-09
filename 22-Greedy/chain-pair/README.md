

# Chains Pair Problem ⛓️

## **1️⃣ Problem Description**
You are given an array of `n` pairs, where each pair consists of two integers, \( (a, b) \). These pairs can be thought of as links in a chain. Your task is to find the longest chain that can be formed by connecting these pairs, where a pair \( (a, b) \) can connect to another pair \( (c, d) \) **only if** \( b < c \).

The goal is to maximize the number of pairs in the chain while following the connection rule. In simpler terms, you need to organize the pairs to form the longest possible sequence.

---

### **Understanding the Problem with an Example**

Imagine you have the following pairs:  
\[ (1, 2), (3, 4), (2, 3), (5, 6) \]  

Here’s how we can visualize the problem:
1. Pair \( (1, 2) \) ends at 2. It can connect to \( (3, 4) \) because \( 2 < 3 \).
2. Pair \( (2, 3) \) also ends at 3. However, \( (2, 3) \) cannot connect to \( (3, 4) \), because their intervals overlap.
3. Pair \( (5, 6) \) can follow \( (3, 4) \), forming the longest chain:  
\[ (1, 2) → (3, 4) → (5, 6) \].  

The length of this chain is `3`.

---

### **Rules and Constraints**

1. **Order and Overlap:**
   - For two pairs \( (a, b) \) and \( (c, d) \), \( b \) (the end of the first pair) must be less than \( c \) (the start of the next pair) to form a valid connection.

2. **No Rearranging Pairs:**
   - You are allowed to sort the pairs for optimal chaining but cannot modify the individual values of any pair.

3. **Maximizing the Chain Length:**
   - The objective is to include as many pairs as possible in the chain.

4. **Input Format:**
   - The array contains `n` pairs of integers: \( (a_1, b_1), (a_2, b_2), \dots, (a_n, b_n) \).
   - \( a_i < b_i \) for all \( i \) (each pair is valid).

5. **Output Format:**
   - Return the length of the longest chain that can be formed by connecting the pairs.

---

### **Real-Life Analogy**
Think of these pairs as tasks you need to schedule during a day. Each task \( (a, b) \) represents a time interval where:
- \( a \) is the start time.
- \( b \) is the end time.

Your goal is to schedule the maximum number of tasks without overlapping intervals. Just like the pair-chaining rule \( b < c \), tasks cannot overlap and must follow one another in sequence.

---

### **Challenges in Solving the Problem**

The problem boils down to efficiently finding the optimal order of pairs to form the longest chain. However:
1. Sorting the pairs by the wrong criterion (e.g., by the start of each pair instead of the end) can lead to suboptimal results.
2. Brute-force approaches, where all possible pair combinations are tested, can quickly become inefficient as the number of pairs grows.

Thus, an efficient algorithm is needed to solve this problem within a reasonable time frame.

---

## **Example**

### **Input:**
Pairs: \[ (5, 24), (15, 25), (27, 40), (50, 60) \]

### **Steps to Solve:**
1. **Sort the Pairs:**  
   - To simplify the chaining process, sort the pairs by their ending values \( b \):  
     Sorted pairs: \[ (5, 24), (15, 25), (27, 40), (50, 60) \].

2. **Find the Longest Chain:**  
   - Start with the first pair \( (5, 24) \) in the sorted list.
   - Check if the next pair’s start value \( a \) is greater than the current pair’s end value \( b \).
   - Chain the pairs as follows:
     - \( (5, 24) → (27, 40) → (50, 60) \).

### **Output:**  
The length of the longest chain is `3`.


---

## 2️⃣ **Step-by-Step Explanation of the Code** 🛠️

### Step 1: Sort the Pairs
To make the chaining process easier, we **sort the pairs by their end times**. This ensures that the pair with the earliest end time is considered first. Sorting helps in applying the **greedy approach** effectively.

```java
Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
```
Here, we use a comparator to sort based on the second value (`end time`) of each pair.

---

### Step 2: Initialize Chain Length and End Time
We start by initializing:
1. **`chainLength`**: Keeps track of the maximum number of pairs in the chain. Initially set to `1` (the first pair is always included).
2. **`chainEnd`**: Stores the end time of the last pair in the current chain. Initially set to the end time of the first pair.

```java
int chainLength = 1; // First pair is part of the chain
int chainEnd = pairs[0][1]; // End time of the first pair
```

---

### Step 3: Build the Chain
Iterate through the sorted pairs. For each pair:
- If the **start time of the current pair** is greater than or equal to the **end time of the last pair in the chain**:
  - Add this pair to the chain.
  - Update the `chainEnd` to the current pair’s end time.
  - Increment the `chainLength`.

```java
for (int i = 1; i < pairs.length; i++) {
    if (pairs[i][0] >= chainEnd) {
        chainLength++;
        chainEnd = pairs[i][1];
    }
}
```

---

### Step 4: Output the Result
Finally, print the length of the longest chain formed.

```java
System.out.println("Max Chain Length = " + chainLength);
```

---

## 3️⃣ **Example Walkthrough** 🌟

### Input:
Pairs: `[[5, 24], [39, 60], [5, 28], [27, 40], [50, 90]]`

### Step-by-Step Execution:

1. **Sort the Pairs by End Time:**
   Sorted pairs: `[[5, 24], [5, 28], [27, 40], [39, 60], [50, 90]]`

2. **Initialize:**
   - `chainLength = 1` (first pair included).
   - `chainEnd = 24` (end time of the first pair).

3. **Iterate Through the Pairs:**
   - Pair `[5, 28]`: Start time `5` < `chainEnd = 24` → Skip.
   - Pair `[27, 40]`: Start time `27` ≥ `chainEnd = 24` → Include in chain.  
     Update `chainEnd = 40`, `chainLength = 2`.
   - Pair `[39, 60]`: Start time `39` < `chainEnd = 40` → Skip.
   - Pair `[50, 90]`: Start time `50` ≥ `chainEnd = 40` → Include in chain.  
     Update `chainEnd = 90`, `chainLength = 3`.

4. **Result:**
   - Maximum Chain Length: `3`.
   - Chain: `[[5, 24], [27, 40], [50, 90]]`

---

## 4️⃣ **Approach** 💡

This solution uses the **Greedy Algorithm**:  
- By sorting the pairs by their end times, we ensure that we always choose the pair that leaves the most room for future pairs.
- This approach avoids complex backtracking, making it efficient and straightforward.

---

## 5️⃣ **Pseudo Code** 📝

```
function findMaxChainLength(pairs):
    sort pairs by end time
    chainLength = 1
    chainEnd = pairs[0].end

    for i = 1 to pairs.length:
        if pairs[i].start >= chainEnd:
            chainLength++
            chainEnd = pairs[i].end

    return chainLength
```

---

## 6️⃣ **Full Code with Comments** 🖥️💬

```java
import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    public static void main(String[] args) {
        // Input: Array of pairs
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        // Step 1: Sort pairs by end time
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // Step 2: Initialize chain length and chain end
        int chainLength = 1; // First pair is always included
        int chainEnd = pairs[0][1]; // End time of the first pair

        // Step 3: Iterate through the sorted pairs
        for (int i = 1; i < pairs.length; i++) {
            // If the current pair can be included in the chain
            if (pairs[i][0] >= chainEnd) {
                chainLength++; // Increment chain length
                chainEnd = pairs[i][1]; // Update chain end time
            }
        }

        // Step 4: Output the result
        System.out.println("Max Chain Length = " + chainLength);
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍

### Time Complexity:
1. Sorting the pairs: \(O(n \cdot \log(n))\)  
2. Iterating through the pairs: \(O(n)\)

**Overall Complexity:** \(O(n \cdot \log(n))\)

### Space Complexity:
- Sorting uses \(O(1)\) additional space for the in-place sort.

**Space Complexity:** \(O(1)\)

---

## 8️⃣ **Key Takeaways** 🚀
- Sorting by end time simplifies the problem, enabling a greedy approach.
- Greedy algorithms work best when locally optimal choices lead to a globally optimal solution.
- Always look for ways to simplify the problem before diving into more complex approaches.

Keep solving problems like this, and soon you’ll master greedy algorithms! You’re doing great! 🌟