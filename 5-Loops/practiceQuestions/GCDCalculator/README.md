
# GCD Calculator

## 1️⃣ **Problem Description**
The **Greatest Common Divisor (GCD)**, also known as the **Highest Common Factor (HCF)**, is the largest number that divides two or more numbers without leaving a remainder. It’s a fundamental concept in mathematics and is widely used in problem-solving.

For example:
- **GCD of 48 and 18** is **6**.
- **GCD of 100 and 25** is **25**.

This program calculates the GCD of two numbers using the **Euclidean Algorithm**, a highly efficient and simple method. 🚀

---

## 2️⃣ **How It Works**
The **Euclidean Algorithm** finds the GCD by repeatedly replacing the larger number with the remainder of the division of the two numbers, until the remainder is zero. The last non-zero number is the GCD.

### Steps:
1. Divide the larger number by the smaller number.
2. Replace the larger number with the smaller number and the smaller number with the remainder.
3. Repeat the process until the remainder becomes zero.
4. The last non-zero number is the GCD.

---

## 3️⃣ **Code Explanation** 🛠️

### Import Scanner:
```java
import java.util.Scanner;
```
This allows the program to take user input.

### Input Numbers:
```java
System.out.print("Enter first number: ");
int num1 = scanner.nextInt();

System.out.print("Enter second number: ");
int num2 = scanner.nextInt();
```
The program prompts the user to enter two integers.

### Euclidean Algorithm:
```java
int a = num1; 
int b = num2;
while (b != 0) {
    int temp = b; 
    b = a % b;  // Update b to the remainder of a divided by b
    a = temp;  // Update a to the previous b
}
```
- This loop calculates the GCD using the Euclidean algorithm.
- The variables `a` and `b` are updated until `b` becomes zero.

### Output the GCD:
```java
System.out.println("GCD of " + num1 + " and " + num2 + ": " + a);
```
The program displays the GCD of the two numbers.

### Error Handling:
```java
catch (Exception e) {
    System.out.println("Invalid input! Please enter valid integers.");
}
```
If the user enters invalid input, an error message is displayed.

---

## 4️⃣ **Example Walkthrough** 🌟

### Input:
```
Enter first number: 48
Enter second number: 18
```

### Execution:
1. \( a = 48, b = 18 \)
2. \( 48 \% 18 = 12 \) → Update \( a = 18, b = 12 \)
3. \( 18 \% 12 = 6 \) → Update \( a = 12, b = 6 \)
4. \( 12 \% 6 = 0 \) → Update \( a = 6, b = 0 \)
5. Remainder is zero. **GCD = 6**

### Output:
```
GCD of 48 and 18: 6
```

---

## 5️⃣ **Pseudo Code** 📝
Here’s a simplified version of the logic:
```
1. Input two numbers.
2. Assign the numbers to a and b.
3. While b is not zero:
    a. Update b to the remainder of a divided by b.
    b. Update a to the previous value of b.
4. Output a as the GCD.
```

---

## 6️⃣ **Full Code** 💻
```java
import java.util.Scanner; // Import the Scanner class for user input

/*
 * Explanation: The GCD (Greatest Common Divisor) is the largest number that divides two or more numbers without leaving a remainder.
 * For example, the GCD of 48 and 18 is 6.
 */

public class GCD {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first number: "); // Prompt user for input
            int num1 = scanner.nextInt(); // Read the first number
            
            System.out.print("Enter second number: "); // Prompt user for input
            int num2 = scanner.nextInt(); // Read the second number
            
            int a = num1; 
            int b = num2;
            while (b != 0) {
                int temp = b; 
                b = a % b;  // Update b to the remainder of a divided by b
                a = temp;  // Update a to the previous b
            }
            System.out.println("GCD of " + num1 + " and " + num2 + ": " + a); // Display the GCD
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter valid integers.");
        }
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍

### Time Complexity:
- The Euclidean algorithm has a time complexity of \( O(\log(\min(a, b))) \), where \( a \) and \( b \) are the input numbers.

### Space Complexity:
- The algorithm uses constant space, \( O(1) \).

---

## 8️⃣ **Key Takeaways** 🌟
1. The Euclidean algorithm is an efficient way to calculate the GCD. 🧠
2. The GCD is useful in problems involving fractions, ratios, and divisibility. ✨
3. Error handling ensures the program is robust and user-friendly. 🛡️

---
