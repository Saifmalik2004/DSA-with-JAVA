
public class Optimize {
    public static int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int ans1=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]<target ) {
                low=mid+1;
            }
            else{
                if(nums[mid]==target)ans1=mid;
                high=mid-1;
                
            }
        }
         low=0;
         high=nums.length-1;
         int ans2=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            
            if(nums[mid]>target){
                high=mid-1;
            }
            else{
                if(nums[mid]==target ) ans2=mid;
                low=mid+1;
            }
        }

        return new int[]{ans1,ans2};
        
    }

    public static void main(String[] args) {

        int arr[]={1,1,1,2,2,3,4,4,4};
       int res[]= searchRange(arr, 5);
       int ans=res[1]-res[0];
      
       System.out.println(ans);
    }
}
