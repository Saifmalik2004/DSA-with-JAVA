class Solution {

    public static boolean buddy(String s, String goal) {

        if (s.length() != goal.length()) return false;

        // Case 1: Strings are equal, check for duplicate characters
        if (s.equals(goal)) {
            int freq[] = new int[26];
            for (char elem : s.toCharArray()) {
                freq[elem - 'a']++;
                if (freq[elem - 'a'] > 1) return true;
            }
            return false;
        }

        // Case 2: Strings differ, find the indices of mismatches
        int i = 0, j = 0, count = 0;
        int idx[] = new int[2];

        while (i < s.length() && j < goal.length()) {
            if (s.charAt(i) != goal.charAt(j)) {
                if (count == 2) return false;
                idx[count] = i;
                count++;
            }
            i++;
            j++;
        }

        return s.charAt(idx[0]) == goal.charAt(idx[1]) &&
               s.charAt(idx[1]) == goal.charAt(idx[0]);
    }

    public static void main(String[] args) {
        System.out.println(buddy("ab", "ba"));  // true
        System.out.println(buddy("ab", "ab"));  // false
        System.out.println(buddy("aa", "aa"));  // true
    }
}
