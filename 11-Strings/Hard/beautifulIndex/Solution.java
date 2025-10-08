import java.util.*;

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> indicesA = kmpSearch(s, a);
        List<Integer> indicesB = kmpSearch(s, b);
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

    // ✅ Clean & optimized KMP function
    private List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int[] lps = buildLps(pattern);

        int i = 0; // pointer for text
        int j = 0; // pointer for pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } 
            else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        return result;
    }

    // ✅ Build LPS (Longest Prefix Suffix) array
    private int[] buildLps(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // ✅ Example usage
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
