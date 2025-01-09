

public class Pow {
    public static int pow(int x, int n) {
        if(n==1){
            return x;
        }

        return x*pow(x, n-1);
    }
    public static int optimizePow(int x, int n) {
        if(n==1){
            return x;
        }
        int halPower=optimizePow(x,n/2);
        if(x % 2 !=0){
         return x *  halPower*halPower;
        }

        return halPower*halPower;
    }
    public static void main(String[] args) {
        System.out.println(pow(8, 2));
        System.out.println(optimizePow(2, 5));
        



    }
}
