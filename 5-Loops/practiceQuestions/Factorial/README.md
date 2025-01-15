
# Factorial Calculator

## 1️⃣ **Problem Description**
The **factorial** of a non-negative integer \( N \) is the product of all positive integers less than or equal to \( N \). It is denoted as \( N! \).

For example:
- \( 5! = 5 \times 4 \times 3 \times 2 \times 1 = 120 \)
- \( 0! = 1 \) (by definition)

This program calculates the factorial of a given non-negative integer using an iterative approach. 🚀

---

## 2️⃣ **How It Works**

### Factorial Definition:
- Factorial is defined only for **non-negative integers**.
- \( N! = N \times (N-1) \times (N-2) \times \ldots \times 1 \)
- \( 0! = 1 \) (special case)

---

## 3️⃣ **Code Explanation** 🛠️

### Input Validation:
```java
System.out.print("Enter a non-negative integer to calculate its factorial: ");
int n = scanner.nextInt();

if (n < 0) {
    System.out.println("Factorial is not defined for negative integers.");
}
```
The program ensures the input is a **non-negative integer**. If a negative number is entered, an error message is displayed.

### Iterative Calculation:
```java
int fact = 1;
for (int i = 2; i <= n; i++) {
    fact *= i;
}
```
- The factorial is calculated by multiplying all integers from \( 1 \) to \( n \).
- A loop is used to perform the multiplication iteratively.

### Output:
```java
System.out.println("Factorial of " + n + ": " + fact);
```
The program displays the factorial of the given number.

### Error Handling:
```java
catch (Exception e) {
    System.out.println("Invalid input! Please enter a valid non-negative integer.");
}
```
If the user enters invalid input (e.g., text instead of a number), the program handles the error gracefully.

---

## 4️⃣ **Example Walkthrough** 🌟

### Example 1:
#### Input:
```
Enter a non-negative integer to calculate its factorial: 5
```
#### Execution:
1. \( fact = 1 \)
2. \( fact = 1 \times 2 = 2 \)
3. \( fact = 2 \times 3 = 6 \)
4. \( fact = 6 \times 4 = 24 \)
5. \( fact = 24 \times 5 = 120 \)

#### Output:
```
Factorial of 5: 120
```

### Example 2:
#### Input:
```
Enter a non-negative integer to calculate its factorial: -3
```
#### Output:
```
Factorial is not defined for negative integers.
```

### Example 3:
#### Input:
```
Enter a non-negative integer to calculate its factorial: 0
```
#### Output:
```
Factorial of 0: 1
```

---

## 5️⃣ **Pseudo Code** 📝
Here’s a simplified version of the logic:
```
1. Input a non-negative integer (n).
2. If n < 0, display an error message.
3. Initialize fact = 1.
4. For i from 2 to n:
    Multiply fact by i.
5. Display fact as the factorial of n.
```

---

## 6️⃣ **Full Code** 💻
```java
import java.util.Scanner; // Import the Scanner class for user input

/*
 * Explanation: The factorial of a non-negative integer N is the product of all positive integers less than or equal to N.
 * It is denoted by N!.
 * For example, 5! = 5 × 4 × 3 × 2 × 1 = 120.
 */
public class Factorial {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a non-negative integer to calculate its factorial: "); // Prompt user for input
            int n = scanner.nextInt(); // Read the input
            
            // Check if the input is valid (non-negative)
            if (n < 0) {
                System.out.println("Factorial is not defined for negative integers.");
            } else {
                int fact = 1;  // Initialize factorial to 1
                // Loop to calculate factorial
                for (int i = 2; i <= n; i++) {
                    fact *= i;  // Multiply each number up to n
                }
                System.out.println("Factorial of " + n + ": " + fact); // Display the factorial
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid non-negative integer.");
        }
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍

### Time Complexity:
- **\( O(n) \)**: The program iterates from 2 to \( n \), performing \( n-1 \) multiplications.

### Space Complexity:
- **\( O(1) \)**: The program uses a constant amount of memory regardless of the input size.

---

## 8️⃣ **Key Takeaways** 🌟
1. Factorial is a fundamental concept in mathematics and programming. 🧠
2. Input validation ensures the program handles invalid cases gracefully. 🛡️
3. Iterative approaches are efficient and straightforward for calculating factorials. ✨

---
