
# PalindromeString Program

This is a simple Java program that checks if a given string is a palindrome. A **palindrome** is a word, phrase, or sequence that reads the same backward as forward, such as "madam" or "racecar".

## Table of Contents
- [How It Works](#how-it-works)
- [Code Explanation](#code-explanation)
- [Usage](#usage)
- [Examples](#examples)

## How It Works
The program defines a method `checkPalindrome` that takes a string as input and checks if it is a palindrome by comparing characters from the beginning and end of the string, moving towards the center. If any characters don't match, the function returns `false`, meaning the string is not a palindrome. If all characters match, the function returns `true`, confirming the string is a palindrome.

## Code Explanation

### `PalindromeString` Class
This class contains:
- A static method, `checkPalindrome`, which performs the palindrome check.
- A `main` method, which initializes a sample string and calls `checkPalindrome` to check if it's a palindrome.

### `checkPalindrome` Method
1. **Loop**: The method iterates through the first half of the string, comparing each character from the start and the end.
2. **Comparison**: For each character at index `i`, it compares it with the character at `str.length() - i - 1`.
3. **Condition**:
   - If any characters don't match, the method prints "not palindrome" and returns `false`.
   - If all characters match, the method prints "palindrome" and returns `true`.

### `main` Method
- **Initialization**: Declares a string, `str`, with a sample value.
- **Method Call**: Calls `checkPalindrome(str)` to determine if the given string is a palindrome.

## Usage
To use this program:
1. Copy the code into a file named `PalindromeString.java`.
2. Run the program from the command line or an IDE.
3. Update the value of `str` in the `main` method to check different strings for being palindromes.

### Example Code
```java
public class PalindromeString {
    public static boolean checkPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                System.err.println("not palindrome");
                return false;
            }
        }
        System.err.println("palindrome");
        return true;
    }

    public static void main(String[] args) {
        String str = "saas";
        checkPalindrome(str);
    }
}
```

## Examples
| Input      | Output           |
|------------|-------------------|
| `"saas"`   | `palindrome`      |
| `"hello"`  | `not palindrome`  |
| `"madam"`  | `palindrome`      |
| `"abcba"`  | `palindrome`      |

## Notes
- This program is case-sensitive. For example, "Madam" would not be considered a palindrome.
- The program can be modified to ignore case by converting the string to lowercase: `str = str.toLowerCase();`.

