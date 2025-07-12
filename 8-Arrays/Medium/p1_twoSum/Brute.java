/**
 * Brute force approach to find two numbers that sum up to k.
 * Time Complexity: O(N^2), Space Complexity: O(1)
 */
public class Brute {
    public static void twoSum(int arr[], int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 0};
        int k = 9;
        twoSum(arr, k);
    }
}
