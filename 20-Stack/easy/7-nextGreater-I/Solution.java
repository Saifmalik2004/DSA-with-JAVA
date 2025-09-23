
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
        public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        int ans[]=new int[findNums.length];
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < findNums.length; i++)
            ans[i] = map.getOrDefault(findNums[i], -1);
        return ans;
    }

    public static void main(String args[]){
        int[] num1={4,1,2};
        int[] num2={1,3,4,2};

        int[] result=nextGreaterElement(num1, num2);

        for (int elem : result) {

            System.out.println(elem);
            
        }
    }
}