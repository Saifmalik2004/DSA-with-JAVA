

public class Solution {
    public static int count(int nums[],int n,int target) {
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

        return (ans2-ans1)==0? 0:(ans2-ans1+1);
    }
    public static void main(String[] args) {
        int arr[]={1,1,1,2,2,3,4,4,4};

       
        System.out.println(count(arr, arr.length, 4));
    }
}
