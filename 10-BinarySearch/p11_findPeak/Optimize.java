public class Optimize {
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        
        // Base case: If array has only one element, it's the peak
        if (n == 1) return 0;
        
        // Check if first element is a peak
        if (arr[0] > arr[1]) return 0;
        
        // Check if last element is a peak
        if (arr[n - 1] > arr[n - 2]) return n - 1;
        
        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if mid is a peak
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            
            // If left neighbor is smaller, move right
            if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } 
            // Otherwise, move left
            else {
                high = mid - 1;
            }
        }
        
        return -1; // This should never be reached
    }

    public static void main(String[] args) {
        int arr[]={1,2,1,5,1};
        System.out.println(findPeakElement(arr));
        Math.sqrt(2);
    }
}