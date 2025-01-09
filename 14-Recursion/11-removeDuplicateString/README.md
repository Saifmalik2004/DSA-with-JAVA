

# 🚀 RemoveDuplicateStr - Remove Duplicates from a String in Java 🚀

Welcome! This Java program helps you remove duplicate characters from a string in the order they first appear. It uses recursion to build a new string, checking each character and adding it only once. Let’s dive in! 🕵️‍♂️

### 📝 Problem Explanation

Given a string, our goal is to:
1. **Remove duplicate characters** so each character appears only once.
2. **Maintain the order** in which characters appear.

### 📂 Code Structure

```java
public class RemoveDuplicateStr {
    public static void removeDuplicateStr(String str, StringBuilder newstr, int idx, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newstr);  // 🎉 Print the result when we reach the end
            return;
        }
        char current = str.charAt(idx);  // 🕹 Get the current character
        if (map[current - 'a']) {  // 🤔 Check if character is already used
            removeDuplicateStr(str, newstr, idx + 1, map);  // ➡️ Skip it if it's a duplicate
        } else {
            map[current - 'a'] = true;  // ✅ Mark character as used
            removeDuplicateStr(str, newstr.append(current), idx + 1, map);  // ➕ Add unique character
        }
    }

    public static void main(String[] args) {
        String str = "saifmalik";
        removeDuplicateStr(str, new StringBuilder(""), 0, new boolean[26]);  // 🚀 Start recursion
    }
}
```

### 🌱 Explanation

The program uses a `boolean[] map` array to track if a character has already been added to `newstr`. Here’s how each parameter works:
- `str`: Original string.
- `newstr`: The string we're building with unique characters.
- `idx`: The index we’re currently looking at in `str`.
- `map[]`: A boolean array that keeps track of which letters (from 'a' to 'z') have already been added.

Each time we add a character, we mark it as `true` in `map` to make sure it doesn’t get added again.

### 🔍 Dry Run with Example

Let’s take the input `"saifmalik"` and go through it step-by-step.

**Input**: `str = "saifmalik"`

#### Step-by-Step Execution 🛠

1. **`idx = 0, current = 's'`**  
   - `'s'` is not in `newstr`, so add it!  
   - `newstr = "s"` and update `map['s' - 'a'] = true`.

2. **`idx = 1, current = 'a'`**  
   - `'a'` is new, so add it!  
   - `newstr = "sa"` and update `map['a' - 'a'] = true`.

3. **`idx = 2, current = 'i'`**  
   - `'i'` is new, so add it!  
   - `newstr = "sai"` and update `map['i' - 'a'] = true`.

4. **`idx = 3, current = 'f'`**  
   - `'f'` is new, so add it!  
   - `newstr = "saif"` and update `map['f' - 'a'] = true`.

5. **`idx = 4, current = 'm'`**  
   - `'m'` is new, so add it!  
   - `newstr = "saifm"` and update `map['m' - 'a'] = true`.

6. **`idx = 5, current = 'a'`**  
   - `'a'` is already added, so skip it.

7. **`idx = 6, current = 'l'`**  
   - `'l'` is new, so add it!  
   - `newstr = "saifml"` and update `map['l' - 'a'] = true`.

8. **`idx = 7, current = 'i'`**  
   - `'i'` is already added, so skip it.

9. **`idx = 8, current = 'k'`**  
   - `'k'` is new, so add it!  
   - `newstr = "saifmlk"` and update `map['k' - 'a'] = true`.

Finally, we reach the end of the string, and **`newstr = "saifmlk"`** is printed as the result. 🎉

### ⏳ Time and Space Complexity

- **Time Complexity**: **O(n)**, where `n` is the length of the input string. We go through each character only once.
- **Space Complexity**: **O(n)** for the `newstr` `StringBuilder` and **O(1)** for the `map` array (since it’s a fixed size of 26 for lowercase letters).

### 🧪 Example Outputs

For various inputs, here’s what you get:
- Input: `"saifmalik"` → Output: `"saifmlk"`
- Input: `"hello"` → Output: `"helo"`
- Input: `"aabbcc"` → Output: `"abc"`

---

And that's it! 🎉 Now you understand how the recursion removes duplicates while keeping character order intact. Enjoy coding! ✨