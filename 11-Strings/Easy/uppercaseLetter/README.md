

# 📜 UppercaseLetter - Capitalize the First Letter of Each Word

The `UppercaseLetter` program in Java capitalizes the first letter of each word in a given string, simulating title case formatting. It effectively identifies the start of each word and converts its first letter to uppercase, using `StringBuilder` for efficient string manipulation.

---

## 🚀 How It Works

1. **Initialize `StringBuilder`**:
   - We use a `StringBuilder` to build the result since appending characters is more efficient with `StringBuilder` than with `String`.

2. **Capitalize the First Character**:
   - The first character is always capitalized since it is the start of the first word in the string.
   - `Character.toUpperCase` is used to convert this character to uppercase.

3. **Iterate Through the String**:
   - For each character in the string, we check for spaces (`' '`), as they mark the end of a word.
   - If a space is found, we append it as-is and move to the next character.
   - The character immediately following the space is then capitalized as it’s the start of a new word.

4. **Build the Final String**:
   - All other characters that aren’t at the start of a word are appended as-is.
   - After iterating through the string, `StringBuilder` is converted to a string and returned as the final result.

---

## 🔍 Code Explanation

### Class and Method

- **`public class UppercaseLetter`**: This class contains the main logic for converting a string to title case.
- **`public static String uppercaseLetter(String str)`**: This method accepts a string and returns it with the first letter of each word capitalized.

### Method Details

- **`Character.toUpperCase(str.charAt(0))`**: Capitalizes the first character.
- **Loop**: Iterates through the rest of the string:
  - **`if (str.charAt(i) == ' ' && i < str.length() - 1)`**: Checks for a space, then skips to the next character.
  - **`sb.append(Character.toUpperCase(str.charAt(i)))`**: Capitalizes the character after the space.
  - **`sb.append(str.charAt(i))`**: Appends all other characters as they are.

### Main Method

- **`String str = "my name is saif malik ";`**: Example string.
- **`System.out.println(uppercaseLetter(str));`**: Prints the capitalized result, which will output `My Name Is Saif Malik`.

---

## 🔑 Example Output

For the input string `"my name is saif malik "`, the output will be:

```plaintext
My Name Is Saif Malik
```

---

## 🌟 Key Concepts

- **String Manipulation**: Demonstrates how to efficiently modify strings by using `StringBuilder`.
- **Conditional Capitalization**: Shows how to identify word boundaries and apply capitalization only where necessary.
  
Feel free to experiment with other sentences to see the title case transformation in action! 🎉