
# 💰 Coin Change Problem using Greedy Algorithm  

### 1️⃣ **Problem Description**  
Imagine you’re at a candy store 🍬, and you need to pay exactly ₹590 for your favorite treats. But there’s a twist: the cashier only accepts coins of denominations ₹1, ₹2, ₹5, ₹10, ₹20, ₹50, ₹100, ₹500, and ₹2000.  
Your goal is to figure out the **minimum number of coins** you need to pay this amount. Sounds fun, right? Let’s solve it! ✨  

---

### 2️⃣ **Step-by-Step Explanation of the Code**  
Let’s decode this Java program step by step! 🛠️  

1. **Define the denominations**: We list out all the available coin denominations in an array, from ₹1 to ₹2000.  
   ```java
   int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
   ```  
   These are the tools in your coin pouch! 🪙  

2. **Set the target amount**: Let’s assume we need to make ₹590.  
   ```java
   int amount = 590;
   int count = 0;
   ```  

3. **Create a list for the result**: We use an `ArrayList` to keep track of the coins we’ll use.  
   ```java
   ArrayList<Integer> ans = new ArrayList<>();
   ```  

4. **Greedy approach to solve**:  
   - Start from the largest coin denomination and move downward.  
   - While the current coin can fit into the remaining amount, keep subtracting it and add the coin to our list.  
   ```java
   for (int i = coins.length - 1; i >= 0; i--) {
       while (amount >= coins[i]) {
           count++;
           ans.add(coins[i]);
           amount -= coins[i];
       }
   }
   ```  

5. **Print the results**: At the end, print the total number of coins used and the coins themselves!  
   ```java
   System.out.println(count + " ");
   for (int i = 0; i < ans.size(); i++) {
       System.out.print(ans.get(i) + " ");
   }
   ```  

---

### 3️⃣ **Example Walkthrough** 🌟  

Let’s walk through the code with the input `amount = 590`. 📊  

| **Step** | **Coin Used** | **Remaining Amount** | **Coins in List**          |  
|----------|---------------|-----------------------|----------------------------|  
| 1️⃣      | ₹500          | ₹90                  | [500]                      |  
| 2️⃣      | ₹50           | ₹40                  | [500, 50]                  |  
| 3️⃣      | ₹20           | ₹20                  | [500, 50, 20]              |  
| 4️⃣      | ₹20           | ₹0                   | [500, 50, 20, 20]          |  

**Output**:  
- **Count of coins**: 4  
- **Coins used**: ₹500, ₹50, ₹20, ₹20  

---

### 4️⃣ **Approach** 💡  
This solution uses the **Greedy Algorithm**. It works by:  
1. Always selecting the **largest possible coin** to reduce the remaining amount quickly.  
2. Repeating the process until the target amount is zero.  

This method ensures the **minimum number of coins** is used. It’s efficient because we focus on the biggest impact first! 🚀  

---

### 5️⃣ **Pseudo Code** 📝  
Here’s a simplified version:  

```
1. Start with the largest coin denomination.
2. While the target amount is greater than or equal to the coin:
   a. Subtract the coin from the target amount.
   b. Add the coin to the result list.
   c. Increase the coin count.
3. Move to the next smaller coin and repeat.
4. Stop when the target amount becomes zero.
5. Print the total coins used and the coins themselves.
```  

---

### 6️⃣ **Full Code with Comments** 🖥️💬  
```java
import java.util.ArrayList;

public class Greedy {
    public static void main(String[] args) {
        // Step 1: Define the coin denominations
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        // Step 2: Set the target amount and initialize variables
        int amount = 590;
        int count = 0; // Tracks the number of coins used
        ArrayList<Integer> ans = new ArrayList<>(); // Stores the coins used

        // Step 3: Iterate through the coin array (from largest to smallest)
        for (int i = coins.length - 1; i >= 0; i--) {
            // While the current coin fits into the remaining amount
            while (amount >= coins[i]) {
                count++; // Increment the coin count
                ans.add(coins[i]); // Add the coin to the result list
                amount -= coins[i]; // Reduce the remaining amount
            }
        }

        // Step 4: Print the results
        System.out.println("Total coins used: " + count);
        System.out.print("Coins used: ");
        for (int coin : ans) {
            System.out.print(coin + " ");
        }
        System.out.println();
    }
}
```  

---

### 7️⃣ **Complexity Analysis** 🔍  

- **Time Complexity**:  
  - The loop runs for each coin, and for each coin, it subtracts multiple times.  
  - **Worst-case**: O(n * k), where `n` is the number of coins and `k` is the target amount.  

- **Space Complexity**:  
  - We use an `ArrayList` to store the result, so **O(k)** for the coins used.  

---

### 8️⃣ **Key Takeaways** 🚀  
- The **Greedy Algorithm** is great for problems where making the locally optimal choice leads to the global solution.  
- Breaking a problem into smaller steps makes it easier to solve.  
- Keep practicing, and soon, you’ll be a master problem solver! 🌟  

💡 **Pro Tip**: Always double-check if the Greedy approach guarantees the optimal solution for your specific problem!  

Happy coding! 😄🎉  