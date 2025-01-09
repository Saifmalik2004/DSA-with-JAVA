

public class SwapTwoNum {
    public static void swap(int a, int b){
         System.out.println("before"+" a = "+ a +", b = "+b);
         a=a^b;
         b=a^b;
         a=a^b;
         System.out.println("after"+" a = "+ a +", b = "+b);


    }
    public static void main(String[] args) {
        swap(2, 4);
    }
}
