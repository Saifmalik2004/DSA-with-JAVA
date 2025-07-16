
import java.util.ArrayList;
import java.util.List;

public class Clean {

    public static List<Integer> spiral(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int left = 0;
        int bot = n - 1;
        int right = m - 1;
        List<Integer> ans = new ArrayList<>();
        while (left <= right && top <= bot) {

            for (int i = left; i <= right; i++) {

                ans.add(matrix[top][i]);

            }
            top++;

            for (int i = top; i <= bot; i++) {
                ans.add(matrix[i][right]);

            }

            right--;
            if (top <= bot) {
                for (int i = right; i >=left; i--) {
                    ans.add(matrix[bot][i]);

                }
                bot--;

            }
            if(left<=right){
            for (int i = bot; i >= top; i--) {
                ans.add(matrix[i][left]);

            }
            left++;
        }
        }

        return ans;

    }

    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
       

        // Calling the function to rotate the matrix
        List<Integer> ans = spiral(matrix);

        // Printing the rotated matrix
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
