public class Better {
    // Function to set rows and columns to zero if any element is zero
    public static void setZero(int met[][], int n, int m) {
        int row[] = new int[n];
        int col[] = new int[m];
        
        // Mark rows and columns that need to be set to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (met[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        
        // Set the respective rows and columns to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    met[i][j] = 0;
                }
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
