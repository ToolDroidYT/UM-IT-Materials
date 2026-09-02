public class ManualStack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor
    public ManualStack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // -1 indicates the stack is empty
    }

    // Add element to top (Push)
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
        } else {
            stackArray[++top] = value; // Increment top, then insert
            System.out.println("Pushed: " + value);
        }
    }

    // Remove element from top (Pop)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Stack is empty.");
            return -1; // Return dummy value
        } else {
            int oldTop = stackArray[top--]; // Access value, then decrement top
            return oldTop;
        }
    }

    // View top element without removing (Peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Testing the Stack
    public static void main(String[] args) {
        ManualStack myStack = new ManualStack(3);
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40); // Will trigger Overflow
        
        System.out.println("Popped: " + myStack.pop()); // Removes 30
        System.out.println("Top is now: " + myStack.peek()); // Shows 20
    }
}
