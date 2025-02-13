public class Optimize {
  
    public static int findRoatation(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE; 
        int roationNum=0;
        while (low <= high) {
            int mid = low + (high - low) / 2; 

            if (arr[low] <= arr[high]) {
                if(arr[low] <min){
                    min=arr[low];
                    roationNum=low;
                }
                break;
            }

            if (arr[low] <= arr[mid]) {
                 if(arr[low] <min){
                    min=arr[low];
                    roationNum=low;
                }
                 
                low = mid + 1; 
            } else { 
                high = mid - 1;
                if(arr[mid] < min){
                    min=arr[mid];
                    roationNum=mid;
                }
            }
        }

        return roationNum; 
    }

    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 1, 2, 3, 4, 5, 6};

        
        System.out.println(findRoatation(arr));
    }
}
