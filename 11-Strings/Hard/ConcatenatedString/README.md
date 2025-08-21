# README.md: Find All Concatenated Words in a Dictionary Problem

## Problem Description

Given an array of strings `words`, find all words that can be formed by concatenating two or more other words from the same array. A concatenated word is one that can be split into two or more substrings, where each substring is a word in `words` (excluding the word itself). Return the list of all such concatenated words.

### Key Details
- **Input**: An array `words` of unique strings.
- **Output**: A list of strings from `words` that are concatenated words.
- **Constraints**:
  - `1 <= words.length <= 10^4`
  - `0 <= words[i].length <= 30`
  - All strings consist of lowercase English letters.
  - The sum of lengths of all `words[i]` is at most `10^5`.
- **Examples**:
  - Input: `words = ["cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"]`
    - Output: `["catsdogcats", "dogcatsdog", "ratcatdogcat"]`
    - Explanation:
      - `"catsdogcats"` = `"cats" + "dog" + "cats"`.
      - `"dogcatsdog"` = `"dog" + "cats" + "dog"`.
      - `"ratcatdogcat"` = `"rat" + "cat" + "dog" + "cat"`.
  - Input: `words = ["cat", "dog", "catdog"]`
    - Output: `["catdog"]`
    - Explanation: `"catdog"` = `"cat" + "dog"`.

## Intuition

A concatenated word is one that can be broken into two or more smaller words from the dictionary. To check if a word is concatenated:
1. Split the word into a prefix and suffix at every possible position.
2. Check if the prefix is in the dictionary and if the suffix is either in the dictionary or itself a concatenated word.
3. Use recursion to handle cases where the suffix might be formed by multiple dictionary words.
4. To optimize, use memoization to avoid recomputing results for the same word and a hash set for fast dictionary lookups.
5. Exclude the word itself from the dictionary during its check to prevent trivial matches.

## Approach: Dynamic Programming with HashSet

The solution uses a **HashSet** for O(1) word lookups and **dynamic programming** with memoization to check if a word can be formed by concatenating dictionary words.

### Steps:
1. **Create a HashSet**: Store all words from `words` in a `HashSet` for fast lookup.
2. **Process Each Word**:
   - Skip empty words.
   - Temporarily remove the current word from the `HashSet` to avoid using it in its own formation.
   - Check if the word can be formed using the `canForm` function.
   - If it can be formed, add it to the result list.
   - Add the word back to the `HashSet` for subsequent iterations.
3. **canForm Function**:
   - Use a `HashMap` to memoize results for each word to avoid redundant computations.
   - For each position `i` from 1 to `word.length - 1`:
     - Split the word into `prefix = word[0:i]` and `suffix = word[i:end]`.
     - Check if `prefix` is in the `HashSet`.
     - If yes, check if `suffix` is either in the `HashSet` or can itself be formed by concatenating dictionary words (recursive call to `canForm`).
     - If both conditions are met, the word is concatenated; memoize `true` and return.
   - If no valid split is found, memoize `false` and return.
4. **Return Result**: Return the list of concatenated words.

### Java Code:
```java
import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        HashMap<String, Boolean> memo = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;
            wordSet.remove(word); // Remove current word to prevent self-use
            if (canForm(word, wordSet, memo)) {
                result.add(word);
            }
            wordSet.add(word); // Add back for next iterations
        }
        return result;
    }

    private boolean canForm(String word, Set<String> wordSet, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) return memo.get(word);

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordSet.contains(prefix) && (wordSet.contains(suffix) || canForm(suffix, wordSet, memo))) {
                memo.put(word, true);
                return true;
            }
        }

        memo.put(word, false);
        return false;
    }
}
```

### Why It Works:
- **HashSet**: Provides O(1) lookup for checking if a prefix or suffix is in the dictionary.
- **Memoization**: Prevents recomputing results for the same word, critical for efficiency with overlapping subproblems.
- **Recursion**: Handles cases where a suffix is itself a concatenated word (e.g., `"dogcatsdog"` splits into `"dog"` and `"catsdog"`, where `"catsdog"` is `"cats" + "dog"`).
- **Excluding Self**: Removing the word from the `HashSet` ensures it isn’t used in its own formation, adhering to the problem’s implicit requirement.

### Time and Space Complexity:
- **Time Complexity**:
  - Building the `HashSet`: `O(N)`, where `N` is the number of words.
  - For each word of length `L`, `canForm` tries up to `L` splits. Each split involves:
    - Substring operations: `O(L)` (in Java, substring is O(1) but checking in `HashSet` is O(L) due to string comparison).
    - Recursive calls: Each suffix is processed only once due to memoization.
  - Worst case: `O(L^2)` per word (for all splits and string comparisons), and there are `N` words.
  - Total: `O(N * L^2)`, where `L` is the maximum word length (up to 30). Since `L` is small, this is efficient.
- **Space Complexity**:
  - `HashSet`: `O(N * L)` for storing all words.
  - `HashMap` for memoization: `O(N * L)` in the worst case (storing results for subproblems).
  - Recursion stack: `O(L)` for the deepest recursion.
  - Result list: `O(N * L)` for output.
  - Total: `O(N * L)`.

## Example Walkthrough
For `words = ["cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"]`:
- Process `"catsdogcats"`:
  - Remove `"catsdogcats"` from `wordSet`.
  - Split at `i = 4`: `prefix = "cats"`, `suffix = "dogcats"`.
    - `"cats"` is in `wordSet`.
    - Check `"dogcats"`: Split at `i = 3`: `"dog" + "cats"`, both in `wordSet`.
    - `"catsdogcats"` is concatenated; add to result.
- Process `"dogcatsdog"`:
  - Remove `"dogcatsdog"`.
  - Split at `i = 3`: `prefix = "dog"`, `suffix = "catsdog"`.
    - `"dog"` is in `wordSet`.
    - `"catsdog"` splits as `"cats" + "dog"`, both in `wordSet`.
    - Add to result.
- Process `"ratcatdogcat"`:
  - Remove `"ratcatdogcat"`.
  - Split at `i = 3`: `prefix = "rat"`, `suffix = "catdogcat"`.
    - `"rat"` is in `wordSet`.
    - `"catdogcat"` splits as `"cat" + "dogcat"`, where `"dogcat"` splits as `"dog" + "cat"`.
    - Add to result.
- Others (e.g., `"cat"`, `"dog"`) cannot be split into multiple dictionary words.
- Result: `["catsdogcats", "dogcatsdog", "ratcatdogcat"]`.

## Edge Cases
- **Empty Word**: Skip empty strings as they cannot be concatenated.
- **Single Character Words**: Cannot be concatenated (need at least two words).
- **No Concatenated Words**: Return an empty list if no words can be formed.
- **Large Words**: Handled efficiently due to memoization and small `L` (up to 30).
- **Repeated Words**: Not applicable, as the problem implies unique words.

## Testing
```java
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {
            "cat", "cats", "catsdogcats", "dog", "dogcatsdog",
            "hippopotamuses", "rat", "ratcatdogcat"
        };
        List<String> result = sol.findAllConcatenatedWordsInADict(words);
        System.out.println("Concatenated words: " + result);
        // Output: [catsdogcats, dogcatsdog, ratcatdogcat]
    }
}
```

## Alternative Approach: Trie-Based Solution
A trie could be used to store words and check prefixes dynamically. However:
- **Complexity**: Trie construction is `O(N * L)`, and checking each word is complex due to recursive suffix checks.
- **Drawback**: More code complexity and similar time complexity, less intuitive than the HashSet approach.
- **Why Not Preferred**: The HashSet with memoization is simpler and equally efficient for small word lengths.

## Why This Solution is Great
- **Efficient**: `O(N * L^2)` is practical due to small `L` (up to 30) and memoization.
- **Simple**: Clear separation of word checking and recursive formation logic.
- **Robust**: Handles all edge cases (empty strings, single words, large inputs).
- **Optimized**: Memoization and HashSet ensure minimal redundant computations and fast lookups.