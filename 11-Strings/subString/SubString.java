public class SubString {

    // Method to extract a substring from the input string, starting from index 'si' to 'ei'
    public static String SubString(String str, int si, int ei) {
        String subStr = "";  // Initialize an empty string to hold the substring

        // Loop from the starting index 'si' to the ending index 'ei' (exclusive)
        for (int i = si; i < ei; i++) {
            subStr += str.charAt(i);  // Append each character to the substring
        }

        return subStr;  // Return the resulting substring
    }

    public static void main(String[] args) {
        String str = "saifmalik";  // Define the main string

        // Call the SubString method and print the result, extracting a substring from index 0 to 4
        System.out.println(SubString(str, 0, 4));  // Expected output: "saif"
    }
}
