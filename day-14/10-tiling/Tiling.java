

public class Tiling {
    public static int tiling(int n) {
        if(n==1 || n==0){
            return 1;
        }
        return tiling(n-1)+tiling(n-2);
        
    }
    public static void main(String[] args) {
        System.out.println(tiling(4));
    }
}
