import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    public static void main(String[] args) {
        // Values and weights of items
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};

        // Maximum capacity of the knapsack
        int w = 50;

        // Array to store item index and value-to-weight ratio
        double ratio[][] = new double[val.length][2];

        // Calculate the ratio for each item
        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i; // Store the index of the item
            ratio[i][1] = val[i] / (double) weight[i]; // Calculate the ratio
        }

        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w; // Remaining capacity of the knapsack
        int finalVal = 0; // Total value of items in the knapsack

        // Fill the knapsack
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0]; // Get the original index of the item
            if (capacity >= weight[idx]) {
                // If the item fits, take it entirely
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                // If the item doesn't fit, take a fraction of it
                finalVal += (ratio[i][1] * capacity);
                break; // Knapsack is full
            }
        }

        // Print the final total value
        System.out.println("Final value = " + finalVal);
    }
}