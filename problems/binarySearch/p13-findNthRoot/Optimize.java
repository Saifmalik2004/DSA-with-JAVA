public class Optimize {



    public static void main(String[] args) {
        System.out.println(nthRoot(9, 1953125)); // Output: 5 (Because 5^9 = 1953125)
    }

    // Helper function to check if mid^n == m
    public static int checkNthPower(int expo, int base, int target) {
        long result = 1;
        long currBase = base;

        while (expo > 0) {
            if (result > target) return 2;  // Early break: result is too big!

            if (expo % 2 == 1) {
                result *= currBase;
                if (result > target) return 2;  // Check again after multiplication
                expo--;
            } else {
                currBase *= currBase;
                if (currBase > target) return 2;  // Avoid overflow
                expo /= 2;
            }
        }

        if (result == target) return 1;  // Exact match
        else return 0;             // Less than m
    }

    // Binary search to find the nth root of m
    public static int nthRoot(int expo, int target) {

        int low = 1;
        int high = target;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int status = checkNthPower(expo, mid, target);

            switch (status) {
                case 1 -> {
                    return mid;  // Found the exact root
                }
                case 0 -> {
                    low = mid + 1;  // Go right
                }
                case 2 -> {
                    high = mid - 1; // Go left
                }
            }
        }

        return -1;  // No integer root found
    }

}