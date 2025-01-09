public class ArrayPairs {

    // This method prints all possible pairs from the array and counts the total pairs
    public static void pairArray(int num[]) {
        int total = 0; // Initialize the total count of pairs to 0

        // Outer loop to select the first element of the pair
        for (int i = 0; i < num.length; i++) {

            // Inner loop to select the second element of the pair
            for (int j = i + 1; j < num.length; j++) {
                // Print the current pair (num[i], num[j])
                System.out.print("(" + num[i] + "," + num[j] + ") ");
                total++; // Increment the total count of pairs
            }

            // Print a new line after printing all pairs for a specific 'i'
            System.err.println("");
        }

        // Print the total number of pairs generated
        System.out.println("Total pairs are: " + total);
    }

    // Main method to run the program
    public static void main(String[] args) {
        int num[] = {2,4,6,8,10}; // Example array of numbers
        pairArray(num); // Call the pairArray method to generate pairs
    }
}
