public class Brute {

    // Finds the index to insert 'target' in sorted array 'arr'
    public static int findInsertPos(int arr[], int target) {

        int low=0;
        int high=arr.length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>=target ) {
                high=mid-1;
            }
           
            else{
                low=mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4};
        System.out.println(findInsertPos(arr, 5));  // Output: 1
    }

    
}
