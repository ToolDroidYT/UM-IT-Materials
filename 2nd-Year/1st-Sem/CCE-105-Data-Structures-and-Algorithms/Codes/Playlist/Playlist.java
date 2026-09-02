public class Playlist {
    
    Node head;
    
    public void addFirst(String data) {
        Node nd = new Node(data);
        
        if (head == null) {
            head = nd;
            return;
        }
        
        nd.next = head;
        head = nd;
    }
    
    public void addLast(String data) {
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
    
    public void removeNodeWithData(String data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                break;
            }
            index++;
            current = current.next;
        }
        
        // System.out.println("Data " + data + " is at index: " + index);
        
        removeNodeAtIndex(index);
    }
    
    public void removeNodeAtIndex(int index) {
        Node current = head;
        Node previous = head;
        
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                previous.next = current.next;
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
    
    public void displayData() {
        if (head == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        
        System.out.println("Playlist:");
        Node current = head;
        while (current != null) {
            System.out.printf("- %s\n", current.data);
            current = current.next;
        }
    }
}