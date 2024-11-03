public class ShortestPath {

    // Method to calculate the shortest path based on directions in the input string
    public static float ShortestPath(String str) {
        int x = 0, y = 0;  // Initialize coordinates (x, y) at the origin (0, 0)

        // Loop through each character in the input string to determine direction
        for (int i = 0; i < str.length(); i++) {
            char dir = str.charAt(i);  // Get the current direction character

            // Use a switch statement to update (x, y) based on direction
            switch (dir) {
                case 'S' -> y--;   // Move South: decrement y by 1
                case 'N' -> y++;   // Move North: increment y by 1
                case 'W' -> x--;   // Move West: decrement x by 1
                default  -> x++;   // Move East: increment x by 1
            }
        }

        // Calculate the square of x and y to find the distance using the Pythagorean theorem
        int x2 = x * x;   // Square of x-coordinate
        int y2 = y * y;   // Square of y-coordinate

        // Return the Euclidean distance from the origin to (x, y) as a float
        return (float) Math.sqrt(x2 + y2);  // √(x^2 + y^2)
    }

    // Main method to test the ShortestPath method with a sample input
    public static void main(String[] args) {
        var str = "SSSNNN";  // Define a sample string representing movement directions
        System.out.println(ShortestPath(str));  // Calculate and print the shortest path
    }
}
