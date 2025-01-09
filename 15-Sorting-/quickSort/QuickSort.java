public class QuickSort {
   
    public static void quickSort(int[] arr, int si, int ei) {
        // Base case: if start index is greater than or equal to end index, return
        if (si >= ei) {
            return;
        }
        // Partition the array and get the pivot index
        int pIdx = partition(arr, si, ei);
        
        // Recursively sort the left sub-array
        quickSort(arr, si, pIdx - 1);
        
        // Recursively sort the right sub-array
        quickSort(arr, pIdx + 1, ei);
    }

    // Partition function: places the pivot element at the correct position
    public static int partition(int arr[], int si, int ei) {
        
        int pivot = arr[ei];
        
        // Pointer for tracking the position of smaller elements
        int i = si - 1;

        // Traverse the array from start index to end index - 1
        for (int j = si; j < ei; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++; // Move the pointer for smaller elements
                
                // Swap the current element with the element at index i
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        
        // Place the pivot in its correct position
        i++;
        int temp = pivot; 
        arr[ei] = arr[i]; 
        arr[i] = temp;    
        
       
        return i;
    }

    // Utility function to print the array
    public static void print(int[] arr) {
       
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // Print a new line
    }

    
    public static void main(String[] args) {
      
        int arr[] = {6, 3, 9, 8, 2, 5};
        
        quickSort(arr, 0, arr.length - 1);
        
        print(arr);
    }
}
