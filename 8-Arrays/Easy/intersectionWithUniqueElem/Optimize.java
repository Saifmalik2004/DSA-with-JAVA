import java.util.Arrays;

public class Optimize {

    public static int[] intersection(int[] nums1, int[] nums2) {
        final boolean[] nums = new boolean[1001]; // Step 1: Boolean array for quick lookup
        final int[] ans = new int[Math.min(nums1.length, nums2.length)]; // Step 2: Result array
        
        for (int num : nums1) nums[num] = true; // Step 3: Mark nums1 elements
        
        int index = 0;
        for (int num : nums2) { // Step 4: Check in nums2
            if (nums[num]) { // Step 5: If found in nums1
                ans[index++] = num; // Step 6: Add to result
                nums[num] = false; // Step 7: Avoid duplicates
            }
        }
        
        return Arrays.copyOfRange(ans, 0, index); // Step 8: Return valid part
    }

    public static void main(String[] args) {
      int num1[]={1,2,2,3,3,4};
      int num2[]={2,2,3};

      for (int elem : intersection(num1, num2)) {
          System.out.print(elem+" ");
      }

    }
}


