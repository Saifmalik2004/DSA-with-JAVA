
public class Optimize {
    public static long nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i);  // Multiply by decreasing values of n
            res /= (i + 1);  // Divide by increasing values of r
        }
        return res;
    }
    public static int pascalTriangle(int r, int c) {
        return (int) nCr(r - 1, c - 1);
    }

    public static void main(String[] args) {
        //     1 
        //    1 1
        //   1 2 1
        //  1 3 3 1
        // 1 4 6 4 1
        int r=5,c=3;

        System.out.println(pascalTriangle(r, c));
    }
}
