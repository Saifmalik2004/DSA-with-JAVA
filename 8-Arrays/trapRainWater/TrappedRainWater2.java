public class TrappedRainWater2 {

    // Method to calculate the trapped rainwater between bars
    public static int trappedRainWater(int[] height) {
        
        // Initialize two pointers at the start and end of the array
        int left = 0;
        int right = height.length - 1;

        // Initialize variables to keep track of the maximum heights on the left and right
        int leftMax = height[left];
        int rightMax = height[right];

        // Initialize variable to accumulate the total amount of trapped water
        int water = 0;

        // Process until the two pointers meet
        while (left < right) {

            // If the left side max is less than the right side max
            if (leftMax < rightMax) {
                // Move the left pointer one step to the right
                left++;

                // Update the leftMax to be the maximum value so far on the left side
                leftMax = Math.max(leftMax, height[left]);

                // Calculate trapped water at current left index (leftMax - height[left])
                water += leftMax - height[left];
            } else {
                // If the rightMax is less than or equal to the leftMax
                // Move the right pointer one step to the left
                right--;

                // Update the rightMax to be the maximum value so far on the right side
                rightMax = Math.max(rightMax, height[right]);

                // Calculate trapped water at current right index (rightMax - height[right])
                water += rightMax - height[right];
            }
        }

        // Return the total amount of trapped water
        return water;
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Initialize an example height array
        int height[] = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};

        // Print the result of trapped rainwater calculation
        System.out.print(trappedRainWater(height)); // Expected output: 25
    }
}
