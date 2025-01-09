public class Search {
    public static boolean searchInMatrix(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1;  // Initialize col correctly

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found at " + row + ", " + col);
                return true;
            }
            if (matrix[row][col] > key) {
                col--;  // Move left if the current element is greater than the key
            } else {
                row++;  // Move down if the current element is less than the key
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        
        int key = 33;
        searchInMatrix(matrix, key);
    }
}
