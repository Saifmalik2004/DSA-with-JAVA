public class Optimize {
    public static int[] find(int[][] matrix,int k) {
        int n = matrix[0].length;
        int low=0;
        int high=n-1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int row=findMaxElem(matrix, mid);
                int left= mid-1>=0?matrix[row][mid-1]:-1;
                int right= mid+1<n?matrix[row][mid+1]:-1;

                if (matrix[row][mid]>left&& matrix[row][mid]>right) {
                    return new int[]{row,mid};
                } else if (matrix[row][mid] > left) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        
        return new int[]{};
    }

    public static int findMaxElem(int[][] matrix, int col) {
        int n=matrix.length;
        int max=Integer.MIN_VALUE;
        int row=0;
        int ans=-1;
        while(row<n){
            if(matrix[row][col]>max){
                max=matrix[row][col];
                ans=row;
            }
            row++;
        }

        return ans;
        
    }

    public static void main(String[] args) {
       int[][] matrix = {
            {10, 20, 15},
            {21, 30, 14},
            {7, 16, 32}
        };

        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println("Brute Search 4: " + find(matrix, 4)[0]+" "+find(matrix, 4)[1]);
    }
}
