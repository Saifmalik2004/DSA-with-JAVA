public class RemoveDuplicateStr {

    // Recursive function to remove duplicates from the string
    public static void removeDuplicateStr(String str, StringBuilder newstr, int idx, boolean map[]) {
        // Base condition: if we reach the end of the string, print the result and return
        if (idx == str.length()) {
            System.out.println(newstr);  // Print the final string with unique characters
            return;
        }

        // Get the current character at the given index
        char current = str.charAt(idx);

        // Check if this character has already been added to newstr
        if (map[current - 'a']) {  // If it's true, the character is a duplicate
            // Skip this character and move to the next index
            removeDuplicateStr(str, newstr, idx + 1, map);
        } else {
            // Mark the character as added in the map array
            map[current - 'a'] = true;

            // Append this unique character to the new string
            removeDuplicateStr(str, newstr.append(current), idx + 1, map);
        }
    }

    public static void main(String[] args) {
        // Example string to remove duplicates from
        String str = "saifmalik";

        // Call the recursive function with initial values:
        // new StringBuilder to build the unique string,
        // starting index 0, and a boolean array to track characters
        removeDuplicateStr(str, new StringBuilder(""), 0, new boolean[26]);
    }
}
