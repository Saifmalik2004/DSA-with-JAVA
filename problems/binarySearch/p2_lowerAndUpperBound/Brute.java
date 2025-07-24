
public class Brute {
    public static int lowBound(int arr[],int target) {

        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>=target ) {
                ans=mid;
                high=mid-1;
            }
           
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int upBound(int arr[],int target) {

        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>target ) {
                ans=mid;
                high=mid-1;

            }
            
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={3,5,5,5,5,5};
        System.out.println(lowBound(arr, 4));
        System.out.println(upBound(arr, 4));
    
    }
}
