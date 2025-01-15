

# Sum of Natural Numbers

## 1️⃣ **Problem Description**  
Natural numbers are positive integers starting from **1**.  
This program calculates the sum of the first **N** natural numbers using a loop or the formula:
\[
\text{Sum} = \frac{n(n + 1)}{2}
\]  
### Examples:
- For **N = 5**, the sum is \( 1 + 2 + 3 + 4 + 5 = 15 \).  
- For **N = 10**, the sum is \( 1 + 2 + 3 + ... + 10 = 55 \).

---

## 2️⃣ **Code Explanation** 🛠️

### Step-by-Step Process:
1. **Input a Number**:  
   The user is prompted to enter a positive integer \( N \).  
   ```java
   System.out.print("Enter a number N to calculate the sum of the first N natural numbers: ");
   int n = scanner.nextInt();
   ```

2. **Calculate the Sum**:  
   - Use a loop to iterate from \( 1 \) to \( N \), adding each number to the `sum` variable.  
   ```java
   int sum = 0; // Initialize sum to zero
   for (int i = 1; i <= n; i++) {
       sum += i; // Add each natural number to the sum
   }
   ```

3. **Display the Result**:  
   Once the loop completes, display the calculated sum.  
   ```java
   System.out.println("Sum of first " + n + " natural numbers: " + sum);
   ```

---

## 3️⃣ **Example Walkthrough** 🌟

### Example 1:
#### Input:
```
Enter a number N to calculate the sum of the first N natural numbers: 5
```
#### Execution:
1. Start: \( N = 5 \)  
2. Loop Steps:
   - \( i = 1 \), Sum = \( 0 + 1 = 1 \)
   - \( i = 2 \), Sum = \( 1 + 2 = 3 \)
   - \( i = 3 \), Sum = \( 3 + 3 = 6 \)
   - \( i = 4 \), Sum = \( 6 + 4 = 10 \)
   - \( i = 5 \), Sum = \( 10 + 5 = 15 \)  
3. Final Sum: \( 15 \)

#### Output:
```
Sum of first 5 natural numbers: 15
```

---

### Example 2:
#### Input:
```
Enter a number N to calculate the sum of the first N natural numbers: 10
```
#### Execution:
1. Start: \( N = 10 \)  
2. Loop Steps:
   - Add numbers from \( 1 \) to \( 10 \): \( 1 + 2 + 3 + ... + 10 = 55 \)  
3. Final Sum: \( 55 \)

#### Output:
```
Sum of first 10 natural numbers: 55
```

---

## 4️⃣ **Alternate Formula** 📋  
Instead of a loop, you can calculate the sum directly using the formula:
\[
\text{Sum} = \frac{n(n + 1)}{2}
\]
This approach avoids iteration and is faster for large values of \( N \). Replace the loop with:
```java
int sum = (n * (n + 1)) / 2;
```

---

## 5️⃣ **Pseudo Code** 📝
```
1. Input a positive integer N.
2. Initialize sum = 0.
3. For each number i from 1 to N:
   a. Add i to sum.
4. Print the sum.
```

---

## 6️⃣ **Full Code** 💻
```java
import java.util.Scanner; // Import the Scanner class for user input

/*
 * Explanation: 
 * Natural numbers are positive integers starting from 1. 
 * The sum of the first N natural numbers can be found using the formula 
 * n(n + 1) / 2 or by adding each number from 1 to N.
 */
public class SumOfNaturalNumbers {
    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a number N to calculate the sum of the first N natural numbers: ");
            int n = scanner.nextInt(); // Read the input
            
            int sum = 0; // Initialize sum to zero
            for (int i = 1; i <= n; i++) {
                sum += i; // Add each natural number to the sum
            }
            // Display the result
            System.out.println("Sum of first " + n + " natural numbers: " + sum);
        }
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍

### Time Complexity:
- **Loop Version**: \( O(n) \), as it iterates \( N \) times.
- **Formula Version**: \( O(1) \), as the computation is constant time.

### Space Complexity:
- Both versions: \( O(1) \), as only a few variables are used.

---

## 8️⃣ **Key Takeaways** 🌟
1. This program demonstrates a basic understanding of loops or mathematical formulas.  
2. It can handle large inputs efficiently using the formula method.  
3. Simple and beginner-friendly logic that builds the foundation for number-based problems.

---