public class DuplicateOptimize {
    public static int search(int[] A, int key) {
        int low=0;
        int high=A.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(A[mid]==key) return mid;
            if(A[mid]== A[low]&& A[mid]==A[high]){
                low++;
                high--;
                continue;
            }
            if(A[low]<=A[mid]){
                if(A[low]<=key && A[mid]>=key){
                    high=mid-1;
                }else{
                    low=mid+1;
                    
                }
            }else{
                if(A[mid]<=key && A[high]>=key){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }

        }

        return -1;
    }   
    public static void main(String[] args) {
        int arr[]={7,7,7, 8, 9,9, 1, 2, 3, 4, 5, 6,6};

        System.out.println(search(arr, 6));
    }
}
