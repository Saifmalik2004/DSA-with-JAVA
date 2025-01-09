

# Friends Pairing Problem

## 👯‍♂️ Problem Overview

Imagine you have a group of friends planning to attend a party. But there’s a twist! Each friend has two options:
1. **Stay Single** at the party, hanging out alone. 😎
2. **Pair Up** with another friend to form a couple and enjoy the party together. 💃🕺

Now, your task is to find how many different ways the friends can either stay single or form pairs at the party. 

### 🎯 Goal

Given `n` friends, calculate the total number of ways they can attend the party either by pairing up or staying single.

---

## 💡 Problem Breakdown

Let’s break down the logic step by step to make it fun and simple to follow:

### 🧑‍🤝‍🧑 Pairing Friends

For each friend, there are two choices:
1. **Stay single**: This reduces the problem to `n-1` friends.
2. **Pair up with another friend**: If one friend pairs up, there are `n-1` choices for whom they can pair with. After that, the remaining friends are reduced to `n-2`.

### 🧑‍🤝‍🧑 The Formula

We use the following formula to find the total number of ways:
\[
friendsPairing(n) = friendsPairing(n - 1) + (n - 1) \times friendsPairing(n - 2)
\]
- **friendsPairing(n - 1)**: This represents the case where the last friend stays single.
- **(n - 1) × friendsPairing(n - 2)**: This represents the case where the last friend pairs up with one of the `n-1` friends.

### 🔑 Base Case:
- **If `n = 1`**: There’s only one way — the single friend stays alone.
- **If `n = 2`**: There are two possibilities:
  1. Both friends stay single.
  2. The friends pair up.

---

## 🧩 Code Explanation

Here’s the code that calculates the total number of ways for the friends to pair up or stay single:

```java
public class FriendsPairing {
    public static int friendsPairing(int n) {
        // Base cases
        if(n == 1 || n == 2) {
            return n;
        }

        // Recursive call based on two options:
        // Option 1: Last friend stays single
        // Option 2: Last friend pairs up with someone
        return friendsPairing(n - 1) + ((n - 1) * friendsPairing(n - 2));
    }

    public static void main(String[] args) {
        System.out.println(friendsPairing(3)); // Output the result for 3 friends
    }
}
```

### 📝 How It Works:

1. **Base Case**: If there’s 1 or 2 friends, return `n` (either 1 or 2).
2. **Recursive Call**: For larger `n`, calculate the number of ways by breaking down the problem into two cases:
   - Friend `n` stays single.
   - Friend `n` pairs up with any of the `n-1` friends.

---

## 🏆 Real-Life Example

Let’s consider a real-life scenario with **3 friends**: Alice, Bob, and Charlie. They are deciding how they’ll go to the party. The possibilities are:

1. **All friends stay single**:  
   - Alice, Bob, and Charlie each go alone. (1 way)
   
2. **Alice and Bob pair up, Charlie stays single**:  
   - Alice and Bob pair up, and Charlie goes alone. (1 way)
   
3. **Alice and Charlie pair up, Bob stays single**:  
   - Alice and Charlie pair up, and Bob goes alone. (1 way)
   
4. **Bob and Charlie pair up, Alice stays single**:  
   - Bob and Charlie pair up, and Alice goes alone. (1 way)

**Total number of ways for 3 friends** = **4 ways**.

---

## 🔢 Dry Run for `n = 3`

Let’s step through the code for `n = 3`:

1. **Call `friendsPairing(3)`**:
   - Option 1: Friend 3 stays single → We need `friendsPairing(2)`.
   - Option 2: Friend 3 pairs with any of the 2 other friends → We need `(n - 1) * friendsPairing(1)` which is `2 * friendsPairing(1)`.

2. **Call `friendsPairing(2)`**:
   - Base case: Return 2 (either stay single or pair up).

3. **Call `friendsPairing(1)`**:
   - Base case: Return 1 (only one way — stay single).

4. Combine the results:
   - `friendsPairing(3) = friendsPairing(2) + (n - 1) * friendsPairing(1)`
   - `friendsPairing(3) = 2 + 2 * 1 = 4`

Thus, for `n = 3`, the total number of ways to arrange the friends is `4`.

---

## 🧮 Complexity Analysis

### ⏱ Time Complexity:
- **O(2^n)**: Due to the recursive nature, each function call branches into two calls. The time complexity grows exponentially.

### 📦 Space Complexity:
- **O(n)**: The space complexity is determined by the maximum depth of the recursion tree, which is `n` in this case.

---

## 🎉 Conclusion

The **Friends Pairing Problem** is a fun and engaging way to learn about recursion! By breaking down the problem into smaller sub-problems, we can easily calculate the number of ways `n` friends can either pair up or stay single at a party.

---

**Try changing `n`** in the code and see how the number of possibilities increases as you add more friends! 🎉

---

Let me know if you'd like further clarification or if you're ready to explore more problems like this! 😊