
import java.util.LinkedList;
import java.util.Queue;




public class QueueJCF {
    
public static void main(String[] args) {
    Queue<Integer> queue= new LinkedList<>();

    queue.add(0);
    queue.add(1);
    queue.add(2);

    while (!queue.isEmpty()) {
        System.out.println(queue.peek());
        queue.remove();
        
    }

}
}
