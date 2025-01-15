
# Reverse Number

## 1️⃣ **Problem Description**
Reversing a number involves reversing its digits. For example:
- Reverse of **12345** → **54321**  
- Reverse of **4000** → **4**  
- Reverse of **-789** → **-987**

This program calculates the **reverse** of a number entered by the user.

---

## 2️⃣ **Code Explanation** 🛠️

### Step-by-Step Process:

1. **Input a Number**:  
   The user is prompted to input an integer.  
   ```java
   System.out.print("Enter a number to reverse: ");
   int num = scanner.nextInt();
   ```

2. **Reverse the Number**:
   - Extract the last digit of the number using the modulus operator `%`.
   - Add the digit to the reversed number, shifting the existing digits left by multiplying the reversed number by 10.
   - Remove the last digit from the number using integer division `/`.  
   - Repeat the process until all digits are reversed.
   ```java
   while (num != 0) {
       int digit = num % 10;        // Extract the last digit
       reversed = reversed * 10 + digit;  // Build the reversed number
       num /= 10;                  // Remove the last digit
   }
   ```

3. **Display the Result**:  
   After the loop completes, the reversed number is printed.  
   ```java
   System.out.println("Reversed number: " + reversed);
   ```

---

## 3️⃣ **Example Walkthrough** 🌟

### Example 1:
#### Input:
```
Enter a number to reverse: 12345
```
#### Execution:
1. Initial Number: \( 12345 \)  
2. Steps:
   - Extract 5 → Reverse: \( 0 \times 10 + 5 = 5 \), Remaining: \( 1234 \)
   - Extract 4 → Reverse: \( 5 \times 10 + 4 = 54 \), Remaining: \( 123 \)
   - Extract 3 → Reverse: \( 54 \times 10 + 3 = 543 \), Remaining: \( 12 \)
   - Extract 2 → Reverse: \( 543 \times 10 + 2 = 5432 \), Remaining: \( 1 \)
   - Extract 1 → Reverse: \( 5432 \times 10 + 1 = 54321 \), Remaining: \( 0 \)  
3. Reversed Number: \( 54321 \)

#### Output:
```
Reversed number: 54321
```

---

### Example 2:
#### Input:
```
Enter a number to reverse: 4000
```
#### Execution:
1. Initial Number: \( 4000 \)  
2. Steps:
   - Extract 0 → Reverse: \( 0 \times 10 + 0 = 0 \), Remaining: \( 400 \)
   - Extract 0 → Reverse: \( 0 \times 10 + 0 = 0 \), Remaining: \( 40 \)
   - Extract 0 → Reverse: \( 0 \times 10 + 0 = 0 \), Remaining: \( 4 \)
   - Extract 4 → Reverse: \( 0 \times 10 + 4 = 4 \), Remaining: \( 0 \)  
3. Reversed Number: \( 4 \)

#### Output:
```
Reversed number: 4
```

---

### Example 3:
#### Input:
```
Enter a number to reverse: -789
```
#### Execution:
1. Initial Number: \( -789 \)  
2. Steps:
   - Extract -9 → Reverse: \( 0 \times 10 + (-9) = -9 \), Remaining: \( -78 \)
   - Extract -8 → Reverse: \( -9 \times 10 + (-8) = -98 \), Remaining: \( -7 \)
   - Extract -7 → Reverse: \( -98 \times 10 + (-7) = -987 \), Remaining: \( 0 \)  
3. Reversed Number: \( -987 \)

#### Output:
```
Reversed number: -987
```

---

## 4️⃣ **Pseudo Code** 📝
```
1. Input a number.
2. Initialize reversed = 0.
3. Repeat while the number is not 0:
   a. Extract the last digit: digit = num % 10.
   b. Add digit to reversed: reversed = reversed * 10 + digit.
   c. Remove the last digit: num = num / 10.
4. Print the reversed number.
```

---

## 5️⃣ **Full Code** 💻
```java
import java.util.Scanner; // Import the Scanner class for user input

// Explanation: Reversing a number involves reversing its digits. 
// For example, the reverse of 12345 is 54321. This can be done by extracting the last digit repeatedly.
public class ReverseNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number to reverse: "); // Prompt user for input
            int num = scanner.nextInt(); // Read the input
            
            int reversed = 0; // Variable to store the reversed number
            // Reverse the number by extracting digits
            while (num != 0) {
                int digit = num % 10; // Get the last digit
                reversed = reversed * 10 + digit; // Build the reversed number
                num /= 10; // Remove the last digit
            }
            System.out.println("Reversed number: " + reversed); // Display the reversed number
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
1. The algorithm efficiently reverses the number by processing one digit at a time.  
2. Works with both positive and negative numbers.  
3. Handles cases where numbers end with zero (e.g., \( 4000 \to 4 \)) seamlessly.

---
