
import java.util.ArrayList;
import java.util.List;


public class Brute {
    
    public static List<Integer> spiral(int matrix[][]) {
        
        boolean up=false;
        boolean down=false;
        boolean left=false;
        boolean right=true;
        int i=0;
        int j=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int cycle=0;
        List<Integer> ans=new ArrayList<>();

        while(ans.size()<n*m){
            if(right){
                ans.add(matrix[i][j]);
                if(j == m-1-cycle){
                    right=false;
                    down=true;
                    i++;
                }else{
                    j++;
                }
            }else if(down){
                ans.add(matrix[i][j]);
                if(i == n-1-cycle){
                    down=false;
                    left=true;
                    j--;
                }else{
                    i++;
                }
                
            }else if(left){
                ans.add(matrix[i][j]);
                if(j == cycle){
                    left=false;
                    up=true;
                    i--;
                }else{
                    j--;
                }

            }else if(up){
                ans.add(matrix[i][j]);
                if(i == cycle+1){
                    up=false;
                    right=true;
                    j++;
                    cycle++;
                }else{
                    i--;
                }
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        
        
  // Input matrix
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