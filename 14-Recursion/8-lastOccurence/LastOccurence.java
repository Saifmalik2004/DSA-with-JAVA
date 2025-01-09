public class LastOccurence{
    public static int lastOccurenceFinder(int arr[], int key, int i) {
        // Base Case: If we reach the end of the array, return -1 (no occurrence found)
        if (i == arr.length - 1) {
            return -1;
        }
    
        // Recursive Case: Move towards the end of the array
        int isFound = lastOccurenceFinder(arr, key, ++i);
    
        // After recursion, check if the key matches and if it's the first match from the end
        if (arr[i] == key && isFound == -1) {
            return i;
        }
        
        // Return the found index or the last known match
        return isFound;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,1};
        System.out.println(lastOccurenceFinder(arr, 7, 0));
    }
}