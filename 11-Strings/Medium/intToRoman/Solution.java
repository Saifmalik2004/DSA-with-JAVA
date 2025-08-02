
public class Solution {

    public static String calculate(int digit) {

        int map[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String roman[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            int times = digit / map[i];

            while (times > 0) {
                ans.append(roman[i]);
                times--;
            }
            digit %= map[i];

        }

        return ans.toString();

    }

    public static void main(String[] args) {
        System.out.println(calculate(8));
    }
}
