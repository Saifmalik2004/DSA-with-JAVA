# Count Vowels in a String

## 1⃣ **Problem Description**

Vowels are the letters **A, E, I, O, U** (both uppercase and lowercase). Your task is to write a program that counts the total number of vowels in a given string. 🌟

For example:
- Input: "Hello World"
  - Vowels: e, o, o
  - **Output: 3**

- Input: "Programming"
  - Vowels: o, a, i
  - **Output: 3**

---

## 2⃣ **Step-by-Step Explanation of the Code**

### Import Scanner for Input
```java
import java.util.Scanner; // Import the Scanner class for user input
```
This allows us to take input from the user.

### Prompt for Input
```java
System.out.print("Enter a string to count its vowels: ");
String text = scanner.nextLine();
```
We prompt the user to enter a string and store it in the variable `text`.

### Initialize Vowel Count
```java
int count = 0; // Initialize count of vowels to zero
```
We use a variable `count` to keep track of the number of vowels.

### Loop Through the String
```java
for (int i = 0; i < text.length(); i++) {
    char ch = text.charAt(i); // Get the character at the current index
```
This loop iterates through each character of the string using its index.

### Check for Vowels
```java
if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
    ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
    count++; // Increment count for each vowel found
}
```
We check if the current character is a vowel (both uppercase and lowercase). If it is, we increment the count.

### Display the Result
```java
System.out.println("Number of vowels: " + count);
```
Finally, we print the total number of vowels found in the string. 🎉

---

## 3⃣ **Example Walkthrough**

### Input:
```
Enter a string to count its vowels: Java Programming
```

### Step-by-Step Execution:
1. String = "Java Programming"
2. Check each character:
   - 'J' = Not a vowel
   - 'a' = Vowel, count = 1
   - 'v' = Not a vowel
   - 'a' = Vowel, count = 2
   - ' ' (space) = Not a vowel
   - 'P' = Not a vowel
   - 'r' = Not a vowel
   - 'o' = Vowel, count = 3
   - 'g' = Not a vowel
   - 'r' = Not a vowel
   - 'a' = Vowel, count = 4
   - 'm' = Not a vowel
   - 'i' = Vowel, count = 5
   - 'n' = Not a vowel
   - 'g' = Not a vowel
3. Total vowels = 5

### Output:
```
Number of vowels: 5
```

---

## 4⃣ **Approach**
The program works by:
1. Looping through every character in the string.
2. Checking if each character is a vowel.
3. Keeping a running count of all the vowels encountered.

This is a straightforward and efficient way to count vowels in any given string. ✅

---

## 5⃣ **Pseudo Code**
Here’s a simplified version of the solution:
```
1. Take input string.
2. Initialize count to 0.
3. For each character in the string:
    a. If character is a vowel (A, E, I, O, U):
        i. Increment count.
4. Print the total count of vowels.
```

---

## 6⃣ **Full Code with Comments**
```java
import java.util.Scanner; // Import the Scanner class for user input

// Explanation: Vowels are the letters A, E, I, O, U (and sometimes Y). Counting the vowels in a string involves checking each character to see if it is a vowel.

public class CountVowels {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string to count its vowels: "); // Prompt user for input
            String text = scanner.nextLine(); // Read the input string
            
            int count = 0; // Initialize count of vowels to zero
            // Loop through each character in the string
            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i); // Get the character at the current index
                // Check if the character is a vowel (both uppercase and lowercase)
                if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
                    ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++; // Increment count for each vowel found
                }
            }
            System.out.println("Number of vowels: " + count); // Display the count of vowels
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid string.");
        }
    }
}
```

---

## 7⃣ **Complexity Analysis**

### Time Complexity:
- **O(n)**: The program loops through each character of the string exactly once, where `n` is the length of the string.

### Space Complexity:
- **O(1)**: Uses a constant amount of extra space for the counter.

---

## 8⃣ **Key Takeaways**
1. String operations like character traversal are straightforward in Java. 🧵
2. Logical checks for vowels can easily handle both uppercase and lowercase letters. 🔤
3. Error handling ensures the program works smoothly for user input. 🛡️

Keep practicing and experimenting! Happy coding! 🚀

