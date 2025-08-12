public class Better {
    public static String reverseWords(String s) {
        int i = 0, j = 0, n = s.length();
        StringBuilder res = new StringBuilder();

        while (i < n) {
            // Move j to the end of the current word
            while (j < n && s.charAt(j) != ' ') {
                j++;
            }

            // Extract the word and reverse it
            char[] ar = s.substring(i, j).toCharArray();
            reverse(0, ar.length - 1, ar);

            res.append(new String(ar));

            // If there's a space after the word, add it
            if (j < n) {
                res.append(" ");
                j++;
            }

            i = j;
        }

        return res.toString();
    }

    public static void reverse(int left, int right, char[] arr) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        // Expected: "s'teL ekat edoCteeL tsetnoc"
    }
}
