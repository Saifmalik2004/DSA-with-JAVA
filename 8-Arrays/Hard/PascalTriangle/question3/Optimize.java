
import java.util.ArrayList;
import java.util.List;


public class Optimize {
    static List<Integer> printRow(int n) {
        long ans = 1;

        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); 
        // Printing the rest of the part:
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            ansRow.add((int)ans);
        }
       return ansRow;
    }

    static List<List<Integer>> pascalTriangle(int n) {
        
        
        List<List<Integer>> ans = new ArrayList<>();

        //store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(printRow(row));
        }
        return ans;
    }


    public static void main(String[] args) {
        //     1 
        //    1 1
        //   1 2 1
        //  1 3 3 1
        // 1 4 6 4 1  
        int n = 5;
        List<List<Integer>> ans = pascalTriangle(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
