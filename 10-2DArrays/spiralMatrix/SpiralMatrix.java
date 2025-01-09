public class SpiralMatrix {
    public static void spiral(int matrix[][]) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        
        while (startRow <= endRow && startCol <= endCol) {
            // Traverse from left to right across the top row
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            
            // Traverse from top to bottom on the rightmost column
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            
            // Traverse from right to left on the bottom row (if there's more than one row left)
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) break;
                System.out.print(matrix[endRow][j] + " ");
            }
            
            // Traverse from bottom to top on the leftmost column (if there's more than one column left)
            for (int i = endRow - 1; i > startRow; i--) {
                if (startCol == endCol) break;
                System.out.print(matrix[i][startCol] + " ");
            }
            
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        // Display the matrix
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
        
        // Print the matrix in spiral order
        spiral(matrix);
    }
}
