// Brute Force Approach - O(N^2) Complexity
// Computes product of all subarrays and stores the maximum
public class Brute {
    public static void product(int arr[]) {
        long max = Integer.MIN_VALUE;
        
        // Iterate through all subarrays
        for (int i = 0; i < arr.length; i++) {
            long product = 1;
            for (int j = i; j < arr.length; j++) {
                product *= arr[j];
                max = Math.max(max, product); // Keep track of the maximum product
            }
        }
        System.out.println(max); // Output: 24
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        product(arr);
    }
}