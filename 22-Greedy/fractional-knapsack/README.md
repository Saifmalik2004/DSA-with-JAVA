# Fractional Knapsack Problem – Greedy Algorithm

---

## 1️⃣ **Problem Description**  

Imagine you’re a treasure hunter! You stumble upon a cave full of gold, diamonds, and silver. 🎉 But here’s the catch — your bag can only carry a limited weight! 😱 Now, you must pick the most valuable items that fit in your bag to maximize your profit.

In this **Fractional Knapsack Problem**:

- **Input:**
  - A list of values (e.g., `val = [60, 100, 120]`), each representing the worth of an item. 💰
  - A list of weights (e.g., `weight = [10, 20, 30]`), each representing the weight of the corresponding item. ⚖️
  - The maximum weight capacity your bag can carry (e.g., `w = 50`). 🎒

- **Output:**
  - The maximum total value you can carry (e.g., `final value = 240`).

---

## 2️⃣ **Step-by-Step Explanation of the Code**  

Here’s how the solution works step by step:

### Step 1: Calculate Value-to-Weight Ratio
We compute how valuable each item is per unit of weight. This is done using the formula:

```java
val[i] / (double) weight[i]
```
This ratio helps us prioritize items with higher value per weight. 🧮

### Step 2: Sort Items by Ratio
We sort the items in descending order of their value-to-weight ratio. The higher the ratio, the more attractive the item! 🔀

### Step 3: Fill the Knapsack
We pick items based on their sorted ratios:
- If the current item’s weight fits in the remaining bag capacity, take it entirely.
- If not, take a fraction of it to fill the bag.

We keep track of the total value as we add items. 💼

---

## 3️⃣ **Example Walkthrough**  

### Inputs:
- **Values:** `[60, 100, 120]`
- **Weights:** `[10, 20, 30]`
- **Capacity:** `50`

### Step-by-Step Execution:

1. **Calculate Ratios:**
   - Item 1: `60 / 10 = 6.0`
   - Item 2: `100 / 20 = 5.0`
   - Item 3: `120 / 30 = 4.0`

2. **Sort by Ratios:**
   - Sorted Order: Item 1, Item 2, Item 3

3. **Fill Knapsack:**
   - Add Item 1 (10 weight, 60 value): Remaining capacity = `40`
   - Add Item 2 (20 weight, 100 value): Remaining capacity = `20`
   - Add fraction of Item 3: `(20/30) * 120 = 80`

### Final Value: `60 + 100 + 80 = 240`

---

## 4️⃣ **Approach**  

This solution uses a **Greedy Algorithm** approach:
- Prioritize items with the highest value-to-weight ratio.
- Always make the locally optimal choice to maximize value.

Why is this efficient? 💡
- Sorting helps us quickly decide the best items to pick.
- Fractional selection ensures we utilize the bag’s full capacity.

---

## 5️⃣ **Pseudo Code**  

```plaintext
1. Create an array of (index, value-to-weight ratio) pairs.
2. Sort the array in descending order of the ratio.
3. Initialize totalValue = 0 and remainingCapacity = w.
4. For each item in sorted array:
   a. If the item's weight fits:
      - Add its value to totalValue.
      - Subtract its weight from remainingCapacity.
   b. Else:
      - Add a fraction of its value proportional to the remaining capacity.
      - Break the loop.
5. Return totalValue.
```

---

## 6️⃣ **Full Code with Comments**  

```java
import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    public static void main(String[] args) {
        // Values and weights of items
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};

        // Maximum capacity of the knapsack
        int w = 50;

        // Array to store item index and value-to-weight ratio
        double ratio[][] = new double[val.length][2];

        // Calculate the ratio for each item
        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i; // Store the index of the item
            ratio[i][1] = val[i] / (double) weight[i]; // Calculate the ratio
        }

        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w; // Remaining capacity of the knapsack
        int finalVal = 0; // Total value of items in the knapsack

        // Fill the knapsack
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0]; // Get the original index of the item
            if (capacity >= weight[idx]) {
                // If the item fits, take it entirely
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                // If the item doesn't fit, take a fraction of it
                finalVal += (ratio[i][1] * capacity);
                break; // Knapsack is full
            }
        }

        // Print the final total value
        System.out.println("Final value = " + finalVal);
    }
}
```

---

## 7️⃣ **Complexity Analysis**  

### Time Complexity:
1. Calculating ratios: `O(n)`
2. Sorting ratios: `O(n log n)`
3. Filling the knapsack: `O(n)`

**Total:** `O(n log n)`

### Space Complexity:
- The space used for the `ratio` array is `O(n)`.

---

## 8️⃣ **Key Takeaways**  

- **Greedy Algorithms**: They work well for optimization problems like this, where making local choices leads to a globally optimal solution. 🌟
- **Fractional Selection**: Allows you to maximize value even when the full weight of an item doesn’t fit. 🧠
- **Sorting**: Sorting based on key criteria can simplify problem-solving. 🔑

Keep practicing, and remember — every problem you solve makes you a better coder! 🚀💻

