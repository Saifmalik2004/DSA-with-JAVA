import java.util.Arrays; // Import Arrays class for sorting

public class Greedy {
    public static void main(String[] args) {
        // Input arrays
        int a[]={4,1,8,7};
        int b[]={2,3,6,5};

        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        int minDiff=0; // Variable to store total minimum difference

        // Calculate the absolute differences between pairs
        for (int i = 0; i < a.length; i++) {
            minDiff += Math.abs(a[i]-b[i]); // Add the absolute difference to minDiff
        }

        // Output the result
        System.out.println(minDiff+" "); // Print the total minimum difference
    }
}