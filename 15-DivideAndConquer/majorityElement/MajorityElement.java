public class MajorityElement {

    public static int majorityElement(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private static int divideAndConquer(int[] nums, int low, int high) {
        // Base case: If the array contains only one element
        if (low == high) {
            return nums[low];
        }

        // Divide step: Find the mid-point
        int mid = low + (high - low) / 2;

        // Recursively find the majority element in left and right halves
        int leftMajority = divideAndConquer(nums, low, mid);
        int rightMajority = divideAndConquer(nums, mid + 1, high);

        // If both halves agree on the majority element
        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        // Count occurrences of leftMajority and rightMajority in the current range
        int leftCount = countInRange(nums, leftMajority, low, high);
        int rightCount = countInRange(nums, rightMajority, low, high);

        // Return the element with the higher count
        return leftCount > rightCount ? leftMajority : rightMajority;
    }

    private static int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + majorityElement(nums)); // Output: 2
    }
}
