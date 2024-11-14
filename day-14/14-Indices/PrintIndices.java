public class PrintIndices {
    // Recursive function to find indices of a key in an array
    public static void printindices(int[] arr ,int key,int idx) {
        // Base case: If we've checked all elements, stop recursion
        if(idx == arr.length) {
            return;
        }

        // If the current element matches the key, print the index
        if(arr[idx] == key) {
            System.out.println(idx);
        }

        // Recursively call the function for the next index
        printindices(arr, key, idx + 1);
    }

    public static void main(String[] args) {
        // Example array and key
        int[] arr = {1, 2, 3, 5, 2, 7, 2, 9, 8, 2};
        printindices(arr, 2, 0); // Find indices of 2 in the array
    }
}
