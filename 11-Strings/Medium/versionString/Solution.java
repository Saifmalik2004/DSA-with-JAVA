public class Solution {
    
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n = version1.length(), m = version2.length();
        
        while (i < n || j < m) {
            int num1 = 0;
            int num2 = 0;
            
            // extract number from version1
            while (i < n && version1.charAt(i) != '.') {
                num1 = (num1 * 10) + (version1.charAt(i) - '0');
                i++;
            }
            
            // extract number from version2
            while (j < m && version2.charAt(j) != '.') {
                num2 = (num2 * 10) + (version2.charAt(j) - '0');
                j++;
            }
            
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
            
            // skip '.' character
            i++;
            j++;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        String v1 = "1.01";
        String v2 = "1.001";
        String v3 = "1.0";
        String v4 = "1.0.1";

        System.out.println(v1 + " vs " + v2 + " → " + sol.compareVersion(v1, v2)); // 0
        System.out.println(v3 + " vs " + v4 + " → " + sol.compareVersion(v3, v4)); // -1
        System.out.println(v4 + " vs " + v3 + " → " + sol.compareVersion(v4, v3)); // 1
    }
}
