# Keypad Letter Combination Problem

## The Problem  
The keypad letter combination problem asks us to generate all possible letter combinations that the digits of a phone keypad can represent. Each digit corresponds to a set of letters (like on a mobile keypad). Given a string of digits, find all the combinations of letters that can be formed by pressing those keys.

---
<img src="https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png" alt="Telephone Keypad" width="250">


## Problem Statement  
Given a string containing digits from `2-9` (inclusive), return all possible letter combinations the digits could represent. A mapping of digits to letters is provided, similar to a phone keypad.

### Example  

#### Input:  
```
digits = "23"
```

#### Output:  
```
["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
```

---

## Approach  

### Step-by-Step Explanation  

1. **Understanding the Keypad Mapping**:  
   Each digit from 2 to 9 maps to a set of letters. For instance:  
   - `2 -> "abc"`
   - `3 -> "def"`
   - `4 -> "ghi"`, and so on.  

2. **Recursive Backtracking**:  
   - Start with an empty string (`output`).
   - For each digit, loop through its corresponding characters.  
   - Add each character to `output` and recurse for the next digit.  
   - If the length of `output` equals the length of the input digits, add it to the result list.

3. **Backtracking**:  
   - After exploring all combinations for a character, backtrack by removing the last added character to try the next option.

4. **Base Case**:  
   - When we process all the digits, add the current combination (`output`) to the result list.

5. **Edge Cases**:  
   - If the input string is empty, return an empty list.

---

## Algorithm (Pseudocode)  

```plaintext
FUNCTION letterCombinations(digits):
    IF digits is empty:
        RETURN []

    mapping = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
    result = []
    INITIALIZE output = ""
    INITIALIZE index = 0

    FUNCTION solve(digits, output, index, result, mapping):
        IF index >= length(digits):
            ADD output to result
            RETURN

        number = digits[index] as integer
        letters = mapping[number]

        FOR each letter in letters:
            ADD letter to output
            CALL solve(digits, output, index + 1, result, mapping)
            REMOVE last character from output (backtrack)

    CALL solve(digits, output, index, result, mapping)
    RETURN result
```

---

## Code Explanation Walkthrough  

1. **Mapping Initialization**:  
   A `String[] mapping` stores letters for each digit (index corresponds to the digit).

2. **Base Case**:  
   If the `digits` string is empty, return an empty list.

3. **Recursive Function (`solve`)**:  
   - **Base case**: When `index` equals the length of `digits`, add the current combination (`output`) to the result.
   - Loop through the letters corresponding to the current digit.  
   - Add a letter to `output` and recursively call `solve` for the next digit.  
   - Backtrack by removing the last letter from `output` to try the next option.

4. **Main Method**:  
   - Calls the `solve` function to populate the result list.
   - Prints the result or a message if no combinations exist.

---

## Time Complexity  
- **Recursive Calls**: At each step, we make `k` recursive calls, where `k` is the number of letters for the current digit (up to 4 for digits like `7` or `9`).  
- **Total Combinations**: If there are `n` digits, there are at most \( 4^n \) combinations.  
- **Complexity**: \( O(4^n \cdot n) \), where \( n \) is the length of the input.  

## Space Complexity  
- **Auxiliary Space**: \( O(n) \) for the recursion stack, where \( n \) is the length of the input.  
- **Result Storage**: Proportional to the number of combinations (\( 4^n \)).  

---

## Key Features  

1. **Efficient Use of Backtracking**:  
   By systematically exploring all combinations and backtracking, we avoid redundant calculations.

2. **Modular Design**:  
   The problem is divided into manageable steps: mapping initialization, recursion, and result storage.

3. **Scalable Solution**:  
   The algorithm handles inputs of varying lengths efficiently.

---

## Why Use Backtracking?  

- **Exploration of All Paths**:  
  Backtracking ensures all possible combinations are explored systematically.  

- **Efficient Pruning**:  
  Invalid combinations are discarded early, reducing unnecessary computations.  

---

## Tips  

1. **Start Small**:  
   Try understanding the problem with a single-digit input before scaling up.  

2. **Visualize Recursion**:  
   Draw a tree to visualize the combinations being generated at each step.

3. **Debugging Backtracking**:  
   Add print statements to observe the function calls and backtracking in action.

---

## Conclusion  

The Keypad Letter Combination problem is a classic example of recursive backtracking. It demonstrates the power of systematically exploring all possibilities while efficiently pruning invalid options. With proper understanding, this problem provides a solid foundation for solving other combinatorial problems.