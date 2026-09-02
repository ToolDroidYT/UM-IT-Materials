import java.util.Scanner;

// Singly Linked List Implementation
public class LinkedList_Term2 {

    // Node class represents each element in the list
    class Node {
        int data; // stores the value of the node
        Node next; // reference to the next node

        // Constructor to create a new node with a value
        Node(int value) {
            data = value;
            next = null; // new node initially points to null
        }
    }

    Node head; // head of the linked list (first node)

    // Add a node at the beginning of the list
    void AddFirst(int value) {
        Node newNode = new Node(value); // create new node
        newNode.next = head; // point new node to current head
        head = newNode; // update head to new node
    }

    // Add a node at the end of the list
    void AddLast(int value) {
        Node newNode = new Node(value); // create new node

        if (head == null) { // if list is empty
            head = newNode; // new node becomes head
            return;
        }

        Node current = head;
        while (current.next != null) { // traverse to last node
            current = current.next;
        }

        current.next = newNode; // attach new node at the end
    }

    // Add a node at a specific position (1-based index)
    void AddAtIndex(int value, int pos) {
        Node newNode = new Node(value);

        if (pos < 1) { // invalid positions
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) { // insert at beginning
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        int count = 1;

        // traverse to (pos-1)-th node
        while (current != null && count < pos - 1) {
            current = current.next;
            count++;
        }

        if (current == null) { // position out of range
            System.out.println("Position out of range");
            return;
        }

        // insert new node
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete the first node of the list
    void DeleteFirst() {
        if (head == null) { // if list is empty
            System.out.println("List is empty");
            return;
        }

        head = head.next; // move head to next node
    }

    // Delete the last node of the list
    void DeleteLast() {
        if (head == null) { // if list is empty
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) { // if only one node
            head = null;
            return;
        }

        Node current = head;
        // traverse to second-last node
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null; // remove last node
    }

    // Display all nodes in the list
    void Display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " "); // print node value
            current = current.next; // move to next node
        }
        System.out.println("null"); // indicate end of list
    }

    //
    //
    //
    //
    //

    // remove at index
    void Remove(int position) { // I am using 0-based index
        if (head == null) { // if list is empty
            System.out.println("List is empty");
            return;
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        int currentNodePosition = 0;
        Node previousNode = null;
        Node node = head;
        while (node.next != null && currentNodePosition != position) {
            previousNode = node;
            node = node.next;
            currentNodePosition++;
        }

        if (currentNodePosition == position && node != null) {
            previousNode.next = node.next;
            node.next = null;
        } else {
            System.out.println("Position out of range");
        }
    }

    // size
    int Size() {
        if (head == null) { // if list is empty
            return 0;
        }

        int count = 0;
        Node node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    // find using position
    Node FindUsingPosition(int position) { // I am using 0-based index
        if (head == null) { // if list is empty
            return null;
        }

        int nodePosition = 0;
        Node node = head;
        while (node != null && nodePosition != position) {
            node = node.next;
            nodePosition++;
        }

        if (nodePosition == position) {
            return node;
        } else {
            return null;
        }
    }

    // find using value
    Node FindUsingValue(int value) {
        if (head == null) { // if list is empty
            return null;
        }

        Node node = head;
        while (node != null) {
            if (node.data == value) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    //
    //
    //
    //
    //

    public static void main(String[] args) {
        LinkedList_Term2 list = new LinkedList_Term2();

        System.out.println("--- 1. Adding Data ---");
        list.AddFirst(2);
        list.AddLast(4);
        list.AddLast(8);
        list.AddLast(16);
        list.AddLast(32);
        list.AddLast(64);

        // Adding more data
        list.AddFirst(1);
        list.AddAtIndex(77, 3);
        list.Display();

        System.out.println("\n--- 2. Checking Size ---");
        System.out.println("Current List Size: " + list.Size());

        System.out.println("\n--- 3. Finding Data ---");
        // Find by Value
        Node foundVal = list.FindUsingValue(13);
        if (foundVal != null) {
            System.out.println("Found value 13 in the list.");
        } else {
            System.out.println("Value 13 not found.");
        }

        // Find by Position (0-based in your code)
        Node foundPos = list.FindUsingPosition(2);
        if (foundPos != null) {
            System.out.println("Value at index 2 is: " + foundPos.data);
        }

        System.out.println("\n--- 4. Removing Data ---");
        System.out.println("Removing node at index 4...");
        list.Remove(4);
        list.Display();

        System.out.println("Deleting first node...");
        list.DeleteFirst();
        list.Display();

        System.out.println("Deleting last node...");
        list.DeleteLast();
        list.Display();

        System.out.println("\n--- Final Size ---");
        System.out.println("Final List Size: " + list.Size());


        // list.AddLast(20);
        // list.Display();
        // list.AddAtIndex(50, 2);
        // list.Display();
        // list.DeleteFirst();
        // list.Display();
        // list.DeleteLast();
        // list.Display();
        // list.DeleteLast();
        // list.Display();
        // list.DeleteFirst();

        // // Adding nodes
        // list.AddFirst(5); // List: 5
        // list.AddFirst(10); // List: 10 → 5
        // list.AddFirst(3); // List: 3 → 10 → 5
        // list.AddFirst(15); // List: 15 → 3 → 10 → 5
        // list.AddLast(1); // List: 15 → 3 → 10 → 5 → 1
        // list.AddAtIndex(50, 2); // List: 15 → 50 → 3 → 10 → 5 → 1
        //
        // list.Display(); // Display current list
        //
        // // Deleting nodes
        // list.DeleteLast(); // Delete last node (1)
        // list.DeleteFirst(); // Delete first node (15)
        //
        // list.Display(); // Display updated list
    }
}