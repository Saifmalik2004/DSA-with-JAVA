public class SubArrays {

    // This method prints all possible subarrays 
    public static void printSubArray(int num[]) {
        int total = 0; // Total count of subarrays
      
        // Outer loop to define the start of the subarray
        for (int i = 0; i < num.length; i++) {
            int start = i; // The start index of the subarray ,there is no need to define but we difine for you,it helping   to understand better.

            // Inner loop to define the end of the subarray
            for (int j = i; j < num.length; j++) {
                int end = j; // The end index of the subarray ,there is no need to define but we difine for you,it helping   to understand better.

             

                // Loop to print the subarray and calculate its sum
                for (int k = start; k <= end; k++) {
                    System.out.print(num[k] + " "); // Print each element of the subarray
                  
                }
                
                total++; // Increment the total number of subarrays
                System.out.println(); // Move to the next line after printing the subarray and sum
            }

            // Print a blank line after processing each starting index to separate subarrays visually
            System.out.println();
        }

        // Print the total number of subarrays
        System.out.println("Total number of subarrays: " + total);

        
    }

    // Main method to run the program
    public static void main(String[] args) {
        int num[] = {2,4,6,8,10}; // Example array of numbers
        printSubArray(num); // Call the printSubArray method with the example array
    }
}
