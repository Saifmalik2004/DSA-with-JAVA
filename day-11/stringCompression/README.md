

# 📚 StringCompression - Compressing Consecutive Characters in a String

The `StringCompression` program compresses consecutive, repeating characters in a string by replacing them with the character followed by the count of its occurrences. This technique is often used to reduce the size of data, and it's an example of **basic string compression** in Java.

---

## 🧩 How It Works

1. **Initialize a StringBuilder**:
   - We use a `StringBuilder` to store the compressed string, as it’s more efficient for appending operations than `String`.

2. **Loop Through the String**:
   - For each character in the string, we initialize a `count` to `1`.
   - Using a `while` loop, we check if the next character is the same as the current one.
   - If it is, we increase `count` and move to the next character. This loop continues until a different character is found.

3. **Build the Compressed String**:
   - After counting the consecutive characters, we append the character to `newString`.
   - If the `count` is greater than `1`, we also append the count next to the character to indicate how many times it appeared consecutively.

4. **Return the Compressed Result**:
   - Finally, the method returns the compressed string, which is printed in the `main` method.

---

## 🔍 Code Explanation

### Class Definition

- **`public class StringCompression`**: This class contains the main logic for compressing strings.

### Method: `StringCompression`

- **`StringBuilder newString = new StringBuilder("");`**: Creates a `StringBuilder` to build the compressed string.

- **Outer Loop**: Loops through each character in `str`.

    - **Inner `while` Loop**: Counts consecutive repeating characters.
    - **`count++`**: Increments `count` if the next character matches the current one.
    
- **`newString.append(str.charAt(i))`**: Adds the current character to the compressed string.
  
- **`if (count > 1)`**: Adds the count only if it is greater than `1` to indicate repetition.

### Main Method

- **`String str = "aabbbaddd";`**: Example input string.
- **`System.out.println(StringCompression(str));`**: Prints the compressed result, which for this example would be `a2b3ad3`.

---

## 🔑 Example Output

For the input string `"aabbbaddd"`, the output will be:

```plaintext
a2b3ad3
```

This output represents the original string in a compressed format, where consecutive characters are shortened by showing the character followed by the number of occurrences.

---

## 🌟 Key Concepts

- **String Compression**: This code demonstrates a basic form of string compression, which is useful for reducing data size.
- **Efficient String Building**: Using `StringBuilder` enhances performance, especially for strings that require frequent appending.
  
Enjoy exploring more about string manipulation and efficient data handling in Java! 🎉