# Balanced Partition Problem

## 1️⃣ **Problem Description**
Imagine you’re playing a balancing game! You’re given a string consisting of only two types of characters: **'L'** (representing left) and **'R'** (representing right). Your task is to split this string into the maximum number of balanced substrings. A substring is balanced when it contains an equal number of **'L'** and **'R'** characters.

For example:
- In the string `LRLRLLLRRLRR`, you can form balanced substrings like `LR`, `LR`, and `LLRR`.

Your goal is to find the maximum number of balanced substrings possible! 🎯

---

## 2️⃣ **Step-by-Step Explanation of the Code**
Let’s break it down! 🛠️

### **Function: `balancedPartion(String str)`**

1. **Initialization**:
   - `lCount` and `rCount` are counters for the number of **'L'** and **'R'** characters respectively.
   - `ans` keeps track of the number of balanced substrings.

2. **Iterate through the string**:
   - For each character in the string:
     - Increment `lCount` if it’s an **'L'**.
     - Increment `rCount` if it’s an **'R'**.

3. **Check for Balance**:
   - If `lCount` equals `rCount`, you’ve found a balanced substring! Increment `ans` and continue.

4. **Return the Result**:
   - At the end, `ans` contains the maximum number of balanced substrings.

---

## 3️⃣ **Example Walkthrough** 🌟
Let’s walk through the input string: `LRLRLLLRRLRR` step by step. 📊

| Step | Character | `lCount` | `rCount` | Balanced Substrings Found | `ans` |
|------|-----------|----------|----------|----------------------------|-------|
| 1    | L         | 1        | 0        | -                          | 0     |
| 2    | R         | 1        | 1        | `LR`                       | 1     |
| 3    | L         | 2        | 1        | -                          | 1     |
| 4    | R         | 2        | 2        | `LR`                       | 2     |
| 5    | L         | 3        | 2        | -                          | 2     |
| 6    | L         | 4        | 2        | -                          | 2     |
| 7    | L         | 5        | 2        | -                          | 2     |
| 8    | R         | 5        | 3        | -                          | 2     |
| 9    | R         | 5        | 4        | -                          | 2     |
| 10   | L         | 6        | 4        | -                          | 2     |
| 11   | R         | 6        | 5        | -                          | 2     |
| 12   | R         | 6        | 6        | `LLRR`                     | 3     |

Output: `3` balanced substrings.

---

## 4️⃣ **Approach** 💡
This solution uses a **greedy approach**, which means it makes the best possible decision at each step without looking ahead. By keeping a running count of **'L'** and **'R'** characters, we can detect balanced substrings as soon as they occur. This approach is efficient and intuitive for this problem. 🙌

---

## 5️⃣ **Pseudo Code** 📝
Here’s a simplified version of the logic:

```
function balancedPartition(str):
    if str is empty:
        return -1

    initialize lCount = 0, rCount = 0, ans = 0

    for each character in str:
        if character is 'L':
            increment lCount
        else if character is 'R':
            increment rCount

        if lCount equals rCount:
            increment ans

    return ans
```

---

## 6️⃣ **Full Code with Comments** 🖥️💬
```java
public class Greedy {
    // Function to count balanced partitions in a string
    public static int balancedPartion(String str) {
        // Get the length of the string
        int n = str.length();

        // Handle empty string
        if (n == 0) {
            return -1;
        }

        // Initialize counters for 'L', 'R', and the result
        int lCount = 0;
        int rCount = 0;
        int ans = 0;

        // Loop through each character in the string
        for (int i = 0; i < n; i++) {
            // Increment counts based on the character
            if (str.charAt(i) == 'L') {
                lCount++;
            } else {
                rCount++;
            }

            // If counts are equal, we found a balanced substring
            if (lCount == rCount) {
                ans++;
            }
        }

        // Return the total number of balanced substrings
        return ans;
    }

    public static void main(String[] args) {
        // Test the function with a sample string
        String str = "LRLRLLLRRLRR";
        System.out.println(balancedPartion(str)); // Output: 3
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍
### **Time Complexity**:
- **O(n)**: We iterate through the string once, where `n` is the length of the string.

### **Space Complexity**:
- **O(1)**: We only use a few integer variables (`lCount`, `rCount`, `ans`), so the space usage is constant.

---

## 8️⃣ **Key Takeaways** 🚀
- **Greedy Approach**: Make decisions at each step to solve the problem efficiently.
- **String Manipulation**: Counting characters and checking conditions are key techniques.
- **Edge Cases**: Always handle edge cases like an empty string to avoid unexpected errors.

Keep practicing these kinds of problems, and you’ll master algorithms in no time! 🌟💪

