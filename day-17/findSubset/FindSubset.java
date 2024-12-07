public class FindSubset {
    // Recursive function to find all subsets of a given string
    public static void subsetFinder(String str, String ans, int i) {
        // Base case: when the index reaches the end of the string
        if (i == str.length()) {
            // If the subset (ans) is empty, print "null"
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                // Otherwise, print the subset
                System.out.println(ans); 
            }
            return; // Exit the recursive function
        }

        // Recursive call: include the current character in the subset
        subsetFinder(str, ans + str.charAt(i), i + 1);

        // Recursive call: exclude the current character from the subset
        subsetFinder(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc"; 

        // Call the subsetFinder function with the input string, an empty subset (ans), and starting index 0
        subsetFinder(str, "", 0);
    }
}
