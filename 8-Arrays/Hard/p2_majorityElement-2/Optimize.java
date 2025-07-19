
import java.util.ArrayList;
import java.util.List;


public class Optimize {
    // Method to find the majority element in the array.
    public static List<Integer> majorityElement(int[] nums) {
        int elem1 = Integer.MIN_VALUE, count1 = 0;
        int elem2 = Integer.MIN_VALUE, count2 = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != elem2) { 
                count1 = 1;
                elem1 = nums[i];
            } else if (count2 == 0 && nums[i] != elem1) { 
                count2 = 1; // Fix: Should update count2, not count1
                elem2 = nums[i];
            } else if (elem1 == nums[i]) count1++;
            else if (elem2 == nums[i]) count2++;
            else { 
                count1--;
                count2--;
            }
        }

        // Second pass to count actual occurrences
        count1 = 0; 
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (elem1 == nums[i]) count1++;
            if (elem2 == nums[i]) count2++;
        }

        int f = nums.length / 3; // Fix: No need to add 1, it should be `>= f`

        if (count1 > f) ans.add(elem1);
        if (count2 > f) ans.add(elem2); // Fix: Should check count2, not count1

        return ans;
    }

    // Main method to test the functionality.
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11}; // Input array.
        System.out.println(majorityElement(arr)); // Call the majorityElement method and print the result.
    }

    

    public static void mm(String[] args) {
        
        
    }

}
