public class QueueLL {

    // Node class representing each element in the linked list
    public static class Node {
        int data;       // Data stored in the node
        Node next;      // Pointer to the next node

        // Constructor to initialize a node with the given data
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Size of the queue (optional for tracking)
    public static int size;

    // Queue class containing the linked list logic
    static class Queue {
        static Node head = null;  // Pointer to the front of the queue
        static Node tail = null;  // Pointer to the rear of the queue

        // Method to check if the queue is empty
        public static boolean isEmpty() {
            return head == null && tail == null;  // Queue is empty if both head and tail are null
        }

        // Method to get the value at the front of the queue without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");  // If queue is empty, display a message
                return -1;  // Return -1 to indicate empty queue
            }
            return head.data;  // Return the data at the head (front) of the queue
        }

        // Method to add (enqueue) a new element to the queue
        public static void add(int data) {
            Node newNode = new Node(data);  // Create a new node with the given data
            if (head == null) {             // If the queue is empty
                head = tail = newNode;      // Set both head and tail to the new node
                return;
            }
            tail.next = newNode;  // Link the new node to the current tail
            tail = newNode;       // Update the tail pointer to the new node
        }

        // Method to remove (dequeue) an element from the queue
        public static int deque() {
            if (isEmpty()) {  // If the queue is empty
                System.out.println("Queue is Empty");
                return -1;    // Return -1 to indicate empty queue
            }

            int result = head.data;  // Store the data of the front element
            if (head.next == null) { // If there is only one element in the queue
                head = tail = null;  // Set both head and tail to null (queue becomes empty)
            } else {
                head = head.next;    // Move the head pointer to the next node
            }
            return result;           // Return the dequeued value
        }
    }

    // Main method to demonstrate the functionality of the queue
    public static void main(String[] args) {
        Queue queue = new Queue();  // Create a new Queue object

        // Add elements to the queue
        queue.add(0);
        queue.add(1);
        queue.add(2);

        // Remove and print elements from the queue until it is empty
        while (!queue.isEmpty()) {
            System.out.println(queue.peek()); // Print the front element
            queue.deque();                    // Remove the front element
        }
    }
}
