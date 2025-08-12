public class Optimize {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            result.append(reversedWord).append(" ");
        }
        result.deleteCharAt(result.length() - 1);  // Remove the extra space
        return result.toString();
    }

    public static void main(String[] args) {
        
        System.out.println(reverseWords("Let's take LeetCode contest"));
        // Expected: "s'teL ekat edoCteeL tsetnoc"
    }
}
