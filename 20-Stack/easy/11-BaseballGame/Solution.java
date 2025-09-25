import java.util.Stack;

public class Solution {

    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String str : operations) {
            if (str.equals("C")) {
                stack.pop();
            } else if (str.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (str.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a + b);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1
        String[] ops1 = {"5", "2", "C", "D", "+"};
        System.out.println("Test 1 Output: " + sol.calPoints(ops1)); 
        // Expected: 30
        // Explanation: ["5","2","C","D","+"] -> 5, 2, cancel(2), double(5*2=10), sum(5+10=15) => total = 30

        // Test 2
        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("Test 2 Output: " + sol.calPoints(ops2));
        // Expected: 27

        // Test 3
        String[] ops3 = {"1", "C"};
        System.out.println("Test 3 Output: " + sol.calPoints(ops3));
        // Expected: 0
    }
}
