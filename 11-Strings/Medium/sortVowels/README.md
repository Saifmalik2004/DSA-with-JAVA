
# 📝 Sort Vowels in a String

## 📌 Problem Statement
You are given a string `s`.  
Your task is to **sort all the vowels in the string** in ascending order (based on their ASCII values),  
while keeping **all consonants in the same position**.

The vowels should be sorted **case-sensitively**, meaning:
- `'A' < 'E' < 'I' < 'O' < 'U' < 'a' < 'e' < 'i' < 'o' < 'u'`
- Uppercase vowels come before lowercase vowels due to ASCII values.

Return the resulting string after sorting the vowels.

---

## 🔍 Example

### Example 1:
**Input**  
```

s = "leetcode"

```
**Output**  
```

"leotcede"

```
**Explanation**  
- Vowels in `leetcode` → `e`, `e`, `o`, `e`  
- Sorted → `e`, `e`, `e`, `o`  
- Replace them in original vowel positions → `"leotcede"`

---

### Example 2:
**Input**  
```

s = "AEIOUxyz"

```
**Output**  
```

"AEIOUxyz"

````
**Explanation**  
- Vowels are already in sorted order, so no change.

---

## 💡 Intuition
The core idea is:
1. Identify vowels in the string.
2. Extract and sort them.
3. Put them back in the same vowel positions.

Since consonants remain untouched, we can just replace vowels in their respective locations after sorting.

---

## 🛠 Steps / Pseudocode
```plaintext
1. Create a set of vowels for quick lookup.
2. Convert string into a mutable structure (StringBuilder).
3. Iterate over the string:
    - If character is a vowel → replace with space (' '), store vowel in a separate list.
4. Sort the collected vowels.
5. Iterate over the StringBuilder:
    - If current char is space → replace with next vowel from sorted list.
6. Return the updated string.
````

---

## 🧮 Complexity Analysis

* **Time Complexity**

  * Extracting vowels → O(n)
  * Sorting vowels → O(m log m) (where m = number of vowels ≤ n)
  * Replacing vowels → O(n)
  * **Total** → O(n + m log m) ≈ O(n log n) in worst case.
* **Space Complexity**

  * O(m) for storing vowels.
  * O(1) extra space for in-place replacement (excluding input/output).

---

## 📄 Java Implementation

```java
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public String sortVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder vowels = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        // Add vowels to the set
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');

        // Step 1: Collect vowels and mark their positions with spaces
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (set.contains(Character.toLowerCase(ch))) {
                str.setCharAt(i, ' '); // placeholder
                vowels.append(ch);
            }
        }

        // Step 2: Sort the collected vowels
        char[] sortedV = vowels.toString().toCharArray();
        Arrays.sort(sortedV);

        // Step 3: Place sorted vowels back into the string
        int i = 0, j = 0;
        while (i < str.length() && j < sortedV.length) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(i, sortedV[j++]);
            }
            i++;
        }
        return str.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        String input1 = "leetcode";
        String input2 = "AEIOUxyz";
        String input3 = "programming";

        System.out.println("Original: " + input1 + " -> Sorted vowels: " + sol.sortVowels(input1));
        System.out.println("Original: " + input2 + " -> Sorted vowels: " + sol.sortVowels(input2));
        System.out.println("Original: " + input3 + " -> Sorted vowels: " + sol.sortVowels(input3));
    }
}
```

---

## 📌 Why This Works

* **Using `HashSet`** makes vowel lookup O(1) time.
* **Using `StringBuilder`** allows in-place modification without creating new strings repeatedly.
* Sorting only the vowels keeps the rest of the string intact.
* Placeholders (`' '`) make it easy to replace vowels later in order.

---

## 🔄 Possible Variations

1. **Sort in descending order**
   Reverse the sorted vowel array before inserting back.
2. **Case-insensitive sorting**
   Convert all vowels to lowercase or uppercase before sorting.
3. **Custom vowel order**
   Define your own comparator for vowels.

---

## 🎯 Conclusion

This method efficiently sorts vowels while preserving consonant positions.
It is optimal in terms of time complexity for this type of problem and is beginner-friendly to implement.

```
