public class Brute {
    // Brute force approach to set rows and columns to zero
    public static void setZero(int met[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (met[i][j] == 0) {
                    set(met, n, m, i, j);
                }
            }
        }
        
        // Replace all -1 markers with 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (met[i][j] == -1) {
                    met[i][j] = 0;
                }
            }
        }
    }
    
    private static void set(int met[][], int n, int m, int i, int j) {
        // Mark the entire row
        for (int row = 0; row < n; row++) {
            if (met[row][j] == 1) {
                met[row][j] = -1;
            }
        }
        
        // Mark the entire column
        for (int col = 0; col < m; col++) {
            if (met[i][col] == 1) {
                met[i][col] = -1;
            }
        }
    }
    
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1}
        };
        
        setZero(matrix, 4, 4);

        // Print the modified matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
