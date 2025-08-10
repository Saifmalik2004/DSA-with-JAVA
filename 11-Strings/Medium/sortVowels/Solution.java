import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public String sortVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder vowels = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        // Collect vowels and replace with space
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (set.contains(Character.toLowerCase(ch))) {
                str.setCharAt(i, ' ');
                vowels.append(ch);
            }
        }

        // Sort collected vowels
        char[] sortedV = vowels.toString().toCharArray();
        Arrays.sort(sortedV);

        // Place back sorted vowels
        int i = 0, j = 0;
        while (i < str.length() && j < sortedV.length) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(i, sortedV[j++]);
            }
            i++;
        }
        return str.toString();
    }

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
