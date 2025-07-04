import java.util.ArrayList;

public class Brute {
    
    // Method to move all non-zero elements to the front
    public static void move(int arr[]) {
        int n = arr.length;
        
        // ArrayList to store non-zero elements
        ArrayList<Integer> li = new ArrayList<>();
        
        // Add all non-zero elements to the list
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                li.add(arr[i]);
            }
        }
        
        // Place non-zero elements at the front, remaining positions are set to zero
        for (int i = 0; i < n; i++) {
            if (i < li.size()) {
                arr[i] = li.get(i);
            } else {
                arr[i] = 0;
            }
        }
    }

   

    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 2, 0, 0, 3, 4, 5, 7, 7, 0};
        int n = arr.length;

        // Use the optimized method to move zeroes
        move(arr);

        // Print the modified array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
