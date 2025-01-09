import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSol {
    public static void reverse(Queue<Integer> original) {
        // Step 1: Initialize a stack
        Stack<Integer> s = new Stack<>();

        // Step 2: Transfer all elements from the queue to the stack
        while (!original.isEmpty()) {
            s.add(original.remove());
        }

        // Step 3: Transfer all elements back to the queue from the stack
        while (!s.isEmpty()) {
            original.add(s.pop());
        }
    }

    public static void main(String[] args) {
        // Step 4: Create a queue and add elements
        Queue<Integer> original = new LinkedList<>();
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

        // Step 5: Reverse the queue using the interLeave function
        reverse(original);

        // Step 6: Print the reversed queue
        while (!original.isEmpty()) {
            System.out.print(original.remove() + " ");
        }
        System.out.println();
    }
}
