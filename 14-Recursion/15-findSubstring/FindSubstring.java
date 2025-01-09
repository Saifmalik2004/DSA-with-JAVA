public class FindSubstring {
   
    public static int findPalinSubstringCount(String str, int start, int end, int n) {
        // Base case: If the substring length is 1, it is a palindrome.
        if (n == 1) {
            return 1;
        }
        // Base case: If the substring length is 0 or negative, there are no palindromes.
        if (n <= 0) {
            return 0;
        }

        // Recursive relation:
        // 1. Count palindromes by excluding the first character (start + 1, end).
        // 2. Count palindromes by excluding the last character (start, end - 1).
        // 3. Subtract the overlapping count (start + 1, end - 1).
        int res = findPalinSubstringCount(str, start + 1, end, n - 1) +
                  findPalinSubstringCount(str, start, end - 1, n - 1) -
                  findPalinSubstringCount(str, start + 1, end - 1, n - 2);

        // Check if the current substring (start to end) is a palindrome.
        // If the first and last characters match, it is a palindrome, so add 1 to the result.
        if (str.charAt(start) == str.charAt(end)) {
            res++;
        }

        
        return res;
    }

    public static void main(String[] args) {
        
        String str = "zzz";

        // Get the length of the string.
        int n = str.length();

        
        System.out.println(findPalinSubstringCount(str, 0, n - 1, n));
    }
}
