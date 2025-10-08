import java.util.*;

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        char[] sChar = s.toCharArray();
        List<Integer> indicesA = kmp(sChar, a.toCharArray());
        List<Integer> indicesB = kmp(sChar, b.toCharArray());
        List<Integer> res = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < indicesA.size(); i++) {
            boolean found = false;
            int aIndex = indicesA.get(i);

            // Check left side
            while (j < indicesB.size() && aIndex > indicesB.get(j)) {
                if (aIndex - indicesB.get(j) <= k) {
                    res.add(aIndex);
                    found = true;
                    break;
                }
                j++;
            }

            // Check right side
            int lowerBound = j;
            while (!found && lowerBound < indicesB.size() && indicesB.get(lowerBound) <= aIndex + k) {
                if (indicesB.get(lowerBound) - aIndex <= k) {
                    res.add(aIndex);
                    found = true;
                }
                lowerBound++;
            }
        }

        return res;
    }

    private List<Integer> kmp(char[] s, char[] pattern) {
        int[] lps = computeLps(pattern);
        List<Integer> res = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < s.length; i++) {
            while (j > 0 && s[i] != pattern[j]) {
                j = lps[j - 1];
            }
            if (s[i] == pattern[j]) {
                j++;
            }
            if (j == pattern.length) {
                res.add(i - j + 1);
                j = lps[j - 1];
            }
        }
        return res;
    }

    private int[] computeLps(char[] s) {
        int length = 0;
        int i = 1;
        int[] lps = new int[s.length];

        while (i < s.length) {
            while (length > 0 && s[i] != s[length]) {
                length = lps[length - 1];
            }
            if (s[length] == s[i]) {
                ++length;
            }
            lps[i++] = length;
        }
        return lps;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "isawsquirrelnearmysquirrelhouseohmy";
        String a = "my";
        String b = "squirrel";
        int k = 15;

        List<Integer> result = sol.beautifulIndices(s, a, b, k);
        System.out.println(result);
    }
}
