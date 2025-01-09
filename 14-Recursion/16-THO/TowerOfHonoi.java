public class TowerOfHonoi {
    
    // Recursive function with an additional counter parameter
    public static int Honoi(int disk, int src, int using, int dest, int moveCount) {
        if (disk > 0) {
            // Move all but the last disk from src to using
            moveCount = Honoi(disk - 1, src, dest, using, moveCount);
            
            // Move the current disk from src to dest
            System.out.println("Move "+disk+" disc from " + src + " to " + dest);
            moveCount++; // Increment the move count
            
            // Move the remaining disks from using to dest
            moveCount = Honoi(disk - 1, using, src, dest, moveCount);
        }
        
        // Return the updated move count
        return moveCount;
    }

    public static void main(String[] args) {
        int totalMoves = Honoi(32, 1, 2, 3, 0); // Initial move count is 0

        System.out.println("Total moves: " + totalMoves); // Print the total number of moves
    }
}
