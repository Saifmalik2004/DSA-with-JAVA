import java.util.ArrayList;

public class Variety2 {

    // Method to rearrange array with unequal counts of positive and negative numbers
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

        // Handle cases where positives and negatives are unequal in count
        if (pos.size() > neg.size()) {

            // Place positives on even indices, negatives on odd indices
            for (int i = 0; i < neg.size(); i++) {
                a[2 * i] = pos.get(i);
                a[2 * i + 1] = neg.get(i);
            }
            // Add remaining positive numbers
            int index = neg.size() * 2;
            for (int j = neg.size(); j < pos.size(); j++) {

                a[index] = pos.get(j);
                index++;

            }
        } else {
            // Place positives on even indices, negatives on odd indices
            for (int i = 0; i < pos.size(); i++) {

                a[2 * i] = pos.get(i);
                a[2 * i + 1] = neg.get(i);

            }
            // Add remaining negative numbers
            int index = pos.size() * 2;
            for (int j = pos.size(); j < neg.size(); j++) {

                a[index] = neg.get(j);
                index++;
                
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, -2, -3, -1, 4, 22, 3, 4};
        alternateNUmber(arr); // Call the alternateNUmber method
        for (int elem : arr) { // Print the rearranged array
            System.out.print(elem + " ");
        }
    }
}
