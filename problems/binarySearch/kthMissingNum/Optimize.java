
public class Optimize {


        
        public static int findKthPositive(int[] arr, int k) {
            int n = arr.length;
            int low = 0;
            int high = n - 1;
    
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if ((arr[mid] - ( mid + 1)) < k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return k + high+1;
        }
    

    public static void main(String[] args) {

        int arr[]={1,2,4,5,7};

        findKthPositive(arr, 2);
    }
}
