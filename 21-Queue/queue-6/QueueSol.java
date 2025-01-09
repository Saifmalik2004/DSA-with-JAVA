import java.util.LinkedList;
import java.util.Queue;

public class QueueSol {

    // Function to print the first non-repeating character at each step
    public static void printNonRepeating(String str) {
        int freq[] = new int[26]; // Stores frequency of each character
        Queue<Character> q = new LinkedList<>(); // Queue to maintain the order of characters

        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // Get the current character

            q.add(ch); // Add the character to the queue
            freq[ch - 'a']++; // Update its frequency

            // Remove characters from the queue if their frequency > 1
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // If the queue is empty, print -1; otherwise, print the front of the queue
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    // Main method to test the function
    public static void main(String[] args) {
        String str = "aabcddxdbcc"; // Input string
        printNonRepeating(str); // Function call
    }
}
