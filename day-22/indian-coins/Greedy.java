
import java.util.ArrayList;


public class Greedy {
    public static void main(String[] args) {
        
        int coins[]={1,2,5,10,20,50,100,500,2000};

        int amount=590;
        int count=0;
        ArrayList<Integer> ans=new ArrayList<>();
        
        for (int i = coins.length-1; i >=0; i--) {

            if(amount >=coins[i]){
                while(amount>=coins[i]){
                    count++;
                    ans.add(coins[i]);
                    amount-=coins[i];
                }
            }
            
        }

        System.out.println(count+" ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
            
        }
        System.out.println();
    }
}
