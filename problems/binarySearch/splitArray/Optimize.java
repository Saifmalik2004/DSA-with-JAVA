
public class Optimize {

    public static int split(int[] nums,int n, int k) {
        
        
        
        if (n < k) return -1;
        int low=Integer.MIN_VALUE;
        int high=0;
        for (int elem : nums) {
            high += elem;
            low=Math.max(elem,low);
        }
    
       
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isValid(int[] nums, int mid, int k) {
        int split = 1, sum = 0;

       
        for (int i = 0; i < nums.length; i++) {
            if (sum+nums[i] <= mid){
                sum += nums[i];
            } else {
                sum = nums[i];
                split++;
            }
        }
        return split <=k;
    }
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        System.out.println(split(arr,arr.length, 2));
    }
}
