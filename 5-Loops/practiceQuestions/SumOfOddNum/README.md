
# Sum of Odd Numbers

## 1️⃣ **Problem Description**  
Odd numbers are integers that are not divisible by 2 (e.g., 1, 3, 5, 7, ...).  
This program calculates the **sum of all odd numbers** up to a given number \( N \).

### Examples:
- For \( N = 5 \), the odd numbers are \( 1, 3, 5 \). The sum is \( 1 + 3 + 5 = 9 \).  
- For \( N = 10 \), the odd numbers are \( 1, 3, 5, 7, 9 \). The sum is \( 1 + 3 + 5 + 7 + 9 = 25 \).

---

## 2️⃣ **Code Explanation** 🛠️

### Step-by-Step Process:
1. **Input a Number**:  
   The user is prompted to enter a positive integer \( N \).  
   ```java
   System.out.print("Enter a number N to calculate the sum of odd numbers up to N: ");
   int n = scanner.nextInt();
   ```

2. **Calculate the Sum of Odd Numbers**:  
   - Use a **for loop** starting from \( 1 \) (the first odd number) and increment by \( 2 \) in each iteration to ensure only odd numbers are added.  
   ```java
   int sum = 0; // Initialize sum to zero
   for (int i = 1; i <= n; i += 2) {
       sum += i; // Add each odd number to the sum
   }
   ```

3. **Display the Result**:  
   After the loop completes, the program outputs the total sum of odd numbers.  
   ```java
   System.out.println("Sum of odd numbers up to " + n + ": " + sum);
   ```

---

## 3️⃣ **Example Walkthrough** 🌟

### Example 1:
#### Input:
```
Enter a number N to calculate the sum of odd numbers up to N: 5
```
#### Execution:
1. Start: \( N = 5 \)  
2. Loop Steps:
   - \( i = 1 \), Sum = \( 0 + 1 = 1 \)
   - \( i = 3 \), Sum = \( 1 + 3 = 4 \)
   - \( i = 5 \), Sum = \( 4 + 5 = 9 \)  
3. Final Sum: \( 9 \)

#### Output:
```
Sum of odd numbers up to 5: 9
```

---

### Example 2:
#### Input:
```
Enter a number N to calculate the sum of odd numbers up to N: 10
```
#### Execution:
1. Start: \( N = 10 \)  
2. Loop Steps:
   - \( i = 1 \), Sum = \( 0 + 1 = 1 \)
   - \( i = 3 \), Sum = \( 1 + 3 = 4 \)
   - \( i = 5 \), Sum = \( 4 + 5 = 9 \)
   - \( i = 7 \), Sum = \( 9 + 7 = 16 \)
   - \( i = 9 \), Sum = \( 16 + 9 = 25 \)  
3. Final Sum: \( 25 \)

#### Output:
```
Sum of odd numbers up to 10: 25
```

---

## 4️⃣ **Alternate Formula** 📋  
For odd numbers, the sum can also be calculated directly using a mathematical formula:
\[
\text{Sum} = \left(\frac{\text{Count of Odd Numbers} \times (\text{Smallest Odd Number} + \text{Largest Odd Number})}{2}\right)
\]
### Steps:
1. If \( N \) is odd: Use \( N \) as the largest odd number.  
2. If \( N \) is even: Use \( N - 1 \) as the largest odd number.  
3. Count the total odd numbers up to \( N \): \( \text{Count} = \frac{\text{Largest Odd Number} + 1}{2} \).  
4. Apply the formula.

For example:
- \( N = 10 \): Largest odd = 9. Count = \( 9 / 2 = 5 \).  
  \[
  \text{Sum} = \frac{5 \times (1 + 9)}{2} = 25
  \]

---

## 5️⃣ **Pseudo Code** 📝
```
1. Input a positive integer N.
2. Initialize sum = 0.
3. For each odd number i from 1 to N:
   a. Add i to sum.
4. Print the sum.
```

---

## 6️⃣ **Full Code** 💻
```java
import java.util.Scanner; // Import the Scanner class for user input

// File: SumOfOddNumbers.java
public class SumOfOddNumber {
    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a number N to calculate the sum of odd numbers up to N: ");
            int n = scanner.nextInt(); // Read the input
            
            int sum = 0; // Initialize sum to zero
            for (int i = 1; i <= n; i += 2) {
                sum += i; // Add odd numbers to the sum
            }
            // Display the result
            System.out.println("Sum of odd numbers up to " + n + ": " + sum);
        }
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍

### Time Complexity:
- **Loop Version**: \( O(n/2) = O(n) \), iterates through half the numbers.

### Space Complexity:
- \( O(1) \), as only a few variables are used.

---

## 8️⃣ **Key Takeaways** 🌟
1. Odd numbers follow a simple pattern: \( 1, 3, 5, ... \).  
2. Both iterative and formulaic approaches work for this problem.  
3. This program is beginner-friendly and a great example of loop-based calculations.

---
