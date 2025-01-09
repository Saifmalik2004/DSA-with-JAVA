public class StringCompression {
    public static String StringCompression(String str) { 
        StringBuilder newString = new StringBuilder("");
        
        // Loop through each character in the input string
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1; 

            // Check for consecutive repeating characters
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++; 
                i++; 
            }
            
            // Append the current character to the compressed string
            newString.append(str.charAt(i));
            
            // Append the count if it's greater than 1
            if (count > 1) {
                newString.append(count.toString());
            }
        }
        
       
        return newString.toString();
    }

    public static void main(String[] args) { 
        String str = "aabbbaddd";
        System.out.println(StringCompression(str)); 
    }
}
