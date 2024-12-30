import java.util.PriorityQueue;

public class MinCostToConnectRopes {
    // Function to calculate the minimum cost of connecting ropes
    static int minCost(int[] ropes, int n) {
        // Create a priority queue (min-heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all ropes to the priority queue
        for (int rope : ropes) {
            pq.add(rope);
        }

        int totalCost = 0; // To store the total cost

        // While more than one rope remains
        while (pq.size() > 1) {
            // Remove the two smallest ropes
            int first = pq.poll();
            int second = pq.poll();

            // Combine the two ropes and add the cost
            int combinedCost = first + second;
            totalCost += combinedCost;

            // Add the combined rope back into the priority queue
            pq.add(combinedCost);
        }

        return totalCost; // Return the total minimum cost
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        int n = ropes.length;
        // Output the minimum cost
        System.out.println("Minimum Cost to Connect Ropes: " + minCost(ropes, n));
    }
}