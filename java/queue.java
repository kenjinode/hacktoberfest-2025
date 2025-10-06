public class QueueExample {

    static class CustomQueue {
        private int maxSize;
        private int[] arr;
        private int front;
        private int rear;
        private int count;

        // Constructor
        public CustomQueue(int size) {
            maxSize = size;
            arr = new int[size];
            front = 0;
            rear = -1;
            count = 0;
        }

        // Enqueue operation
        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot insert " + item);
                return;
            }
            rear = (rear + 1) % maxSize;
            arr[rear] = item;
            count++;
        }

        // Dequeue operation
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return -1;
            }
            int item = arr[front];
            front = (front + 1) % maxSize;
            count--;
            return item;
        }

        // Peek front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return arr[front];
        }

        // Check if empty
        public boolean isEmpty() {
            return count == 0;
        }

        // Check if full
        public boolean isFull() {
            return count == maxSize;
        }

        // Get size
        public int size() {
            return count;
        }

        // Display queue elements
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }
            System.out.print("Queue: ");
            for (int i = 0; i < count; i++) {
                System.out.print(arr[(front + i) % maxSize] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CustomQueue q = new CustomQueue(5);

        // Enqueue elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display();

        // Peek front
        System.out.println("Front element: " + q.peek());

        // Dequeue elements
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());

        q.display();

        // Enqueue more elements
        q.enqueue(60);
        q.enqueue(70);

        q.display();
    }
}
