
# Fibonacci Sequence Generator

## 1️⃣ **Problem Description**
The **Fibonacci sequence** is a series of numbers where:
- Each number is the sum of the two preceding ones.
- The sequence starts with \( 0 \) and \( 1 \).

### Example Sequence:
\( 0, 1, 1, 2, 3, 5, 8, 13, 21, \dots \)

This program generates and displays the first \( n \) terms of the Fibonacci sequence. 🚀

---

## 2️⃣ **How It Works**

### Fibonacci Formula:
For \( n \geq 3 \):
\[
F(n) = F(n-1) + F(n-2)
\]
Where:
- \( F(1) = 0 \)
- \( F(2) = 1 \)

---

## 3️⃣ **Code Explanation** 🛠️

### Input Validation:
```java
if (n <= 0) {
    System.out.println("Please enter a positive integer greater than 0.");
}
```
The program ensures the input \( n \) is a **positive integer**. If not, it prompts the user to enter a valid value.

### Initialization:
```java
int a = 0, b = 1;
System.out.print(a + " " + b + " ");
```
- The first two numbers of the Fibonacci sequence (\( 0 \) and \( 1 \)) are printed directly.

### Iterative Calculation:
```java
for (int i = 3; i <= n; i++) {
    int next = a + b;
    System.out.print(next + " ");
    a = b;
    b = next;
}
```
- The loop starts from the 3rd term and calculates each subsequent Fibonacci number as the sum of the previous two numbers.
- The program updates the values of \( a \) and \( b \) in each iteration.

### Error Handling:
```java
catch (Exception e) {
    System.out.println("Invalid input! Please enter a valid integer.");
}
```
If the user enters an invalid input (e.g., text instead of a number), the program handles the error gracefully by displaying a message.

---

## 4️⃣ **Example Walkthrough** 🌟

### Example 1:
#### Input:
```
Enter the number of terms in the Fibonacci sequence to display: 7
```
#### Execution:
1. Print: \( 0, 1 \)
2. Calculate next terms:
   - \( 0 + 1 = 1 \)
   - \( 1 + 1 = 2 \)
   - \( 1 + 2 = 3 \)
   - \( 2 + 3 = 5 \)
   - \( 3 + 5 = 8 \)
3. Output the sequence.

#### Output:
```
0 1 1 2 3 5 8
```

### Example 2:
#### Input:
```
Enter the number of terms in the Fibonacci sequence to display: -3
```
#### Output:
```
Please enter a positive integer greater than 0.
```

### Example 3:
#### Input:
```
Enter the number of terms in the Fibonacci sequence to display: 1
```
#### Output:
```
0
```

---

## 5️⃣ **Pseudo Code** 📝
```
1. Input a positive integer (n).
2. If n <= 0, display an error message.
3. Initialize:
   a = 0, b = 1
4. Print a and b.
5. Loop from i = 3 to n:
   a. Calculate next = a + b
   b. Print next
   c. Update a = b, b = next
```

---

## 6️⃣ **Full Code** 💻
```java
import java.util.Scanner; // Import the Scanner class for user input

/*
 * Explanation: The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones,
 * usually starting with 0 and 1.
 * For example, the sequence begins: 0, 1, 1, 2, 3, 5, 8, etc.
 */
public class Fibonacci {
    // Executor to test the function
    public static void main(String[] args) {
        // Try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter the number of terms in the Fibonacci sequence to display: ");
            int n = scanner.nextInt(); // Read the number of terms
            
            // Check if the input is valid (greater than 0)
            if (n <= 0) {
                System.out.println("Please enter a positive integer greater than 0.");
            } else {
                // Print the first two numbers of the Fibonacci sequence
                int a = 0, b = 1;
                System.out.print(a + " " + b + " ");
                
                // Generate and print the Fibonacci sequence up to n terms
                for (int i = 3; i <= n; i++) {
                    int next = a + b; // Calculate next Fibonacci number
                    System.out.print(next + " "); // Print the next number
                    a = b; // Update a and b for the next iteration
                    b = next;
                }
            }
        } catch (Exception e) {
            // Handle invalid input by displaying an error message
            System.out.println("Invalid input! Please enter a valid integer.");
        }
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍

### Time Complexity:
- **\( O(n) \)**: The program performs \( n-2 \) iterations for \( n \) terms.

### Space Complexity:
- **\( O(1) \)**: The program uses a constant amount of memory for variables \( a \), \( b \), and \( next \).

---

## 8️⃣ **Key Takeaways** 🌟
1. The Fibonacci sequence has numerous applications in mathematics and computer science. 📊
2. Input validation ensures the program handles invalid cases gracefully. 🛡️
3. Iterative methods are efficient for generating sequences. ✨

