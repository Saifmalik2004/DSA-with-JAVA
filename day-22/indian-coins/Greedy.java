import java.util.ArrayList;

public class Greedy {
    public static void main(String[] args) {
        // Step 1: Define the coin denominations
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        // Step 2: Set the target amount and initialize variables
        int amount = 590;
        int count = 0; // Tracks the number of coins used
        ArrayList<Integer> ans = new ArrayList<>(); // Stores the coins used

        // Step 3: Iterate through the coin array (from largest to smallest)
        for (int i = coins.length - 1; i >= 0; i--) {
            // While the current coin fits into the remaining amount
            while (amount >= coins[i]) {
                count++; // Increment the coin count
                ans.add(coins[i]); // Add the coin to the result list
                amount -= coins[i]; // Reduce the remaining amount
            }
        }

        // Step 4: Print the results
        System.out.println("Total coins used: " + count);
        System.out.print("Coins used: ");
        for (int coin : ans) {
            System.out.print(coin + " ");
        }
        System.out.println();
    }
}
