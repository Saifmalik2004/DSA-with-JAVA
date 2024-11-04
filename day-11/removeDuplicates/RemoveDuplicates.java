public class RemoveDuplicates {
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            // Check if the character is already in result
            if (result.indexOf(String.valueOf(currentChar)) == -1) {
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        System.out.println(removeDuplicates(input));  // Output: "progamin"
    }
}
