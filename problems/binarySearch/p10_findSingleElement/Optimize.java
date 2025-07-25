
public class Optimize {
    public static int singleElem(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = n - 2;

        // Check edge cases
        if(n==1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Ensure mid is within valid bounds before accessing neighbors
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            // Checking pattern and adjusting binary search range
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {

                low = mid + 1;  // Move to the right half
            }
             else  high = mid - 1; // Move to the left half
        }
        return -1;  // This case should never be reached
    }
    public static void main(String[] args) {
        int arr[]={1,1,2,2,4,4,5,6,6};

        System.out.println(singleElem(arr));
    }

   
}
