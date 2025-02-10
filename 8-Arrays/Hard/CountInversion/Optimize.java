
public class Optimize {
    public static int mergeSort(int arr[], int start, int end) {
        
        int count=0;

        // Base case: if the segment has one or zero elements, it's already sorted
        if (start >= end) {
            return count;
        }

        // Calculating the middle index
        int middle = start + (end - start) / 2;

        // Recursive calls to sort the left and right halves
        count+=mergeSort(arr, start, middle);
        count+=mergeSort(arr, middle + 1, end);

        // Merging the sorted halves
        count+=merge(arr, start, end, middle);

        return count;
    }

    // Merge function to combine two sorted halves
    public static int merge(int[] arr, int start, int end, int middle) {
        int temp[] = new int[end - start + 1]; // Temporary array to store merged result

        int i = start;        // Pointer for the left half
        int j = middle + 1;   // Pointer for the right half
        int k = 0;            // Pointer for the temporary array
        int count=0;
        // Compare elements from both halves and place the smaller one into temp
        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                
                i++;
            } else {
                count+=(middle-i+1);
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from the left half, if any
        while (i <= middle) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the right half, if any
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copy the merged array back into the original array
        for (i = start, k = 0; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

        return count;
    }

    public static int countInversion(int arr[]) {
        int n=arr.length;
        return mergeSort(arr, 0, n-1);
    }
    public static void main(String[] args) {
        int arr[]= {12,5,2,1,3,6,7};
        
        System.out.println(countInversion(arr));
    }

}
