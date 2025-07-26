
public class Brute {
    public static int minDiv(int[] arr, int limit) {
        int n = arr.length; //size of array.
        if(n > limit) return -1;
        int max = 0; 
        for (int item : arr) {
            max = Math.max(item, max);
        }

       
        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (computeSum(arr, mid)<=limit) {
                high = mid - 1; // Try a smaller speed
            } else {
                low = mid + 1; // Increase speed
            }
        }

        return low;
    }

    public static int computeSum(int arr[], int num) {
        long sum = 0; // Use long to prevent overflow in summation
        for (int elem : arr) {
            sum += Math.ceil((double)(elem) / (double)(num));
        }
        return (int)sum ;
    }
    public static void main(String[] args) {
        int arr[]={3,6,7,11};

        System.out.println(minDiv(arr, 8));
       
    }

}
