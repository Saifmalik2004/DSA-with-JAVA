import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    public static void main(String[] args) {
        // Input: Array of pairs
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        // Step 1: Sort pairs by end time
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // Step 2: Initialize chain length and chain end
        int chainLength = 1; // First pair is always included
        int chainEnd = pairs[0][1]; // End time of the first pair

        // Step 3: Iterate through the sorted pairs
        for (int i = 1; i < pairs.length; i++) {
            // If the current pair can be included in the chain
            if (pairs[i][0] >= chainEnd) {
                chainLength++; // Increment chain length
                chainEnd = pairs[i][1]; // Update chain end time
            }
        }

        // Step 4: Output the result
        System.out.println("Max Chain Length = " + chainLength);
    }
}