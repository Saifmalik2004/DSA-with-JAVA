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

    // Another approach to rearrange the array
    public static void alternate(int arr[]) {
        int n = arr.length;
        int ans[] = new int[n]; // Temporary array to hold rearranged values
        int posI = 0; // Pointer for positive indices
        int negI = 1; // Pointer for negative indices

        // Place positive and negative numbers in their respective positions
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                ans[posI] = arr[i];
                posI += 2; // Move to the next positive index
            } else {
                ans[negI] = arr[i];
                negI += 2; // Move to the next negative index
            }
        }

        // Transfer rearranged elements back to the original array
        for (int i = 0; i < n - 2; i++) {
            arr[2 * i] = ans[i];
            arr[2 * i + 1] = ans[i + 1];
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, -2, -3, -1, 3, 4};
        alternate(arr); // Call the alternate method
    }
}
