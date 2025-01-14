# Count Digits in a Number

## 1️⃣ **Problem Description**
Have you ever wondered how many digits a number has? 🤔 Let’s solve this fun challenge! Counting digits is as simple as repeatedly dividing the number by 10 until it becomes 0. 

For example:
- **123** has 3 digits.
- **78945** has 5 digits.
- Even negative numbers like **-456** are counted as 3 digits! 🧮

Your task is to write a program that counts the digits in a given number. 🚀

---

## 2️⃣ **Step-by-Step Explanation of the Code** 🛠️
Let’s break it down:

### Import Scanner for Input:
```java
import java.util.Scanner; // Import the Scanner class for user input
```
This allows us to take input from the user. 🎤

### Read the Number:
```java
System.out.print("Enter a number: ");
int number = Math.abs(scanner.nextInt()); // Get absolute value of the number
```
- We prompt the user to enter a number.
- Convert the number to its absolute value to handle negatives. 🔢

### Count the Digits:
```java
int count = 0;
do {
    count++;
    number /= 10; // Remove the last digit
} while (number != 0);
```
- Start with `count = 0`.
- Use a `do-while` loop to ensure the code runs at least once, even for single-digit numbers.
- Keep dividing the number by 10 and increment the count until the number becomes 0. 🔄

### Display the Result:
```java
System.out.println("Number of digits: " + count);
```
Finally, print the total count. 🎉

---

## 3️⃣ **Example Walkthrough** 🌟
### Input:
```
Enter a number: 789
```

### Step-by-Step Execution:
1. Original number = 789
2. Convert to absolute value (already positive).
3. Loop:
   - Count = 1, Number = 78
   - Count = 2, Number = 7
   - Count = 3, Number = 0 (loop ends)
4. Output: **Number of digits: 3**

---

## 4️⃣ **Approach** 💡
The solution works by:
1. Converting the number to an absolute value to handle negatives.
2. Using a `do-while` loop to count the digits by dividing the number by 10 repeatedly.

This approach ensures simplicity and works for any integer input! 🧠

---

## 5️⃣ **Pseudo Code** 📝
Here’s a simplified version:
```
1. Take input number.
2. Convert number to absolute value.
3. Initialize count = 0.
4. Do the following while number != 0:
    a. Increment count.
    b. Divide number by 10.
5. Print count.
```

---

## 6️⃣ **Full Code with Comments** 🖥️💬
```java
import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner for input
        System.out.print("Enter a number: ");
        int number = Math.abs(scanner.nextInt()); // Get absolute value of the number
        int count = 0;

        do {
            count++;
            number /= 10; // Remove last digit
        } while (number != 0);

        System.out.println("Number of digits: " + count); // Display the count
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍
### Time Complexity:
- Dividing the number by 10 takes \( O(d) \), where \( d \) is the number of digits.

### Space Complexity:
- Uses constant extra space: \( O(1) \).

---

## 8️⃣ **Key Takeaways** 🚀
1. Negative numbers are handled by converting to absolute value. 👍
2. A `do-while` loop is perfect for counting digits, as it ensures at least one iteration. 🔄
3. Simple logic can solve seemingly tricky problems! 🧠

Keep practicing and building your coding skills. You’ve got this! 💪😄

