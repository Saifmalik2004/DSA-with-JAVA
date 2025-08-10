public class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        // Example input
        char[] arr = {'h', 'e', 'l', 'l', 'o'};

        System.out.println("Before reverse: " + String.valueOf(arr));
        obj.reverseString(arr);
        System.out.println("After reverse: " + String.valueOf(arr));
    }
}
