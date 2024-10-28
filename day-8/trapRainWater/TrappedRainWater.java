public class TrappedRainWater {

    public static int trappedRainWater(int[] height) {
        
        int n = height.length;

        // If there are less than 3 bars, no water can be trapped
        if (n <= 2) return 0;

        // Arrays to store the maximum heights from the left and right for each position
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        // Fill the leftMax array where each position holds the max height to the left of or at that position
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill the rightMax array where each position holds the max height to the right of or at that position
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate the total trapped water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            // Minimum of leftMax and rightMax gives the water level at that position
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            // Accumulate trapped water by subtracting the height from water level
            trappedWater += waterLevel - height[i];
        }
        
        return trappedWater;
    }

    public static void main(String[] args) {
        int height[] = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.print(trappedRainWater(height)); // Expected output: 25
    }
}
