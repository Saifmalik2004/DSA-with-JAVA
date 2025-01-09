public class Greedy {
    // Function to count balanced partitions in a string
    public static int balancedPartion(String str) {
        // Get the length of the string
        int n = str.length();

        // Handle empty string
        if (n == 0) {
            return -1;
        }

        // Initialize counters for 'L', 'R', and the result
        int lCount = 0;
        int rCount = 0;
        int ans = 0;

        // Loop through each character in the string
        for (int i = 0; i < n; i++) {
            // Increment counts based on the character
            if (str.charAt(i) == 'L') {
                lCount++;
            } else {
                rCount++;
            }

            // If counts are equal, we found a balanced substring
            if (lCount == rCount) {
                ans++;
            }
        }

        // Return the total number of balanced substrings
        return ans;
    }

    public static void main(String[] args) {
        // Test the function with a sample string
        String str = "LRLRLLLRRLRR";
        System.out.println(balancedPartion(str)); // Output: 3
    }
}