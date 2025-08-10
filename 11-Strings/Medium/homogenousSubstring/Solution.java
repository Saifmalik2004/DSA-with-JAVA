public class Solution {
    
        public static int countHomogenous(String s) {
            final int MOD = 1_000_000_007;

            int result = 1;
            int len = 1;

            for (int i = 1; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == s.charAt(i - 1)) {
                    len++;
                } else {
                    len = 1;
                }
                result = (result + len) % MOD;
            }
            return result;
        }
    

    public static void main(String[] args) {
        

        String s1 = "abbcccaa";
        System.out.println("Input: " + s1);
        System.out.println("Homogeneous substrings count: " + countHomogenous(s1));

        String s2 = "zzzzz";
        System.out.println("Input: " + s2);
        System.out.println("Homogeneous substrings count: " + countHomogenous(s2));

        String s3 = "abc";
        System.out.println("Input: " + s3);
        System.out.println("Homogeneous substrings count: " + countHomogenous(s3));
    }
}
