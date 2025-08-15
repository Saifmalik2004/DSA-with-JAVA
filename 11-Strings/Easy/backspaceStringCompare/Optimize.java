public class Optimize {

    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skips = 0, skipt = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skips++;
                    i--;
                } else if (skips > 0) {
                    skips--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipt++;
                    j--;
                } else if (skipt > 0) {
                    skipt--;
                    j--;
                } else {
                    break;
                }
            }

            char first = (i < 0) ? '\0' : s.charAt(i);
            char second = (j < 0) ? '\0' : t.charAt(j);

            if (first != second) return false;

            i--;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
       
        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##", "c#d#")); // true
        System.out.println(backspaceCompare("a#c", "b"));     // false
    }
}
