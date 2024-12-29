
import java.util.Deque;
import java.util.LinkedList;




public class DequeSol {
    static class Queue{

      
    Deque<Integer> deque= new LinkedList<>();

    public boolean isEmpty() {
        return deque.isEmpty();
    }
    
    public void add(int data) { 
        deque.addLast(data);
    }

    public  int remove() { 
        return deque.removeFirst();
    }
    public  int peek() { 
        return deque.getFirst();
    }

    }
public static void main(String[] args) {
    Queue s= new Queue();
 
    s.add(1);
    s.add(2);
    s.add(3);
    s.add(4);
    s.add(5);
System.out.println(s.peek());
    while(!s.isEmpty()){
        System.out.print(s.remove()+" ");
    }
    
}
}
