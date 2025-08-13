public class UppercaseLetter { 
    public static String uppercaseLetter(String str) { 
        StringBuilder sb = new StringBuilder(""); 
        // Capitalize the first character of the string
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch); 

        // Loop through the rest of the string
        for (int i = 1; i < str.length(); i++) {
            
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i)); 
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                // Append the character as it is if it's not after a space
                sb.append(str.charAt(i));
            }
        }

        return sb.toString(); 
    }

    public static void main(String[] args) { 
        String str = "my name is saif malik ";
        
        System.out.println(uppercaseLetter(str)); 
        System.out.println('z'-'a'); 
    }
}
