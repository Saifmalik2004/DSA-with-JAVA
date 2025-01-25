public class BuyAndSell {

    // Function to calculate the maximum profit from buying and selling stock
    public static int buyAndSell(int[] prices) {
        int buy = Integer.MAX_VALUE; // Initialize the buy price to a very high value
        int maxSell = 0;             // Variable to track the maximum profit
        int day = 0;                 // Day counter to iterate through the array

        // Loop through each day's price in the array
        while (day < prices.length) {
            // Check if we can make a profit by selling today (price[day] - buy)
            if (buy < prices[day]) {
                // Update maxSell if the current profit is higher than maxSell
                maxSell = Math.max(maxSell, prices[day] - buy);
            }
            // Update the buy price to the current day's price (if it's lower than previous buy)
            buy = Math.min(buy, prices[day]);
            day++; // Move to the next day
        }

        // Return the maximum profit achievable
        return maxSell;
    }

    public static void main(String[] args) {
        int price[] = {2,100,150,120}; // Sample stock prices for each day
        System.out.println(buyAndSell(price)); // Output the maximum profit
    }
}
