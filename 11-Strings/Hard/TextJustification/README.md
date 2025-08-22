# README.md: Text Justification Problem

## Problem Description

Given an array of strings `words` and an integer `maxWidth`, format the text such that each line contains as many words as possible, fully justified (both left and right), with each line exactly `maxWidth` characters long. Words are separated by spaces, and extra spaces are distributed as evenly as possible between words. For the last line, it should be left-justified with single spaces between words and spaces appended at the end to reach `maxWidth`.

### Key Details
- **Input**:
  - `words`: An array of strings (words to be justified).
  - `maxWidth`: The maximum width of each line.
- **Output**: A list of strings, each representing a justified line of length `maxWidth`.
- **Constraints**:
  - `1 <= words.length <= 300`
  - `1 <= words[i].length <= 20`
  - `words[i]` consists of English letters and symbols.
  - `1 <= maxWidth <= 100`
  - The sum of lengths of words in a line plus minimum spaces does not exceed `maxWidth`.
- **Rules**:
  - Each line should contain as many words as can fit within `maxWidth`.
  - For regular lines (not the last), distribute extra spaces evenly between words. If spaces cannot be evenly distributed, place extra spaces toward the left.
  - For the last line or lines with one word, use single spaces and pad with spaces at the end to reach `maxWidth`.
- **Examples**:
  - Input: `words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16`
    - Output:
      ```
      [
         "This    is    an",
         "example  of text",
         "justification.  "
      ]
      ```
    - Explanation:
      - Line 1: `"This is an"` (12 chars with 2 spaces) + 4 extra spaces → `"This    is    an"`.
      - Line 2: `"example of text"` (15 chars with 2 spaces) + 1 extra space → `"example  of text"`.
      - Line 3: `"justification."` (left-justified, 1 space after word) + 2 spaces → `"justification.  "`.
  - Input: `words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16`
    - Output:
      ```
      [
        "What   must   be",
        "acknowledgment  ",
        "shall be        "
      ]
      ```

## Intuition

To justify text:
1. **Greedy Line Packing**: For each line, include as many words as possible without exceeding `maxWidth`, accounting for at least one space between words.
2. **Space Distribution**:
   - For regular lines, calculate total spaces needed (`maxWidth - total word length`) and distribute them evenly across gaps between words. Extra spaces (if any) are added to gaps from the left.
   - For the last line or single-word lines, use one space between words and pad the end with spaces.
3. **Line Construction**: Build each line by appending words and calculated spaces, ensuring the total length is exactly `maxWidth`.

The solution processes the words array sequentially, grouping words into lines, calculating spaces, and formatting each line accordingly.

## Approach: Greedy Packing with Space Distribution

### Steps:
1. **Initialize**:
   - Create a result list `res` to store justified lines.
   - Use `i` to track the current word index in `words`.
   - Store `maxWidth` as `MAX` for use in helper function.
2. **Group Words into Lines**:
   - For each line, start with word at index `i` and count its letters.
   - Use `j` to find how many additional words can fit:
     - Add words while the total length (letters + minimum spaces + next word) ≤ `maxWidth`.
     - Track `letterCount` (sum of word lengths) and `spaceSlot` (number of gaps between words).
   - Calculate `remainingSpace = maxWidth - letterCount`.
3. **Handle Space Distribution**:
   - Compute `eachWordSpace = remainingSpace / spaceSlot` (spaces per gap, if any gaps).
   - Compute `extraSpace = remainingSpace % spaceSlot` (extra spaces to distribute from left).
   - For the last line (`j == words.length`), set `eachWordSpace = 1` and `extraSpace = 0` for left justification.
4. **Build Line**:
   - Use `findLine` to construct the line from index `i` to `j`:
     - Append each word.
     - Add `eachWordSpace` spaces between words.
     - Add one extra space per gap if `extraSpace > 0` (decrement `extraSpace`).
     - For the last word, add no spaces after it.
     - Pad the end with spaces to reach `maxWidth`.
5. **Update and Repeat**:
   - Set `i = j` to process the next line.
   - Continue until all words are processed.
6. **Return**: The list of justified lines.

### Java Code:
```java
import java.util.*;

public class Solution {
    int MAX;

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int i = 0;
        MAX = maxWidth;

        while (i < n) {
            int letterCount = words[i].length();
            int spaceSlot = 0;
            int j = i + 1;

            // Select as many words as possible for the current line
            while (j < n && letterCount + spaceSlot + words[j].length() + 1 <= maxWidth) {
                letterCount += words[j].length();
                spaceSlot++;
                j++;
            }

            int remainingSpace = maxWidth - letterCount;
            int eachWordSpace = spaceSlot == 0 ? 0 : remainingSpace / spaceSlot;
            int extraSpace = spaceSlot == 0 ? 0 : remainingSpace % spaceSlot;

            // If it's the last line, use single spaces and left-justify
            if (j == n) {
                eachWordSpace = 1;
                extraSpace = 0;
            }

            res.add(findLine(i, j, eachWordSpace, extraSpace, words));
            i = j;
        }

        return res;
    }

    public String findLine(int i, int j, int eachWordSpace, int extraSpace, String[] words) {
        StringBuilder str = new StringBuilder();

        while (i < j) {
            str.append(words[i]);

            // Don't add space after the last word in the line
            if (i == j - 1) {
                i++;
                continue;
            }

            // Add calculated spaces
            for (int k = 1; k <= eachWordSpace; k++) {
                str.append(" ");
            }

            // Add one extra space if needed
            if (extraSpace > 0) {
                str.append(" ");
                extraSpace--;
            }

            i++;
        }

        // Pad the remaining spaces at the end
        while (str.length() < MAX) {
            str.append(" ");
        }

        return str.toString();
    }
}
```

### Why It Works:
- **Greedy Packing**: Ensures each line contains the maximum number of words possible within `maxWidth`.
- **Space Distribution**: Correctly handles even distribution of spaces for regular lines and left justification for the last line.
- **Edge Cases**: Handles single-word lines (no gaps, pad with spaces), last line (single spaces), and ensures every line is exactly `maxWidth`.
- **Correctness**: Follows justification rules, with extra spaces distributed from the left and proper padding at the end.

### Time and Space Complexity:
- **Time Complexity**:
  - Main loop: Iterates through `n` words, with `j` advancing to process each word at most once: `O(n)`.
  - For each line, computing `letterCount` and `spaceSlot`: `O(k)` where `k` is the number of words in the line.
  - Building each line in `findLine`: `O(maxWidth)` for appending words and spaces.
  - Total: `O(n * maxWidth)`, as each word is processed once, and line construction is proportional to `maxWidth` (up to 100).
- **Space Complexity**:
  - Result list: `O(n * maxWidth)` for storing the output lines.
  - `StringBuilder` in `findLine`: `O(maxWidth)` per line.
  - Total: `O(n * maxWidth)` for the output, with `O(maxWidth)` auxiliary space.

## Example Walkthrough
For `words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16`:
- **Line 1**: `i = 0`, `words[0] = "This" (4 chars)`.
  - Try adding words: `"This is an"` → `4 + 2 + 2 + 2 = 10` chars + 2 spaces = 12 ≤ 16.
  - Next word `"example"` (7 chars): `12 + 7 + 1 = 20 > 16`, stop at `j = 3`.
  - `letterCount = 9`, `spaceSlot = 2`, `remainingSpace = 16 - 9 = 7`.
  - `eachWordSpace = 7 / 2 = 3`, `extraSpace = 7 % 2 = 1`.
  - Build: `"This" + 4 spaces + "is" + 3 spaces + "an" = "This    is    an"`.
  - `i = 3`.
- **Line 2**: `i = 3`, `words[3] = "example" (7 chars)`.
  - Try: `"example of text"` → `7 + 2 + 4 + 2 = 15` ≤ 16.
  - Next word `"justification."` (14 chars): `15 + 14 + 1 = 30 > 16`, stop at `j = 6`.
  - `letterCount = 13`, `spaceSlot = 2`, `remainingSpace = 16 - 13 = 3`.
  - `eachWordSpace = 3 / 2 = 1`, `extraSpace = 3 % 2 = 1`.
  - Build: `"example" + 2 spaces + "of" + 1 space + "text" = "example  of text"`.
  - `i = 6`.
- **Line 3**: `i = 6`, `words[6] = "justification." (14 chars)`.
  - `j = 7` (end of array, last line).
  - `letterCount = 14`, `spaceSlot = 0`, `remainingSpace = 16 - 14 = 2`.
  - Last line: `eachWordSpace = 1`, `extraSpace = 0`.
  - Build: `"justification." + 2 spaces = "justification.  "`.
- Output: `["This    is    an", "example  of text", "justification.  "]`.

## Edge Cases
- **Single Word**: `words = ["word"], maxWidth = 10` → `["word      "]` (pad with spaces).
- **Last Line**: Left-justified with single spaces, padded at the end.
- **Single Word Per Line**: If a word’s length is close to `maxWidth`, it forms a line alone, padded with spaces.
- **Empty Words Array**: Not applicable due to constraints (`words.length >= 1`).
- **Large `maxWidth`**: Handled efficiently, as line construction is `O(maxWidth)`.

## Testing
```java
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {
            "This", "is", "an", "example", "of", "text", "justification."
        };
        int maxWidth = 16;
        List<String> result = sol.fullJustify(words, maxWidth);
        System.out.println("Justified Text Output:");
        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
        // Output:
        // "This    is    an"
        // "example  of text"
        // "justification.  "
    }
}
```

## Alternative Approach: Manual Space Calculation
Instead of computing `eachWordSpace` and `extraSpace`, we could manually assign spaces to gaps:
- Calculate total spaces needed and distribute them one by one.
- **Drawback**: More complex logic for distributing spaces, no significant performance gain.
- **Why Not Preferred**: The current approach is clear, handles last-line logic cleanly, and is efficient.

## Why This Solution is Great
- **Clear**: Separates line grouping and construction into intuitive steps.
- **Efficient**: `O(n * maxWidth)` is suitable for constraints (`n <= 300`, `maxWidth <= 100`).
- **Robust**: Handles all cases, including single-word lines, last line, and uneven space distribution.
- **Readable**: Well-structured with a helper function for line building.