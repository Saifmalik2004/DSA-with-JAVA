
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

        System.out.println(findmis(arr, 2));
    }

    public static int findmis(int arr[],int k){
        int num=1;
        int i=0;
        while(i<arr.length&&k>0){
            if(arr[i]==num){
               
                i++;
            }else{
                k--;
                
            }
             num++;
        }
        return num-1;
    }
}
