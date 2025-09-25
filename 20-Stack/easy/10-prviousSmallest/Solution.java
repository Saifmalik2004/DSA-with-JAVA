
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
        public static int[] previousSmallestElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        int ans[]=new int[findNums.length];
        for (int i=nums.length-1;i>=0;i--) {
            while (!stack.isEmpty() && stack.peek() > nums[i])
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }   
        
        for (int i = 0; i < findNums.length; i++)
            ans[i] = map.getOrDefault(findNums[i], -1);
        return ans;
    }

    public static void main(String args[]){
        int[] num1={4,1,2};
        int[] num2={1,3,4,2};

        int[] result=previousSmallestElement(num1, num2);

        for (int elem : result) {

            System.out.println(elem);
            
        }
    }
}