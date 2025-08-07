import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        HashMap<String, Boolean> memo = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;
            wordSet.remove(word); // remove current word to prevent using itself
            if (canForm(word, wordSet, memo)) {
                result.add(word);
            }
            wordSet.add(word); // add back for the next iterations
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

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Sample input
        String[] words = {
            "cat", "cats", "catsdogcats", "dog", "dogcatsdog", 
            "hippopotamuses", "rat", "ratcatdogcat"
        };

        List<String> concatenatedWords = sol.findAllConcatenatedWordsInADict(words);

        // Output result
        System.out.println("Concatenated words in the dictionary:");
        for (String word : concatenatedWords) {
            System.out.println(word);
        }
    }
}
