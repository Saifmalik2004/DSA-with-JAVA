class Solution {
    public boolean isVowel (char c){
        return (c =='a'||c=='e'|| c =='i'||c=='o'|| c=='u');
    }
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int res = 0;

        for (int j = 0; j < n; ++j) {
            int c = 0, v = 0;
            for (int i = j; i < n; ++i) {
                if (isVowel(s.charAt(i)))
                    v += 1;
                else
                    c += 1;

                if (c == v && (c * v) % k == 0)
                    res += 1;
            }
        }
        return res;
    }
}