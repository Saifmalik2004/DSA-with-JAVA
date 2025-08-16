class Solution {
    public int maximum69Number(int num) {
        int temp = num;
        int indexToChange = -1;  // sabse rightmost 6 ka index (digit position from right)
        int position = 0;

        while (temp > 0) {
            if (temp % 10 == 6) {
                indexToChange = position; // last seen 6 ki position
            }
            temp /= 10;
            position++;
        }

        // Agar koi 6 mila hai toh us position pe 3 add karenge
        if (indexToChange != -1) {
            num += 3 * (int)Math.pow(10, indexToChange);
        }
        return num;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int num1 = 9669;
        int num2 = 9996;
        int num3 = 9999;

        System.out.println("Original: " + num1 + " → Maximum: " + sol.maximum69Number(num1));
        System.out.println("Original: " + num2 + " → Maximum: " + sol.maximum69Number(num2));
        System.out.println("Original: " + num3 + " → Maximum: " + sol.maximum69Number(num3));
    }
}
