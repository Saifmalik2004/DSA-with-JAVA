

# Sum of Digits

## 1️⃣ **Problem Description**  
The sum of digits of a number is the total obtained by adding all the individual digits together.  
### Examples:  
- For **1234**, the sum of digits is \( 1 + 2 + 3 + 4 = 10 \).  
- For **987**, the sum is \( 9 + 8 + 7 = 24 \).  
This program calculates the sum of the digits of a number provided by the user.

---

## 2️⃣ **Code Explanation** 🛠️  

### Step-by-Step Process:

1. **Input a Number**:  
   The user is prompted to enter an integer.  
   ```java
   System.out.print("Enter a number to calculate the sum of its digits: ");
   int number = scanner.nextInt();
   ```

2. **Calculate the Sum of Digits**:  
   - Extract the last digit of the number using the modulus operator `%`.  
   - Add the digit to the `sum` variable.  
   - Remove the last digit by dividing the number by 10 (`/=` operator).  
   - Repeat the process until the number becomes 0.  
   ```java
   while (number != 0) {
       sum += number % 10;  // Add the last digit to the sum
       number /= 10;        // Remove the last digit
   }
   ```

3. **Display the Result**:  
   Once the loop is complete, the final sum is displayed.  
   ```java
   System.out.println("Sum of digits: " + sum);
   ```

---

## 3️⃣ **Example Walkthrough** 🌟

### Example 1:
#### Input:
```
Enter a number to calculate the sum of its digits: 1234
```
#### Execution:
1. Initial Number: \( 1234 \)  
2. Steps:
   - Extract 4 → Sum: \( 0 + 4 = 4 \), Remaining: \( 123 \)
   - Extract 3 → Sum: \( 4 + 3 = 7 \), Remaining: \( 12 \)
   - Extract 2 → Sum: \( 7 + 2 = 9 \), Remaining: \( 1 \)
   - Extract 1 → Sum: \( 9 + 1 = 10 \), Remaining: \( 0 \)  
3. Final Sum: \( 10 \)

#### Output:
```
Sum of digits: 10
```

---

### Example 2:
#### Input:
```
Enter a number to calculate the sum of its digits: 987
```
#### Execution:
1. Initial Number: \( 987 \)  
2. Steps:
   - Extract 7 → Sum: \( 0 + 7 = 7 \), Remaining: \( 98 \)
   - Extract 8 → Sum: \( 7 + 8 = 15 \), Remaining: \( 9 \)
   - Extract 9 → Sum: \( 15 + 9 = 24 \), Remaining: \( 0 \)  
3. Final Sum: \( 24 \)

#### Output:
```
Sum of digits: 24
```

---

### Example 3:
#### Input:
```
Enter a number to calculate the sum of its digits: 5000
```
#### Execution:
1. Initial Number: \( 5000 \)  
2. Steps:
   - Extract 0 → Sum: \( 0 + 0 = 0 \), Remaining: \( 500 \)
   - Extract 0 → Sum: \( 0 + 0 = 0 \), Remaining: \( 50 \)
   - Extract 0 → Sum: \( 0 + 0 = 0 \), Remaining: \( 5 \)
   - Extract 5 → Sum: \( 0 + 5 = 5 \), Remaining: \( 0 \)  
3. Final Sum: \( 5 \)

#### Output:
```
Sum of digits: 5
```

---

## 4️⃣ **Pseudo Code** 📝
```
1. Input a number.
2. Initialize sum = 0.
3. Repeat while the number is not 0:
   a. Extract the last digit: digit = number % 10.
   b. Add digit to sum: sum = sum + digit.
   c. Remove the last digit: number = number / 10.
4. Print the sum.
```

---

## 5️⃣ **Full Code** 💻
```java
import java.util.Scanner; // Import the Scanner class for user input

// Explanation: The sum of digits of a number is simply adding all the individual digits together. 
// For example, for the number 1234, the sum is 1 + 2 + 3 + 4 = 10.
public class SumOfDigits {
    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a number to calculate the sum of its digits: ");
            int number = scanner.nextInt(); // Read the input
            
            int sum = 0; // Initialize sum to zero
            while (number != 0) {
                sum += number % 10; // Add the last digit to the sum
                number /= 10; // Remove the last digit from the number
            }
            // Display the result
            System.out.println("Sum of digits: " + sum);
        }
    }
}
```

---

## 6️⃣ **Complexity Analysis** 🔍

### Time Complexity:
- **\( O(d) \)**: The loop runs once for each digit of the number (\( d \)).

### Space Complexity:
- **\( O(1) \)**: Only a few variables are used, so additional space is constant.

---

## 7️⃣ **Key Takeaways** 🌟
1. This program calculates the sum of digits efficiently using basic arithmetic operations.  
2. It handles both positive and negative numbers seamlessly (sum of digits ignores the sign).  
3. Simple logic and reusable for similar problems, such as digital root calculation.

