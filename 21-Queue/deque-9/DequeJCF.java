import java.util.Deque;
import java.util.LinkedList;

public class DequeJCF {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(0); // Adds 0 at the front of the deque
        deque.addLast(1);  // Adds 1 at the rear of the deque
        deque.addLast(2);  // Adds 2 at the rear of the deque

        System.out.println(deque); // Prints: [0, 1, 2]

        deque.removeFirst(); // Removes the first element (0)
        deque.removeLast();  // Removes the last element (2)
        System.out.println(deque); // Prints: [1]

        deque.addLast(2); // Adds 2 at the rear
        deque.addLast(3); // Adds 3 at the rear

        System.out.println(deque); // Prints: [1, 2, 3]

        System.out.println("Get first: " + deque.getFirst()); // Gets the first element (1)
        System.out.println("Get last: " + deque.getLast());   // Gets the last element (3)
    }
}
