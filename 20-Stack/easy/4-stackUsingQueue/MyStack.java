import java.util.Queue;
import java.util.LinkedList;

public class MyStack {

    private Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
    }
    
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        // Rotate the queue to put the new element in front
        for (int i = 1; i < size; i++) {
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top());   // 30
        System.out.println("Pop element: " + stack.pop()); // 30
        System.out.println("Top after pop: " + stack.top()); // 20
        System.out.println("Is stack empty? " + stack.empty()); // false
        
        stack.pop();
        stack.pop();
        
        System.out.println("Is stack empty after popping all? " + stack.empty()); // true
    }
}
