

public class QueueD {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        

        Queue(int n) {
            arr = new int[n];
            size=n;
            rear = -1;
        }
        
        public static boolean isEmpty(){
            return rear == -1;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is Empty");
                return -1;

            }
            return arr[0];
        }

        public static void add(int data){
            if(rear == size-1){
                System.out.println("queue is full");
                return;

            }

            rear=rear+1;
            arr[rear]=data;
        }
        public static int deque(){
            if(isEmpty()){
                System.out.println("queue is Empty");
                return -1;

            }
            int front=arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i]=arr[i+1];
            }
            rear=rear-1;
            return front;
            
        }
    }

public static void main(String[] args) {
    Queue queue= new Queue(5);

    queue.add(0);
    queue.add(1);
    queue.add(2);

    while (!queue.isEmpty()) {
        System.out.println(queue.peek());
        queue.deque();
        
    }

}
}
