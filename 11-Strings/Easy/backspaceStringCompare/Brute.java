public class Brute {

    public static boolean backspaceCompare(String s, String t) {
        int n = s.length();
        int m = t.length();
        return buildString(s, n).equals(buildString(t, m));
    }

    private static String buildString(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != '#') {
                res.append(ch);
            } else if (!res.isEmpty()) {
                res.deleteCharAt(res.length() - 1);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
       

        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##", "c#d#")); // true
        System.out.println(backspaceCompare("a#c", "b"));     // false
    }
}
