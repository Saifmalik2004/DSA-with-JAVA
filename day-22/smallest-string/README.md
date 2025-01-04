# Problem: Smallest String with a Given Numeric Value

## Problem Description
We need to generate the **smallest lexicographical string** such that:
1. The string has a length of **`n`**.
2. The sum of the character values equals **`k`**, where:
   - `'a'` = 1, `'b'` = 2, ..., `'z'` = 26.

The goal is to use as many `'a'` (smallest letters) as possible and adjust the rest of the string to ensure the total sum equals `k`.

---

## Step-by-Step Explanation of the Code

### 1. Initialize the Result Array
```java
char res[] = new char[n];
Arrays.fill(res, 'a');
```
- Create a character array `res` of size `n` (e.g., `n = 5` → `res = ['a', 'a', 'a', 'a', 'a']`).
- Fill the array with `'a'` because `'a'` is the smallest possible character, and we want the smallest lexicographical string.

### 2. Adjust `k`
```java
k -= n;
```
- Since we already filled the array with `'a'`, their current value contributes `n` to the sum (`'a' = 1` for each of the `n` characters).
- Subtract `n` from `k` because we've already accounted for those `n` `'a'` characters.
- For example:  
  - If `n = 5` and `k = 73`, subtracting gives `k = 73 - 5 = 68`.

### 3. Update the Characters from Right to Left
```java
while (k > 0) {
    res[--n] += Math.min(25, k);
    k -= Math.min(25, k);
}
```
- This loop adjusts the last characters in the string to make the sum equal to `k`:
  - `--n`: Start from the last index of the array (`n-1`) and move leftwards.
  - `Math.min(25, k)`: Since `'z' - 'a' = 25`, the maximum we can increase any character by is 25 (to make it `'z'`). Add the smaller of `25` or the remaining `k` to the character.
  - Update `k` accordingly by subtracting the value you added.

#### Example Walkthrough
**Input:** `n = 5, k = 73`

- **Initial State:**
  - `res = ['a', 'a', 'a', 'a', 'a']`
  - `k = 73 - 5 = 68`

- **1st Iteration:**
  - Update the last character: `res[4] = 'a' + 25 = 'z'` (add 25 since `Math.min(25, 68) = 25`).
  - Update `k`: `k = 68 - 25 = 43`.  
  - Result so far: `res = ['a', 'a', 'a', 'a', 'z']`.

- **2nd Iteration:**
  - Update the second last character: `res[3] = 'a' + 25 = 'z'`.  
  - Update `k`: `k = 43 - 25 = 18`.  
  - Result so far: `res = ['a', 'a', 'a', 'z', 'z']`.

- **3rd Iteration:**
  - Update the third last character: `res[2] = 'a' + 18 = 's'` (add remaining 18 since `Math.min(25, 18) = 18`).  
  - Update `k`: `k = 18 - 18 = 0`.  
  - Result so far: `res = ['a', 'a', 's', 'z', 'z']`.

- **Final Result:** Convert `res` to string: `"aaszz"`.

---

## Approach
To solve this problem, we use the following approach:

1. **Start with the Smallest Characters**:
   - Initialize a string of length `n` filled with `'a'`. Since `'a'` has the smallest value (1), this ensures the string is lexicographically smallest to start with.

2. **Adjust `k`**:
   - Subtract `n` from `k` because each `'a'` contributes 1 to the total sum.

3. **Modify Characters from Right to Left**:
   - Start from the last character of the string and adjust it upwards (towards `'z'`) to match the remaining `k`.
   - For each character, add the smaller of `25` (maximum possible increase to reach `'z'`) or the remaining `k`.
   - Reduce `k` accordingly after each adjustment.

4. **Stop When `k = 0`**:
   - Once `k` is exhausted, the string is complete.

5. **Return the Result**:
   - Convert the character array to a string and return it.

---

## Pseudo Code
```
function getSmallestString(n, k):
    # Step 1: Initialize result array with 'a'
    res = array of size n filled with 'a'
    
    # Step 2: Adjust k
    k = k - n

    # Step 3: Modify characters from right to left
    while k > 0:
        res[n - 1] = res[n - 1] + min(25, k)
        k = k - min(25, k)
        n = n - 1

    # Step 4: Convert array to string and return
    return string(res)
```

---

## Full Code with Comments
```java
class Solution {
    public String getSmallestString(int n, int k) {
        // Step 1: Initialize result array with 'a'
        char res[] = new char[n];
        Arrays.fill(res, 'a');

        // Step 2: Adjust k
        k -= n;

        // Step 3: Modify characters from right to left
        while (k > 0) {
            res[--n] += Math.min(25, k); // Increase character value
            k -= Math.min(25, k);       // Reduce k accordingly
        }

        // Step 4: Convert to string and return
        return String.valueOf(res);
    }
}
```

---

## Complexity Analysis
1. **Time Complexity**:
   - The loop iterates at most `n` times (each iteration processes one character from the end of the string).
   - Each iteration involves constant-time operations.
   - **Time Complexity = O(n)**.

2. **Space Complexity**:
   - The additional space is used for the result array of size `n`.
   - **Space Complexity = O(n)**.

---

## Key Takeaways
1. Start with the smallest letters (`'a'`) to ensure the string is lexicographically smallest.
2. Use the remaining value `k` to adjust characters from the rightmost end.
3. Always add the smallest possible value (`Math.min(25, k)`) to keep the string minimal.

---

Feel free to reach out if you have any doubts or need further clarification!

