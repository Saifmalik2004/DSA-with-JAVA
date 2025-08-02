
class Solution {

    public int compress(char[] chars) {
        int count = 1;
        char cur = chars[0];
        int idx = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != cur) {
                chars[idx++] = cur;
                if (count > 1) {
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[idx++] = c;
                    }
                }
                count = 1;
                cur = chars[i];
            } else {
                count++;
            }
        }
        chars[idx++] = cur;
        if (count > 1) {
            for (char c : Integer.toString(count).toCharArray()) {
                chars[idx++] = c;
            }
        }

        return idx;
    }
}
