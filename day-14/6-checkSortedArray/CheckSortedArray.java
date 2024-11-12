public class CheckSortedArray {

    
    public static boolean checkSortedArray(int[] num, int i) {
        // Base case: if we reach the last element, the array is sorted
        if (i == num.length - 1) {
            return true;
        }

        // If the current element is greater than the next one, array is not sorted
        if (num[i] > num[i + 1]) {
            return false;
        }

        // Recursive call to check the rest of the array
        return checkSortedArray(num, i + 1);
    }

    public static void main(String[] args) {
       
        int[] array = {1, 2, 3, 4};
        
       
        boolean isSorted = checkSortedArray(array, 0);
        System.out.println("Is the array sorted? " + isSorted);
    }
}
