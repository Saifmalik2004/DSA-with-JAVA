public class Optimize {
    public static int powerExpo(int b, int expo, int m) {
        long base = b; // Use long to prevent overflow
        long ans = 1; // Use long to track intermediate values
        
        while (expo > 0) {
            if (ans > m) return 2; // Early termination if exceeding m
            
            if (expo % 2 == 1) { // If exponent is odd
                ans *= base;
                if (ans > m) return 2; // Check overflow
                expo--;
            } else { // If exponent is even
                base *= base;
                if (base > m) return 2; // Check overflow
                expo /= 2;
            }
        }
        
        if (ans == m) return 1;
        return 0;
    }

    public static int findNthRoot(int n, int m) {
        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = powerExpo(mid, n, m);

            switch (val) {
                case 1 -> {
                    return mid; // Found the nth root
                }
                case 0 -> low = mid + 1; // Increase low
                default -> high = mid - 1; // Decrease high
            }
        }

        return -1; // No valid root found
    }

    public static void main(String[] args) {
        System.out.println(findNthRoot(9, 1953125)); // Should return 5
    }
}
