// Optimized Approach - O(N) Complexity
// Uses dynamic programming concepts to maintain current max and min products
public class Optimize {
    public static int product(int arr[]) {
        int currMax = 1, currMin = 1;
        int ans = Integer.MIN_VALUE;
        
        // Iterate through array and maintain current max and min products
        for (int n : arr) {
            int temp = currMax * n;
            currMax = Math.max(n, Math.max(n * currMax, n * currMin));
            currMin = Math.min(n, Math.min(temp, n * currMin)); // Min product to handle negatives

            ans = Math.max(ans, currMax); // Store maximum product found
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(product(arr)); // Output: 24
    }
}