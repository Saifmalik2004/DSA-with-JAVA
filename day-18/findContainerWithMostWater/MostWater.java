import java.util.ArrayList;

public class MostWater {
    // Method to calculate the maximum area of water that can be contained
    public static int maxArea(ArrayList<Integer> height) {
        int maxArea = Integer.MIN_VALUE; // Initialize maxArea with the smallest possible value
        int left = 0; // Pointer starting at the beginning of the list
        int right = height.size() - 1; // Pointer starting at the end of the list

        // Use the two-pointer technique to calculate the maximum area
        while (left < right) {
            // Calculate the current area and update maxArea if it's larger
            maxArea = Math.max(maxArea, Math.min(height.get(left), height.get(right)) * (right - left));

            // Move the pointer pointing to the shorter line inward
            if (height.get(left) < height.get(right)) {
                left++; // Move the left pointer forward
            } else {
                right--; // Move the right pointer backward
            }
        }
        return maxArea; // Return the maximum area found
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>(); // Initialize the list of heights

        // Add height values to the list
        height.add(3);
        height.add(4);
        height.add(2);
        height.add(1);
        height.add(3);
        height.add(5);
        height.add(4);

        // Calculate the maximum area and print the result
        int result = maxArea(height);
        System.out.println("The maximum area of water that can be contained is: " + result);
    }
}