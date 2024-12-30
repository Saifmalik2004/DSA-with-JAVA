import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
public class DequeSol {

    public static void reverseKElements(Queue<Integer> original,int k){
        Deque<Integer> q1= new LinkedList<>();
        
        
        for (int i = 0; i < k; i++) {
            q1.addFirst(original.remove());
            
        }
        while(!original.isEmpty()){
            q1.addLast(original.remove());
        }

        while(!q1.isEmpty()){
            original.add(q1.removeFirst());
        }

    

    }

    public static void main(String[] args) {
    
        Queue<Integer> queue= new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

        reverseKElements(queue, 5);

        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }
}
}
