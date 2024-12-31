public class Greedy {
    public static boolean isValid(int arr[], int n, int m, int maxAllocation) {
        int student = 1, pages = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxAllocation) {
                return false; // A single book exceeds max allocation
            }
            if (pages + arr[i] <= maxAllocation) {
                pages += arr[i]; // Add pages to current student
            } else {
                student++; // Move to the next student
                pages = arr[i];
            }
        }
        return student <= m; // Check if within the student limit
    }

    public static int allocationBooks(int arr[], int n, int m) {
        if (m > n) {
            return -1; // More students than books
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int ans = -1;
        int start = 0, end = sum;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(arr, n, m, mid)) {
                ans = mid; // Update answer
                end = mid - 1; // Try smaller maximum
            } else {
                start = mid + 1; // Increase minimum
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2};
        int n = 3, m = 2;

        System.out.println(allocationBooks(arr, n, m)); // Output: 2
    }
}