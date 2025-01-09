

public class FirstOccurence {
    public static int findFirst(int[] arr, int key, int i) {
        // Base case: if the current element matches the key, return the index
        if (arr[i] == key) {
            return i;
        }
        // If we reach the end of the array and haven't found the key, return -1
        else if (i == arr.length - 1) {
            return -1;
        }
        // Recursive call to check the next index
        return findFirst(arr, key, i + 1);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,7,67,8,7};
        System.out.println(findFirst(arr, 7, 0));
        
       
    }
}
