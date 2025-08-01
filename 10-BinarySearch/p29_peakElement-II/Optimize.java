public class Optimize {

    // Main function to find a peak element in the matrix
    public static int[] find(int[][] matrix) {
        int cols = matrix[0].length;
        int low = 0;
        int high = cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = findMaxElem(matrix, mid);
            int left = mid - 1 >= 0 ? matrix[row][mid - 1] : -1;
            int right = mid + 1 < cols ? matrix[row][mid + 1] : -1;

            if (matrix[row][mid] > left && matrix[row][mid] > right) {
                return new int[] { row, mid };
            } else if (matrix[row][mid] > left) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[] {};
    }

    // Helper function to find max element in a column
    public static int findMaxElem(int[][] matrix, int col) {
        int max = Integer.MIN_VALUE;
        int maxRow = 0;

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] > max) {
                max = matrix[row][col];
                maxRow = row;
            }
        }

        return maxRow;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 15},
            {21, 30, 14},
            {7, 16, 32}
        };


        int[] peak = find(matrix);
        System.out.println("Peak Element Found At: Row = " + peak[0] + ", Column = " + peak[1]);
    }
}
