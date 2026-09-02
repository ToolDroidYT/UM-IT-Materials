public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList ls = new DoublyLinkedList();
        ls.addLast(1);
        ls.addLast(2);
        ls.addLast(3);
        ls.addLast(4);
        ls.addLast(5);
        ls.addLast(6);

        ls.displayForward();
        ls.displayBackward();

        // ls.removeLast();
        // ls.display();
        // ls.removeLast();
        // ls.display();
        // ls.removeLast();
        // ls.display();
        // ls.removeLast();
        // ls.display();
        // ls.removeLast();
        // ls.display();
        // ls.removeLast();
        // ls.display();
        // ls.removeLast();
        // ls.display();
        // ls.removeLast();
        // ls.display();

        // ls.removeFirst();
        // ls.removeFirst();
        // ls.removeFirst();
        // ls.removeFirst();
        // ls.removeFirst();
        // ls.display();
        // ls.removeFirst();
        // ls.display();
        // ls.removeFirst();
        // ls.display();
    }
}


class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}


class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(int data) {
        Node nd = new Node(data);

        if (head == null) {
            head = tail = nd;
            return;
        }

        nd.next = head;
        head.prev = nd;
        head = nd;
    }

    public void addLast(int data) {
        Node nd = new Node(data);

        if (tail == null) {
            tail = head = nd;
            return;
        }

        tail.next = nd;
        nd.prev = tail;
        tail = nd;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    public void removeLast() {
        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }

        if (tail == head) {
            tail = head = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    void addAtPosition(int value, int position) {
        if (position == 1) {
            addFirst(value);
            return;
        }

        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        Node temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addLast(value);
            return;
        }

        Node newNode = new Node(value);


        newNode.next = temp.next;
        temp.next = newNode;
        temp.next.next.prev = newNode;
        newNode.prev = temp;

    }

    void removeAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position <= 1) {
            removeFirst();
            return;
        }

        Node temp = head;
        int count = 1;

        while (temp != null && count < position) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Out of Range!");
            return;
        }

        if (temp == tail) {
            removeLast();
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}
