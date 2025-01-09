

# Count Vowels and Consonants

## Problem Statement

Write a function that counts the number of vowels and consonants in a given string. The function should consider only alphabetic characters (a-z), ignoring any non-alphabetic characters.

### Example

- **Input**: `"hello"`
- **Output**: `Vowels: 2, Consonants: 3`

## Approach

To solve this problem, we can loop through each character in the input string and check if it is a vowel or a consonant. We keep two counters, one for vowels and one for consonants, and update them as we encounter each character.

### Steps to Solve the Problem

1. **Initialize Counters**: Create two counters, `vowels` and `consonants`, both initially set to 0.
  
2. **Convert to Lowercase**: Convert the input string to lowercase to ensure that case differences (e.g., 'A' vs 'a') do not affect counting.

3. **Loop Through Each Character**:
   - For each character, check if it is a vowel by seeing if it exists in the string `"aeiou"`.
   - If it is a vowel, increment the `vowels` counter.
   - If it’s an alphabetic character but not a vowel, increment the `consonants` counter.

4. **Ignore Non-Alphabet Characters**: If a character is not between `'a'` and `'z'`, we skip counting it.

5. **Print the Results**: After counting, print the total vowels and consonants.

### Code

```java
public class CountVowel {
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;  // Counters for vowels and consonants
        str = str.toLowerCase();  // Convert string to lowercase

        for (char c : str.toCharArray()) {  // Loop through each character
            if ("aeiou".indexOf(c) >= 0) {  // Check if the character is a vowel
                vowels++;
            } else if (c >= 'a' && c <= 'z') {  // Check if the character is a consonant
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    public static void main(String[] args) {
        String input = "hello";
        countVowelsAndConsonants(input);  // Output: Vowels: 2, Consonants: 3
    }
}
```

### Explanation of Key Parts

1. **Lowercase Conversion**: The function starts by converting the input string to lowercase to make the vowel check simple and case-insensitive.

2. **Character Check**:
   - The line `if ("aeiou".indexOf(c) >= 0)` checks if `c` is a vowel by using the `indexOf` method on the string `"aeiou"`.
   - If `indexOf` returns `-1`, the character is not in `"aeiou"` and is therefore not a vowel.
   - If the character is a letter but not a vowel (between `'a'` and `'z'`), it is considered a consonant.

3. **Non-Alphabetic Characters**: Non-alphabetic characters (such as numbers, spaces, or punctuation) are ignored because they do not fall between `'a'` and `'z'`.

### Complexity Analysis

- **Time Complexity**: `O(n)`, where `n` is the length of the input string, because we only loop through the string once.
- **Space Complexity**: `O(1)`, as we are only using a few variables for counting and no extra data structures.

### Example Walkthrough

For input `"hello"`:

1. Convert to lowercase: `"hello"`
2. Iterate through each character:
   - `'h'`: Consonant → Consonants count becomes 1.
   - `'e'`: Vowel → Vowels count becomes 1.
   - `'l'`: Consonant → Consonants count becomes 2.
   - `'l'`: Consonant → Consonants count becomes 3.
   - `'o'`: Vowel → Vowels count becomes 2.
3. Final output: `Vowels: 2, Consonants: 3`

## Conclusion

This solution efficiently counts vowels and consonants in a string by leveraging simple conditions to identify vowel and consonant characters. It’s optimal for interview scenarios requiring basic string processing and is easy to understand and implement.