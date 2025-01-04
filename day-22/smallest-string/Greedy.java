import java.util.Arrays;

public class Greedy {
   
    public static String getSmallestString(int n, int k) {
        // Step 1: Initialize result array with 'a'
        char res[] = new char[n];
        Arrays.fill(res, 'a');

        // Step 2: Adjust k
        k -= n;

        // Step 3: Modify characters from right to left
        while (k > 0) {
            res[--n] += Math.min(25, k); // Increase character value
            k -= Math.min(25, k);       // Reduce k accordingly
        }

        // Step 4: Convert to string and return
        return String.valueOf(res);
    }
public static void main(String[] args) {

    System.out.println(getSmallestString(5, 73));
    
}

}
