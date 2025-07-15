import java.util.Arrays;

public class Brute {
    public static void maxConsecutive(int arr[]) {
        int n = arr.length;
        int maxLen = 1; // Tracks the maximum sequence length
        Arrays.sort(arr); // Sort the array to simplify consecutive checking

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            int len = 1; // Start a new sequence with the current element

            // Search for consecutive elements in the sorted array
            while (search(arr, n, curr + 1)) {
                curr++;
                len++; // Increment sequence length
            }
            maxLen = Math.max(maxLen, len); // Update maximum sequence length
        }

        System.out.println(maxLen); // Print the result
    }

    // Helper function to check if an element exists in the array
    public static boolean search(int arr[], int n, int key) {
        for (int i = 0; i < n; i++) {
            if (key == arr[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {102, 4, 100, 1, 101, 3, 2, 1};
        maxConsecutive(arr);
    }

    public static void set(int arr[][]) {
        int n=arr.length;
        int m=arr[0].length;
        int col0=1;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]==0){
                  
                     arr[i][0]=0;

                     if(j!=0){

                         arr[0][j]=0;
                     }else{
                        col0=0;
                     }
                   
                }
            }
        }


       for (int i = 1; i < n; i++) {
        for (int j = 1; j < n; j++) {
            if(arr[i][j] !=0){
                if(arr[i][0]==0||arr[0][j]==1){
                    arr[i][j]=0;
                }
            }
            
        }
           
       }

        
        
    }
}
