
import java.util.LinkedList;
import java.util.Queue;

public class QueueSol {
    public static void interLeave(Queue<Integer> orignal ) {
        int size= orignal.size();
        Queue<Integer> firstHalf= new LinkedList<>();
        for (int i = 0; i < size/2; i++) {
           firstHalf.add(orignal.remove()) ;
        }

        while(!firstHalf.isEmpty()){
            orignal.add(firstHalf.remove());
            orignal.add(orignal.remove());
        }
          
    }
public static void main(String[] args) {
    Queue<Integer> original= new LinkedList<>();

    original.add(1);
    original.add(2);
    original.add(3);
    original.add(4);
    original.add(5);
    original.add(6);
    original.add(7);
    original.add(8);
    original.add(9);
    original.add(10);
    
    
    interLeave(original); //1 6 2 7 3 8 4 9 5 10 
    
    while(!original.isEmpty()){
        System.out.print(original.remove()+" ");
    }
    System.out.println();
   

}
}
