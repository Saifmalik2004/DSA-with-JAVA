public class CircularQueue {

    // Queue class to define the circular queue
    static class Queue {
        static int arr[]; // Array to hold the elements of the queue
        static int size; // Maximum size of the queue
        static int rear; // Index of the last element in the queue
        static int front; // Index of the first element in the queue

        // Constructor to initialize the queue with a given size
        Queue(int n) {
            arr = new int[n]; // Allocate memory for the queue array
            size = n; // Set the size of the queue
            rear = -1; // Rear starts at -1 indicating an empty queue
            front = -1; // Front also starts at -1 indicating an empty queue
        }

        // Method to check if the queue is empty
        public static boolean isEmpty() {
            return rear == -1 && front == -1; // Both rear and front must be -1 for the queue to be empty
        }

        // Method to check if the queue is full
        public static boolean isFull() {
            // If the next position of rear is equal to front, the queue is full
            return (rear + 1) % size == front;
        }

        // Method to get the front element of the queue
        public static int peek() {
            if (isEmpty()) { // Check if the queue is empty
                System.out.println("Queue is Empty");
                return -1; // Return -1 as an error code
            }
            return arr[front]; // Return the front element
        }

        // Method to add an element to the queue
        public static void add(int data) {
            if (isFull()) { // Check if the queue is full
                System.out.println("Queue is full");
                return; // Exit the method if the queue is full
            }

            // If the queue is empty, set front to 0 (initialize front pointer)
            if (front == -1) {
                front = 0;
            }

            // Move rear to the next position in a circular manner
            rear = (rear + 1) % size;

            // Add the new element at the rear position
            arr[rear] = data;
        }

        // Method to remove an element from the queue
        public static int deque() {
            if (isEmpty()) { // Check if the queue is empty
                System.out.println("Queue is Empty");
                return -1; // Return -1 as an error code
            }

            // Store the front element to return it later
            int result = arr[front];

            // If there is only one element left, reset both rear and front to -1
            if (rear == front) {
                rear = front = -1; // Queue becomes empty
            } else {
                // Move front to the next position in a circular manner
                front = (front + 1) % size;
            }

            return result; // Return the removed element
        }
    }

    // Main method to demonstrate the circular queue
    public static void main(String[] args) {
        // Create a queue with a size of 5
        Queue queue = new Queue(5);

        // Add elements to the queue
        queue.add(0);
        queue.add(1);
        queue.add(2);

        // Remove and print all elements from the queue
        while (!queue.isEmpty()) {
            System.out.println(queue.peek()); // Print the front element
            queue.deque(); // Remove the front element
        }
    }
}
