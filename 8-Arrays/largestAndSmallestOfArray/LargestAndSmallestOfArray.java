// FindLargest.java

public class LargestAndSmallestOfArray {
    
    // Method to find the largest number in the array
    public static int largestNum(int numbers[]) {
        int largest = Integer.MIN_VALUE; // Initialize largest to minimum possible value
        int smallest = Integer.MAX_VALUE; // Initialize smallest to maximum possible value
        
        // Iterate through the array to find largest and smallest
        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i]; // Update largest if current number is greater
            }
            if (smallest > numbers[i]) {
                smallest = numbers[i]; // Update smallest if current number is smaller
            }
        }
        
        // Print the smallest value found in the array
        System.out.println("Smallest value: " + smallest);
        return largest; // Return the largest value found
    }

    // Main method to test the largest number function
    public static void main(String[] args) {
        int num[] = {2, 4, 6, 8, 10, 992, 14, 16, 18, 20}; // Sample array
        
        // Find and print the largest number
        int largestValue = largestNum(num);
        System.out.println("Largest value: " + largestValue);
    }
}
