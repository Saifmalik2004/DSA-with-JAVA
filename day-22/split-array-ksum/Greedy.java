public class Greedy {
    static int ans = 10000000; // Global variable to track the minimum maximum sum

    public static void solve(int a[], int n, int k, int index, int sum, int maxSum) {
        if (k == 1) {
            maxSum = Math.max(sum, maxSum);
            sum = 0;
            for (int i = index; i < n; i++) {
                sum += a[i];
            }
            maxSum = Math.max(sum, maxSum);
            ans = Math.min(maxSum, ans);
            return;
        }

        sum = 0;
        for (int i = index; i < n; i++) {
            sum += a[i];
            maxSum = Math.max(sum, maxSum);
            solve(a, n, k - 1, i + 1, sum, maxSum);
        }
    }

    public static int splitSubarray(int a[], int n, int k) {
        solve(a, n, k, 0, 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        int a[] = {1, 1, 2};
        int n = 3;
        int k = 2;

        System.out.println(splitSubarray(a, n, k)); // Output the result
    }
}
