class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;   // devices in previous non-empty row
        int res = 0;

        for (int i = 0; i < bank.length; i++) {
            String s = bank[i];
            int count = 0;

            // count devices in current row
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    count++;
                }
            }

            // add beams between prev and current row
            res += (prev * count);

            // update prev only if row has devices
            if (count != 0) {
                prev = count;
            }
        }
        return res;
    }
}