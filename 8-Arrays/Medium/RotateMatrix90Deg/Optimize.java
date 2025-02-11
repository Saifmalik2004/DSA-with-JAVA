public class Optimize {
    // Function to rotate the matrix 90 degrees clockwise in-place.
    public static int[][] rotate90Deg(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Step 1: Transpose the matrix (swap mat[i][j] with mat[j][i])
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swapMat(mat, i, j);
            }
        }

        // Step 2: Reverse each row to complete the 90-degree rotation
        for (int i = 0; i <n; i++) {
            reverse(mat[i], 0,n-1 );
        }

        return mat; // Returning the rotated matrix
    }
    public static void reverse(int arr[],int first,int last) {
         
        while(first<last){
            int temp=arr[first];
            arr[first]=arr[last];
            arr[last]=temp;
            first++;
            last--;
        }
     }

    // Helper function to swap two elements in the matrix
    public static void swapMat(int[][] matrix, int ai, int aj) {
        int temp = matrix[ai][aj];
        matrix[ai][aj] = matrix[aj][ai];
        matrix[aj][ai] = temp;
    }

    public static void main(String[] args) {
        // Input matrix
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
            
        };

        // Rotating the matrix in place
        int ans[][] = rotate90Deg(matrix);

        // Printing the rotated matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
