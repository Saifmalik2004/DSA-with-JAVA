import java.util.*;

public class Solution {

    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int n = s.length();
        int m = words.length;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            String word = words[i];
            int prev = -1;
            boolean isSubseq = true;

            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);

                if (!map.containsKey(ch)) {
                    isSubseq = false;
                    break;
                }

                int idx = findNextIndex(prev, map.get(ch));
                if (idx == -1) {
                    isSubseq = false;
                    break;
                }

                prev = idx;
            }

            if (isSubseq) {
                result++;
            }
        }

        return result;
    }

    // ✅ Binary Search to find next index > prev
    public int findNextIndex(int prev, List<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) > prev) {
                ans = arr.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // ✅ Main Method
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};

        int result = sol.numMatchingSubseq(s, words);

        System.out.println("Matching Subsequences Count: " + result);
        // Output: 3
    }
}
