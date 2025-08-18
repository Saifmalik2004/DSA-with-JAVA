public class Solution {
   
        public static int minDeletionSize(String[] strs) {
            int count = 0;
            for (int i = 0; i < strs[0].length(); i++) {
                for (int j = 0; j < strs.length - 1; j++) {
                    if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                        count++;
                        break;
                    }
                }
            }
            return count;
        }
    

    public static void main(String[] args) {
        

        // Test case 1
        String[] strs1 = {"cba", "daf", "ghi"};
        System.out.println("Output 1: " + minDeletionSize(strs1));
        // Expected: 1

        // Test case 2
        String[] strs2 = {"a", "b"};
        System.out.println("Output 2: " + minDeletionSize(strs2));
        // Expected: 0

        // Test case 3
        String[] strs3 = {"zyx", "wvu", "tsr"};
        System.out.println("Output 3: " + minDeletionSize(strs3));
        // Expected: 3
    }
}
