import java.util.Stack;

class Solution {
        public int calculate(String s) {
        Stack<Integer> num = new Stack<>();
        char sign = '+'; // default sign
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int number = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // adjust

                if (sign == '+') {
                    num.push(number);
                } else if (sign == '-') {
                    num.push(-number);
                } else if (sign == '*') {
                    num.push(num.pop() * number);
                } else if (sign == '/') {
                    num.push(num.pop() / number);
                }
            } else if (c != ' ') {
                sign = c; // update operator
            }
        }

        // final result = sum of stack
        int res = 0;
        for (int val : num) res += val;

        return res;
    }
}