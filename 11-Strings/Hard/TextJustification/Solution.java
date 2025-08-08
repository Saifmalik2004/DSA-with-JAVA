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

        // Pad the remaining spaces at the end (for last line or single word)
        while (str.length() < MAX) {
            str.append(" ");
        }

        return str.toString();
    }

    // Main method to run and test
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
    }
}
