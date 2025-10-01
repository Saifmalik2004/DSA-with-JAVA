import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = prices[i] - stack.peek();
            } else {
                res[i] = prices[i];
            }
            stack.push(prices[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1
        int[] prices1 = {8, 4, 6, 2, 3};
        System.out.println("Test 1: " + Arrays.toString(sol.finalPrices(prices1)));
        // Expected: [4, 2, 4, 2, 3]

        // Test 2
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Test 2: " + Arrays.toString(sol.finalPrices(prices2)));
        // Expected: [1, 2, 3, 4, 5] (no discounts apply)

        // Test 3
        int[] prices3 = {10, 1, 1, 6};
        System.out.println("Test 3: " + Arrays.toString(sol.finalPrices(prices3)));
        // Expected: [9, 0, 1, 6]
    }
}
