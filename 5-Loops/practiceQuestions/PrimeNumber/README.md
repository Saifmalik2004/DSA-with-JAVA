# Prime Number Checker

## 1️⃣ **Problem Description**
Imagine you are a number wizard 🧙‍♂️ tasked with identifying **prime numbers**. A prime number is a special number that:

- Is greater than 1.
- Cannot be divided evenly by any number other than 1 and itself. ✨

For example:
- **2, 3, 5, 7, 11** are all prime numbers.
- **4, 6, 8, 9** are not prime because they can be divided by smaller numbers (like 2 or 3).

Your challenge is to write a program that checks if a number is prime or not! 🚀

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

### Check for Numbers Less Than or Equal to 1:
```java
if (number <= 1) {
    System.out.println(number + " is prime: false");
}
```
- Numbers less than or equal to 1 are **not prime**.

### Assume the Number is Prime:
```java
boolean isPrime = true; // Assume the number is prime
```
We start by assuming the number is prime and then test this assumption. 🧐

### Check for Divisors:
```java
for (int i = 2; i <= Math.sqrt(number); i++) {
    if (number % i == 0) {
        isPrime = false; // If divisible, not prime
        break;
    }
}
```
- We loop from `2` to the square root of the number (no need to check beyond this).
- If the number is divisible by `i`, it’s not prime, and we set `isPrime` to `false`.

### Display the Result:
```java
System.out.println(number + " is prime: " + isPrime);
```
This outputs whether the number is prime. 🎉

---

## 3️⃣ **Example Walkthrough** 🌟
### Input:
```
Enter a number: 17
```

### Step-by-Step Execution:
1. Original number = 17
2. \( \sqrt{17} \approx 4.12 \), so the loop checks divisors up to 4.
3. Check divisors:
   - \( 17 \% 2 \neq 0 \)
   - \( 17 \% 3 \neq 0 \)
   - \( 17 \% 4 \neq 0 \)
4. No divisors found, so **17 is prime**.

### Output:
```
17 is prime: true
```

---

## 4️⃣ **Approach** 💡
The solution works by:
1. Eliminating numbers less than or equal to 1 as non-prime.
2. Assuming the number is prime and then testing it by dividing it with numbers from 2 to its square root.
3. Breaking early if any divisor is found, making it efficient. 🔥

This approach avoids unnecessary computations and checks only what’s needed. ⚡

---

## 5️⃣ **Pseudo Code** 📝
Here’s a simplified version of the solution:
```
1. Take input number.
2. If number <= 1, print false.
3. Assume the number is prime.
4. Loop from 2 to sqrt(number):
    a. If number % i == 0, set isPrime = false and break.
5. Print whether the number is prime.
```

---

## 6️⃣ **Full Code with Comments** 🖥️💬
```java
import java.util.Scanner; // Import the Scanner class

// Explanation: A prime number is a natural number greater than 1 that cannot be formed by multiplying two smaller natural numbers.
// In other words, a prime number has only two factors: 1 and itself.

public class CheckPrime {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // Create a Scanner object to read input
            System.out.print("Enter a number: "); // Prompt user for input
            int number = scanner.nextInt(); // Read the number from user input
            
            if (number <= 1) {
                System.out.println(number + " is prime: false");  // Numbers less than 2 are not prime
            } else {
                boolean isPrime = true; // Assume the number is prime
                for (int i = 2; i <= Math.sqrt(number); i++) {  // Check divisibility
                    if (number % i == 0) {
                        isPrime = false; // If divisible, not prime
                        break;
                    }
                }
                System.out.println(number + " is prime: " + isPrime); // Display the result
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter valid integers.");
        }
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍
### Time Complexity:
- Checking divisors up to \( \sqrt{n} \): \( O(\sqrt{n}) \).

### Space Complexity:
- Uses constant extra space: \( O(1) \).

---

## 8️⃣ **Key Takeaways** 🚀
1. Prime numbers are fundamental in mathematics and computer science. ✨
2. Checking up to the square root reduces unnecessary computations. 🧠
3. Error handling ensures smooth user experience. 🛡️

Keep exploring new problems and improving your skills. You’re doing amazing! 💪😄

