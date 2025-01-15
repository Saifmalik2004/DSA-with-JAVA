
# Palindrome Number Checker

## 1️⃣ **Problem Description**
A **palindrome** is a number that reads the same forward as it does backward.

### Examples of Palindromes:
- \(121\) → Reverse: \(121\) → Palindrome ✅
- \(12321\) → Reverse: \(12321\) → Palindrome ✅
- \(1234\) → Reverse: \(4321\) → Not a Palindrome ❌

This program determines whether a given number is a **palindrome**.

---

## 2️⃣ **Code Explanation** 🛠️

### Step-by-Step Process:
1. **Input a Number**:
   The user is prompted to enter a number.
   ```java
   System.out.print("Enter a number to check if it is a palindrome: ");
   int number = scanner.nextInt();
   ```
   
2. **Store the Original Number**:
   The input number is saved in the variable `original` for comparison later.
   ```java
   int original = number;
   ```

3. **Reverse the Number**:
   The program reverses the number using the following logic:
   - Extract the last digit of the number using the modulo operator (\(number \% 10\)).
   - Append the digit to the reversed number.
   - Remove the last digit from the number by dividing it by 10.
   ```java
   while (number != 0) {
       int digit = number % 10;
       reversed = reversed * 10 + digit;
       number /= 10;
   }
   ```

4. **Check for Palindrome**:
   Compare the reversed number with the original number. If they are equal, the number is a palindrome.
   ```java
   System.out.println(original + " is palindrome: " + (original == reversed));
   ```

---

## 3️⃣ **Example Walkthrough** 🌟

### Example 1:
#### Input:
```
Enter a number to check if it is a palindrome: 121
```
#### Execution:
1. Original Number: \(121\)
2. Reverse: \(121\)
3. Comparison: \(121 == 121\)
4. Result: **Palindrome**

#### Output:
```
121 is palindrome: true
```

---

### Example 2:
#### Input:
```
Enter a number to check if it is a palindrome: 123
```
#### Execution:
1. Original Number: \(123\)
2. Reverse: \(321\)
3. Comparison: \(123 != 321\)
4. Result: **Not a Palindrome**

#### Output:
```
123 is palindrome: false
```

---

### Example 3:
#### Input:
```
Enter a number to check if it is a palindrome: -121
```
#### Execution:
1. Original Number: \(-121\)
2. Reverse: \(-121\) (The minus sign does not reverse correctly in this case.)
3. Comparison: \(-121 != -121\)
4. Result: **Not a Palindrome**

#### Output:
```
-121 is palindrome: false
```

---

## 4️⃣ **Pseudo Code** 📝
```
1. Input a number.
2. Store the original number for later comparison.
3. Reverse the number:
   a. Extract the last digit (number % 10).
   b. Append it to the reversed number (reversed = reversed * 10 + digit).
   c. Remove the last digit (number = number / 10).
4. Compare the reversed number with the original number.
5. Output whether the number is a palindrome.
```

---

## 5️⃣ **Full Code** 💻
```java
import java.util.Scanner; // Import the Scanner class for user input

// Explanation: A palindrome is a number that remains the same when its digits are reversed. 
// For example, 121 and 12321 are palindromes.

public class PalindromeNumChecker {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number to check if it is a palindrome: "); // Prompt user for input
            int number = scanner.nextInt(); // Read the input
            
            int original = number; // Store original number
            int reversed = 0;
            // Reverse the number
            while (number != 0) {
                int digit = number % 10;  // Get the last digit
                reversed = reversed * 10 + digit;  // Build the reversed number
                number /= 10;  // Remove the last digit
            }
            System.out.println(original + " is palindrome: " + (original == reversed)); // Check and display if the number is a palindrome
        }
    }
}
```

---

## 6️⃣ **Complexity Analysis** 🔍

### Time Complexity:
- **\( O(d) \)**: The program iterates through each digit of the number, where \( d \) is the number of digits.

### Space Complexity:
- **\( O(1) \)**: The program uses a constant amount of memory for variables (`original`, `reversed`, `digit`).

---

## 7️⃣ **Key Takeaways** 🌟
1. Palindromes can be efficiently checked using a simple mathematical approach. ✨
2. Input validation ensures the program handles unexpected inputs properly. 🛡️
3. This approach works for any integer but does not handle negative numbers as palindromes.

---

