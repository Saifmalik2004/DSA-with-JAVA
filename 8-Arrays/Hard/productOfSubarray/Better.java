// Better Approach - O(N) Complexity
// Uses prefix and suffix product to find the maximum subarray product efficiently
public class Better {
    public static int product(int[] nums) {
        int n = nums.length;
        long pre = 1, suff = 1;
        long ans = Integer.MIN_VALUE;

        // Traverse the array and calculate prefix & suffix products
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1; // Reset prefix product if zero
            if (suff == 0) suff = 1; // Reset suffix product if zero

            pre *= nums[i];
            suff *= nums[n - i - 1];

            ans = Math.max(ans, Math.max(pre, suff)); // Store maximum product found
        }
        return (int) ans;
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(product(arr)); // Output: 24
    }
}