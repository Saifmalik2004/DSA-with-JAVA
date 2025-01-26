public class Optimize {
    
    // Method to move all non-zero elements to the front
    public static void move(int arr[], int n) {
        int start = -1;
        
        // Find the first zero in the array
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                start = i;
                break;
            }
        }

        // If no zero is found, return
        if (start == -1) {
            return;
        }

        // Swap zero with subsequent non-zero elements
        for (int i = start + 1; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 0, 2, 0, 0, 3, 4, 5, 7, 7};
        int n = arr.length;

        // Use the optimized method to move zeroes
        move(arr, n);

        // Print the modified array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
