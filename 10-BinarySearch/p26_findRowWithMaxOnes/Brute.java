import java.util.ArrayList;
import java.util.Arrays;

public class Brute {
     public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        System.out.println("The row with the maximum number of 1's is: " +
                           rowWithMax1s(matrix));
    }

     public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix) {
       
        int max=Integer.MIN_VALUE;
        int idx=-1;
        for (int i = 0; i < matrix.size(); i++) {
            int count=0;
            for (int j = 0; j < matrix.get(0).size(); j++) {
                if(matrix.get(i).get(j)==1) count++;
                
                if(max<count){
                    max=count;
                    idx=i+1;
                }

            }
            
        }

        return idx;
     }
}
