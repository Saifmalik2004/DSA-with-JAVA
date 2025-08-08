
import java.util.Arrays;

public class Sol {

    public static String orderly(String str, int k) {

        if (k == 1) {
            String res = str;

            for (int i = 1; i < str.length(); i++) {
                String temp = str.substring(i) + str.substring(0, i);
                if (res.compareTo(temp) > 0) {
                    res = temp;
                }
            }
            return res;

        }
        char ans[] = str.toCharArray();
        Arrays.sort(ans);
        return new String(ans);

    }

    public static void main(String[] args) {
        System.out.println(orderly("bac", 1));
    }
}
