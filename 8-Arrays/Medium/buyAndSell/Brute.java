public class Brute {
    // Method to calculate the maximum profit from buying and selling stocks
    public static void buyAndSell(int arr[]) {

        int max = Integer.MIN_VALUE; // Initialize max profit to the smallest possible value

        // Outer loop to pick the buying day
        for (int i = 0; i < arr.length - 1; i++) {
            int buy = arr[i]; // Buy price for the current day

            // Inner loop to pick the selling day
            for (int j = i + 1; j < arr.length; j++) {
                // Check if the current selling price is higher than the buy price
                if (buy < arr[j]) {
                    int sell = arr[j] - buy; // Calculate profit for the current pair
                    max = Math.max(sell, max); // Update max profit if the current profit is greater
                }
            }
        }
        // Print the maximum profit
        System.out.println(max);
    }

    public static void main(String[] args) {
        // Array representing stock prices on different days
        int price[] = {2, 7, 1, 8, 3}; // Sample stock prices for each day

        // Call the method to calculate and display maximum profit
        buyAndSell(price);
    }    
}
