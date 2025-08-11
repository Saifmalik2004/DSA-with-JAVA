public class Solution {
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1); // Reverse first k chars
            reverse(arr, left, right);
        }

        return new String(arr);
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
      

        String s = "abcdefg";
        int k = 2;

        String result = reverseStr(s, k);
        System.out.println(result); // Expected output: "bacdfeg"
    }
}
