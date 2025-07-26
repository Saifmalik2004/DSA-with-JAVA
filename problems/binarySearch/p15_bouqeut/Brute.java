
public class Brute {

    public static int minDayBloom(int[] days, int m, int k) {
        long val = (long) m * k;
        int n = days.length; // Size of the array
        if (val > n) {
            return -1; // Impossible case.
        }        // Find maximum and minimum:
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < days.length; i++) {
            max = Math.max(max, days[i]);
            min = Math.min(min, days[i]);
        }

        for (int i = min; i <= max; i++) {

            if (possible(days, i, m, k)) {
                return i;
            }

        }
        return -1;

    }

    public static boolean possible(int days[], int day, int m, int flower) {
        int count = 0;
        int noOFBouquet = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] <= day) {
                count++; // Valid flower for bouquet
                if (count == flower) {
                    noOFBouquet++; // Bouquet formed
                    count = 0; // Reset count
                }
            } else {
                count = 0; // Reset if broken sequence
            }
        }

        return noOFBouquet >= m; // Check if required bouquets can be made
    }

    public static void main(String[] args) {
        int days[] = {7, 7, 7, 7, 11, 12, 13};

        System.out.println(minDayBloom(days, 2, 3));
        System.out.println(3 / 2);
    }
}
