
public class Optimize {

    // Method to find the majority element in the array.
    public static int majorityElement(int[] nums) {
        int elem = 0; // Candidate for the majority element.
        int count = 0; // Counter for the candidate.

        // Phase 1: Identify a potential candidate for the majority element.
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) { // If the counter is zero, set the current element as the candidate.
                elem = nums[i];
                count = 1;
            } else if (nums[i] == elem) { // If the current element matches the candidate, increment the counter.
                count++;
            } else { // Otherwise, decrement the counter.
                count--;
            }
        }

        // Phase 2: Verify if the candidate is actually the majority element.
        count = 0; // Reset the counter for verification.
        for (int i = 0; i < nums.length; i++) {
            if (elem == nums[i]) { // Count occurrences of the candidate.
                count++;
            }
        }

        // Check if the candidate's count is greater than n/2.
        return count > nums.length/2?elem:-1;
        

    }

    // Main method to test the functionality.
    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 1, 1, 1, 1}; // Input array.
        System.out.println(majorityElement(arr)); // Call the majorityElement method and print the result.
    }
}
