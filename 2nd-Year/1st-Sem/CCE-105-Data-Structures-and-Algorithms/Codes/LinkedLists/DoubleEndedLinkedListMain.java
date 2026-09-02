public class DoubleEndedLinkedListMain {

    public static void main(String[] args) {
        DoubleEndedLinkedList dll = new DoubleEndedLinkedList();

        dll.addFirst(10);
        dll.addFirst(20);
        dll.addLast(89);
        dll.display();
    }
}


class DoubleEndedLinkedList {
    class Node {
        int data;
        Node next;

        Node(int value) {
            data = value;
            next = null;
        }
    }

    Node head;
    Node tail;

    void addFirst(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;

        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void addLast(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
