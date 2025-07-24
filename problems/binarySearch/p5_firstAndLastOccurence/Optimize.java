public class Optimize {

    // Function to find the first and last index of target 'x' in a sorted array
    public static int[] searchFirstAndLast(int arr[], int x) {

        int n = arr.length;
        int ans[] = {-1, -1}; // By default, assume target not found

        int low = 0;
        int high = n - 1;

        // Find the first occurrence of x
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < x) {
                low = mid + 1; // Move to right part
            } else {
                if (arr[mid] == x) ans[0] = mid; // Possible answer found
                high = mid - 1; // Move left to check for earlier occurrence
            }
        }

        low = 0;
        high = n - 1;

        // Find the last occurrence of x
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                high = mid - 1; // Move to left part
            } else {
                if (arr[mid] == x) ans[1] = mid; // Possible answer found
                low = mid + 1; // Move right to check for later occurrence
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int arr[] = {1, 1, 1, 2, 2, 3, 4, 4, 4};

        int target = 1;

        int result[] = oc(arr, target);

        System.out.println("First Occurrence at index: " + result[0]);
        System.out.println("Last Occurrence at index: " + result[1]);

        if (result[0] != -1) {
            int count = result[1] - result[0] + 1;
            System.out.println("Total count of " + target + " is: " + count);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }

    public static int[] oc(int arr[],int key){
        return new int[]{first(arr, key),last(arr, key)};
    }
    public static int first(int arr[],int key) {
        int low=0;
        int high=arr.length-1;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=key){
                if(arr[mid]==key) ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
        
    }
    public static int last(int arr[],int key) {
        int low=0;
        int high=arr.length-1;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=key){
                if(arr[mid]==key) ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return ans;
        
    }
}
