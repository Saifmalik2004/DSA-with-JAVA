// Brute Force Approach - O(N^2) Complexity
// Counts the number of pairs where num[i] > 2*num[j] for j > i
public class Brute {
    public static void pairArray(int num[]) {
        int count = 0; // Initialize the total count of pairs to 0
        
        // Outer loop to select the first element of the pair
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > 2*num[j]) {
                    count++; // Increment count if condition is met
                }
            }
        }
        System.out.println(count); // Output the total count of valid pairs
    }
    
    public static void main(String[] args) {
        int arr[] = {12, 5, 2, 1, 3, 6, 7};
        pairArray(arr);
    }
}