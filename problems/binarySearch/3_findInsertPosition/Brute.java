public class Brute {

    // Finds the index to insert 'target' in sorted array 'arr'
    public static int findInsertPos(int arr[], int target) {

        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;  // Default: insert at end

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Avoids overflow

            if (arr[mid] == target) {
                return mid;  // Target found
            } 
            else if (arr[mid] > target) {
                ans = mid;   // Possible insert position
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }

        return ans;  // Final insert position
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(findInsertPos(arr, 2));  // Output: 1
    }
}
