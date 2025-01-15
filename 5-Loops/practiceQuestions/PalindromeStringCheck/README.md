
# Palindrome String Checker

## 1️⃣ **Problem Description**
A **palindrome string** is one that reads the same backward as forward.

### Examples of Palindromes:
- **"madam"** → Reverse: **"madam"** → Palindrome ✅  
- **"racecar"** → Reverse: **"racecar"** → Palindrome ✅  
- **"hello"** → Reverse: **"olleh"** → Not a Palindrome ❌  

This program checks whether a given string is a **palindrome**.

---

## 2️⃣ **Code Explanation** 🛠️

### Step-by-Step Process:

1. **Input a String**:  
   The user is prompted to enter a string.
   ```java
   System.out.print("Enter a string to check if it is a palindrome: ");
   String str = scanner.nextLine();
   ```

2. **Check for Palindrome**:
   - **Logic**: Compare the characters of the string from the start and end, moving toward the center.  
   - If any mismatch is found, the string is **not a palindrome**.
   ```java
   boolean isPalindrome = true;
   for (int i = 0; i < n / 2; i++) {
       if (str.charAt(i) != str.charAt(n - 1 - i)) {
           isPalindrome = false;
           break;
       }
   }
   ```

3. **Display the Result**:
   The program outputs whether the given string is a palindrome.
   ```java
   System.out.println("\"" + str + "\" is palindrome: " + isPalindrome);
   ```

---

## 3️⃣ **Example Walkthrough** 🌟

### Example 1:
#### Input:
```
Enter a string to check if it is a palindrome: madam
```
#### Execution:
1. String Length: \(5\)
2. Comparisons:
   - \(str[0] = m\), \(str[4] = m\) → Match ✅  
   - \(str[1] = a\), \(str[3] = a\) → Match ✅  
3. Result: **Palindrome**

#### Output:
```
"madam" is palindrome: true
```

---

### Example 2:
#### Input:
```
Enter a string to check if it is a palindrome: hello
```
#### Execution:
1. String Length: \(5\)
2. Comparisons:
   - \(str[0] = h\), \(str[4] = o\) → Mismatch ❌  
3. Result: **Not a Palindrome**

#### Output:
```
"hello" is palindrome: false
```

---

### Example 3:
#### Input:
```
Enter a string to check if it is a palindrome: racecar
```
#### Execution:
1. String Length: \(7\)
2. Comparisons:
   - \(str[0] = r\), \(str[6] = r\) → Match ✅  
   - \(str[1] = a\), \(str[5] = a\) → Match ✅  
   - \(str[2] = c\), \(str[4] = c\) → Match ✅  
3. Result: **Palindrome**

#### Output:
```
"racecar" is palindrome: true
```

---

## 4️⃣ **Pseudo Code** 📝
```
1. Input a string.
2. Assume the string is a palindrome (isPalindrome = true).
3. Compare characters from the start and end, moving toward the center:
   a. If any characters don’t match, set isPalindrome = false and break the loop.
4. Display the result: Whether the string is a palindrome or not.
```

---

## 5️⃣ **Full Code** 💻
```java
import java.util.Scanner; // Import the Scanner class for user input

// Explanation: Similar to numbers, a string is a palindrome if it reads the same backward as forward. 
// For example, "madam" is a palindrome.

public class PalindromeStringChecker {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string to check if it is a palindrome: "); // Prompt user for input
            String str = scanner.nextLine(); // Read the input
            
            int n = str.length();
            // Check characters from the start and end moving towards the center
            boolean isPalindrome = true; // Assume the string is a palindrome
            for (int i = 0; i < n / 2; i++) {
                if (str.charAt(i) != str.charAt(n - 1 - i)) {
                    isPalindrome = false; // If characters don't match, it's not a palindrome
                    break;
                }
            }
            System.out.println("\"" + str + "\" is palindrome: " + isPalindrome); // Display if the string is a palindrome
        }
    }
}
```

---

## 6️⃣ **Complexity Analysis** 🔍

### Time Complexity:
- **\( O(n) \)**: The loop iterates through half the string (\( n/2 \)), so the complexity is linear.

### Space Complexity:
- **\( O(1) \)**: The program uses a constant amount of additional memory for variables.

---

## 7️⃣ **Key Takeaways** 🌟
1. The palindrome check is efficient and compares only half the string. ✨  
2. This approach is case-sensitive. For example, **"Madam"** is not considered a palindrome.  
   To handle case insensitivity, the string can be converted to lowercase using:
   ```java
   str = str.toLowerCase();
   ```
3. Input validation ensures user-friendly behavior.

---
