# Armstrong Number Checker

## 1️⃣ **Problem Description**
Imagine you are a math detective 🕵️‍♂️, and your mission is to find special numbers called **Armstrong numbers** (or **Narcissistic numbers**). These numbers are magical because they are equal to the sum of their own digits raised to the power of the number of digits. ✨

For example:
- **153** is an Armstrong number because:
  
  \( 1^3 + 5^3 + 3^3 = 153 \)
  - 1 raised to the power of 3 = 1
  - 5 raised to the power of 3 = 125
  - 3 raised to the power of 3 = 27
  - Sum = 1 + 125 + 27 = 153

Your job is to write a program that can check if a given number is an Armstrong number or not! 🚀

---

## 2️⃣ **Step-by-Step Explanation of the Code** 🛠️
Let’s break it down:

### Import Scanner for Input:
```java
import java.util.Scanner; // Import the Scanner class for user input
```
This lets us take input from the user. 👩‍💻

### Prompt for Input:
```java
System.out.print("Enter a number: ");
int number = scanner.nextInt();
```
We ask the user for a number and store it in the variable `number`. 📥

### Save Original and Initialize Variables:
```java
int original = number;
int sum = 0;
int n = String.valueOf(number).length();
```
- `original`: Keeps a copy of the input for comparison later. 📂
- `sum`: Will hold the sum of digits raised to the power. ➕
- `n`: Calculates the number of digits in the input. 🧮

### Loop Through Digits:
```java
while (number != 0) {
    int digit = number % 10; // Get the last digit
    sum += Math.pow(digit, n); // Raise it to the power of n and add to sum
    number /= 10; // Remove the last digit
}
```
- Extract each digit using `%`.
- Raise it to the power of `n` using `Math.pow()` and add to `sum`. 💥
- Remove the last digit using `/= 10`. 🧹

### Compare Sum to Original:
```java
System.out.println(original + " is Armstrong: " + (original == sum));
```
If the `sum` matches the `original` number, it’s an Armstrong number! 🎉

---

## 3️⃣ **Example Walkthrough** 🌟
### Input:
```
Enter a number: 153
```

### Step-by-Step Execution:
1. Original number = 153
2. Number of digits (`n`) = 3
3. Extract digits and compute:
   - Digit = 3, Sum = \( 3^3 = 27 \)
   - Digit = 5, Sum = \( 27 + 5^3 = 152 \)
   - Digit = 1, Sum = \( 152 + 1^3 = 153 \)
4. Compare: \( 153 == 153 \) ✅

### Output:
```
153 is Armstrong: true
```

---

## 4️⃣ **Approach** 💡
The solution works by:
1. Extracting each digit using `%`.
2. Raising the digit to the power of the total number of digits using `Math.pow()`.
3. Summing up these values.
4. Comparing the result with the original number. Simple yet powerful! 💪

This approach is efficient because it processes each digit exactly once. 🔥

---

## 5️⃣ **Pseudo Code** 📝
Here’s a simplified version of the solution:
```
1. Take input number.
2. Store the original number.
3. Calculate the number of digits.
4. Initialize sum = 0.
5. While the number is not 0:
    a. Extract the last digit.
    b. Raise it to the power of digits.
    c. Add to sum.
    d. Remove the last digit.
6. Compare sum with the original number.
7. Output true if equal, false otherwise.
```

---

## 6️⃣ **Full Code with Comments** 🖥️💬
```java
import java.util.Scanner; // Import the Scanner class for user input

public class ArmstrongNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: "); // Prompt user for input
            int number = scanner.nextInt(); // Read the number from user input

            int original = number;  // Store the original number for comparison
            int sum = 0;  // Initialize sum to store the sum of powers of digits
            int n = String.valueOf(number).length();  // Get the number of digits

            // Loop to calculate the sum of digits raised to the power of the number of digits
            while (number != 0) {
                int digit = number % 10;  // Get the last digit
                sum += Math.pow(digit, n);  // Add the digit raised to the power of n
                number /= 10;  // Remove the last digit
            }

            // Check if the original number is equal to the sum
            System.out.println(original + " is Armstrong: " + (original == sum));
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid integer.");
        }
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍
### Time Complexity:
- Extracting digits: \( O(d) \), where \( d \) is the number of digits.
- Raising to power: Constant time (for small \( n \)).
- Total: \( O(d) \).

### Space Complexity:
- Uses constant extra space: \( O(1) \).

---

## 8️⃣ **Key Takeaways** 🚀
1. Armstrong numbers are fascinating examples of math and programming working together. ✨
2. Breaking problems into smaller steps makes them easier to solve. 🧩
3. Error handling ensures your program is user-friendly. 🛡️

Keep practicing and exploring new challenges. You’re doing great! 💪😄

