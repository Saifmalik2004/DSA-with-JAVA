public class Optimize {
    public static int smallestDivisor(int[] nums, int threshold) {
        int left=1;
        int right=1000000;
        while(left<=right)
        {
            int currSum=0;
            int mid=(left+right)/2;
            for(int num:nums)
            {
                currSum+=Math.ceilDiv(num, mid);
            }
            
            if(currSum<=threshold) right=mid-1;
            else left=mid+1;
        }
        return left;
    }
    public static void main(String[] args) {
        int arr[]={3,6,7,11};

        System.out.println(smallestDivisor(arr, 8));
       
    }
}