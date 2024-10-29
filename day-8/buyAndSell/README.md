

# 📈 Buy and Sell Stock Problem

## 📝 Problem Statement

You are given an array `prices` where each element represents the price of a stock on a particular day. You can make **only one transaction** — meaning you may buy **one** stock and then later sell that **one** stock. Your goal is to find the maximum profit you can achieve from this single buy-and-sell transaction. If no profit can be made, you should return `0`.

### Example
Given the array:
```java
prices = [7, 1, 5, 3, 6, 4]
```

- Here, the optimal strategy is to buy on **Day 2** (price `1`) and sell on **Day 5** (price `6`), which gives a profit of `6 - 1 = 5`.

### Constraints
- You can only buy and sell once.
- The array must contain at least two prices (prices length ≥ 2).

### Expected Output
The function should return the **maximum possible profit** from a single buy-sell operation. If it's not possible to achieve any profit, return `0`.

---

## 🔍 Approach and Explanation

To solve this problem efficiently, we want to focus on:
- **Minimizing** the buy price, which helps maximize the profit when selling at a later price.
- **Tracking** the maximum profit encountered so far while iterating through the prices.

### Approach

1. **Initialize the Variables**:
   - Set `buy` to `Integer.MAX_VALUE` initially, which will keep track of the lowest price seen so far.
   - Set `maxSell` to `0` as our starting profit, which will be updated to reflect the maximum profit we can achieve.

2. **Iterate through Each Price**:
   - For each day’s price:
     - **Update the Minimum Buy Price**: Check if the current price is lower than `buy`. If yes, update `buy` to the current price.
     - **Calculate Profit for the Day**: If `buy` is less than the current price, calculate the profit as `(current price - buy)` and update `maxSell` if this profit is greater than the current `maxSell`.

3. **Return Result**:
   - After the loop ends, `maxSell` contains the maximum profit possible with a single buy-sell transaction.

### Why This Approach?

By iterating once through the prices array and keeping track of the minimum price and maximum profit at each step, we achieve an **O(n)** time complexity. This is efficient for large inputs.

---

## 📌 Code Implementation

Here’s how this approach looks in Java:

```java
public class BuyAndSell {

    public static int buyAndSell(int[] prices) {
        int buy = Integer.MAX_VALUE; // Initialize buy to max value to find the lowest price
        int maxSell = 0;             // Variable to keep track of max profit
        int day = 0;

        while (day < prices.length) {
            if (buy < prices[day]) {
                // If today's price is greater than the lowest price so far, calculate profit
                maxSell = Math.max(maxSell, prices[day] - buy);
            }
            // Update buy to the lowest price encountered so far
            buy = Math.min(buy, prices[day]);
            day++;
        }
        return maxSell; // Return the maximum profit
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(buyAndSell(prices)); // Output: 5
    }
}
```

---

## 💡 Dry Run Example

Let's walk through the code using the example `prices = [7, 1, 5, 3, 6, 4]`.

1. **Initial Values**:
   - `buy = Integer.MAX_VALUE`
   - `maxSell = 0`

2. **Day-by-Day Walkthrough**:
   - **Day 1**: Price = 7
     - `buy` is updated to 7 (the current minimum price).
   - **Day 2**: Price = 1
     - `buy` is updated to 1 (new minimum price).
   - **Day 3**: Price = 5
     - Profit if sold today: `5 - 1 = 4`
     - Update `maxSell` to 4.
   - **Day 4**: Price = 3
     - Profit if sold today: `3 - 1 = 2` (doesn’t change `maxSell`).
   - **Day 5**: Price = 6
     - Profit if sold today: `6 - 1 = 5`
     - Update `maxSell` to 5.
   - **Day 6**: Price = 4
     - Profit if sold today: `4 - 1 = 3` (doesn’t change `maxSell`).

3. **Final Result**:
   - After the loop, `maxSell` holds the maximum profit of `5`, which is returned as the answer.

---

## 🧩 Complexity Analysis

- **Time Complexity**: **O(n)**, as we only make a single pass through the prices array.
- **Space Complexity**: **O(1)**, as we use a constant amount of extra space.

---

## 📊 Example Walkthrough with Edge Cases

### Edge Case 1: No Profit Possible
   - **Input**: `prices = [7, 6, 4, 3, 1]`
   - **Explanation**: Prices are always falling, so no profitable transaction can be made.
   - **Output**: `0`

### Edge Case 2: All Prices are Equal
   - **Input**: `prices = [3, 3, 3, 3, 3]`
   - **Explanation**: All prices are the same, so no profit can be achieved.
   - **Output**: `0`

### Edge Case 3: Maximum Profit with Minimum Buy Price at the Start
   - **Input**: `prices = [1, 5, 3, 6, 4]`
   - **Explanation**: Buy on the first day (price `1`) and sell on the fourth day (price `6`) for maximum profit of `5`.
   - **Output**: `5`

---

## 🔑 Key Takeaways

- The key to solving this problem is **tracking the lowest price** and **calculating the profit** only when a higher price is found after that.
- A single traversal of the array helps us achieve an optimal solution with **O(n)** time complexity.
- This problem is a classic example of **maximizing profit** by finding the minimum cost and maximum return.

---

With this approach, you can effectively handle any input scenario to find the best day to buy and sell stocks for maximum profit!