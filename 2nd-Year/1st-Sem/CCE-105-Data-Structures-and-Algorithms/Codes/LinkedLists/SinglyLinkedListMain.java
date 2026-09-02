public class SinglyLinkedListMain {
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.addFirst(0);
        ls.addFirst(1);
        ls.addFirst(2);
        ls.addFirst(3);
        ls.addFirst(4);
    }
}


class LinkedList {

    protected Node head;

    public void addFirst(int data) {
        Node nd = new Node(data);

        if (head == null) {
            head = nd;
            return;
        }

        nd.next = head;
        head = nd;
    }

    public void addLast(int data) {
        Node nd = new Node(data);

        if (head == null) {
            head = nd;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = nd;
    }

    public void removeNodeWithData(int data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == data) {
                break;
            }
            index++;
            current = current.next;
        }

        removeNodeAtIndex(index);
    }

    public void removeNodeAtIndex(int index) {
        if (head == null)
            return;

        if (index == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;

        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                if (previous != null) {
                    previous.next = current.next;
                }
                break;
            }
            currentIndex++;
            previous = current;
            current = current.next;
        }
    }

    public Node getNodeAtIndex(int index) {
        Node current = head;

        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                break;
            }
            currentIndex++;
            current = current.next;
        }

        return current;
    }

    public int size() {
        Node current = head;

        int currentIndex = 0;
        while (current != null) {
            currentIndex++;
            current = current.next;
        }

        return currentIndex;
    }
}


class Node {

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
