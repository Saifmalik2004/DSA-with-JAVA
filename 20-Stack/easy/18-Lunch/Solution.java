public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zero = 0, one = 0;

        for (int n : students) {
            if (n == 0) zero++;
            else one++;
        }

        for (int n : sandwiches) {
            if (n == 0) {
                if (zero == 0) return one;
                zero--;
            } else {
                if (one == 0) return zero;
                one--;
            }
        }

        return zero > one ? zero : one;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};
        System.out.println("Test Case 1 - Students unable to eat: " + solution.countStudents(students1, sandwiches1));

        // Test case 2
        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};
        System.out.println("Test Case 2 - Students unable to eat: " + solution.countStudents(students2, sandwiches2));
    }
}
