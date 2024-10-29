public class MaxArea {
    // Method to calculate the maximum area of water that can be contained
    public int maxArea(int[] height) {
        // Variable to store the maximum area found
        int maxArea = 0;

        // Initialize two pointers: left at the beginning and right at the end of the array
        int left = 0;
        int right = height.length - 1;

        // Loop until the left pointer is less than the right pointer
        while (left < right) {
            // Calculate the area formed between the lines at the left and right pointers
            // The area is determined by the shorter line, hence the min function
            // Multiply by the distance between the two pointers (right - left)
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            // Move the pointer of the shorter line inward
            // If the left line is shorter, move the left pointer to the right
            if (height[left] < height[right]) {
                left++;
            } 
            // If the right line is shorter or equal, move the right pointer to the left
            else {
                right--;
            }
        }
        // Return the maximum area found
        return maxArea;
    }

    // Main method to test the maxArea function
    public static void main(String[] args) {
        MaxArea ma = new MaxArea(); // Create an instance of the MaxArea class

        // Example height array representing the height of lines
        int[] height = {3, 4, 2, 1, 3, 5, 4};
        
        // Call the maxArea method and store the result
        int result = ma.maxArea(height);
        


        // Print the maximum area of water that can be contained
        System.out.println("The maximum area of water that can be contained is: " + result);
    }
}
