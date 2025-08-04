import java.util.Arrays;

public class Sol {

    public static boolean determineString(String str1, String str2) {
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        // Count frequency of each character in str1
        for (char ch : str1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        // Count frequency of each character in str2
        for (char ch : str2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        // Check if both strings contain the same set of characters
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Sort and compare frequencies
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args) {
        String str1 = "saif";
        String str2 = "fias";

        System.out.println(determineString(str1, str2));  // Output: true
    }
}
