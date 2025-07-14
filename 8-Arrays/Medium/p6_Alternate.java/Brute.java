import java.util.ArrayList;

public class Brute {

    // Method to rearrange array into alternating positive and negative numbers
    public static void alternateNUmber(int[] a) {
        int n = a.length;
        ArrayList<Integer> pos = new ArrayList<>(); // List to store positive numbers
        ArrayList<Integer> neg = new ArrayList<>(); // List to store negative numbers

        // Segregate the array into positive and negative numbers
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                pos.add(a[i]);
            } else {
                neg.add(a[i]);
            }
        }

        // Rearrange numbers: positives on even indices, negatives on odd indices
        for (int i = 0; i < n / 2; i++) {
            a[2 * i] = pos.get(i);       // Add positive numbers at even indices
            a[2 * i + 1] = neg.get(i);  // Add negative numbers at odd indices
        }
    }

    
    public static void main(String[] args) {
        int arr[] = {1, -2, -3, -1, 3, 4};
        alternateNUmber(arr); // Call the alternate method

        for (int elem : arr) {
            System.out.print(elem+" ");
            
        }
    }
}
