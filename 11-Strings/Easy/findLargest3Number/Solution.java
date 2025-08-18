class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        
        for (int i = 0; i < num.length() - 2; i++) {
            // Check if 3 consecutive chars are same
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String triplet = num.substring(i, i + 3);
                // Compare lexicographically for max
                if (triplet.compareTo(ans) > 0) {
                    ans = triplet;
                }
            }
        }
        
        return ans;
    }
}
