public class ManualQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    // Constructor
    public ManualQueue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    // Add element to the back (Enqueue)
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + value);
        } else {
            // Check for wraparound (Circular Queue logic)
            if (rear == maxSize - 1) {
                rear = -1; 
            }
            queueArray[++rear] = value;
            nItems++;
            System.out.println("Enqueued: " + value);
        }
    }

    // Remove element from the front (Dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        } else {
            int temp = queueArray[front++];
            // Check for wraparound
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
            return temp;
        }
    }

    // View front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            return queueArray[front];
        }
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    // Testing the Queue
    public static void main(String[] args) {
        ManualQueue myQueue = new ManualQueue(3);
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);
        
        System.out.println("Dequeued: " + myQueue.dequeue()); // Removes 10
        System.out.println("Front is now: " + myQueue.peek()); // Shows 20
        
        myQueue.enqueue(40); // Shows circular logic (wraps around)
    }
}
