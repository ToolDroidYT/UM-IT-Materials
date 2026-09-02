import java.util.Scanner;

public class Main {
    
    static Playlist ls;
    static int currentIndexPlaying = 0;

    public static void main(String[] args) {
        if (ls == null)
            ls = new Playlist();
        
        // ls.addFirst("A");
        // ls.addLast("B");
        // ls.addLast("C");
        // ls.addLast("D");
        // ls.addLast("E");
        // ls.addLast("F");

        // ls.displayData();
        // System.out.println(ls.getNodeAtIndex(2).data);
        // System.out.println(ls.size());
        // ls.removeNodeWithData("F");
        // ls.displayData();
        // System.out.println(ls.size());
        
        System.out.println("\n");
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            printPlaylistManager();
            int selected = sc.nextInt();
            sc.nextLine();
            
            switch (selected) {
                case 1: // Add Song
                    addSong(sc);
                    break;
                case 2: // Remove Song
                    removeSong(sc);
                    break;
                case 3: // Display Playlist
                    ls.displayData();
                    break;
                case 4: // Play Next Song
                    playNextSong();
                    break;
                case 5: // Exit
                    sc.close();
                    exit();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }
            System.out.println();
        }
    }
    
    static void playNextSong() {
        if (currentIndexPlaying >= ls.size()) {
            currentIndexPlaying = 0;
        }
        
        Node node = ls.getNodeAtIndex(currentIndexPlaying);
        
        if (node == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        
        String title = node.data;
        System.out.printf("Playing: %s\n", title);
        currentIndexPlaying++;
    }
    
    static void addSong(Scanner sc) {
        System.out.print("Enter song title: ");
        String title = sc.nextLine();
        
        ls.addLast(title);
        System.out.printf("%s added to playlist.\n", title);
    }

    static void removeSong(Scanner sc) {
        System.out.print("Enter song title to remove: ");
        String title = sc.nextLine();
        
        ls.removeNodeWithData(title);
        System.out.printf("%s removed from playlist.\n", title);
        currentIndexPlaying = 0;
    }
    
    static void exit() {
        System.out.println("Exiting Playlist Manager...");
        System.exit(0);
    }
    
    static void printPlaylistManager() {
        System.out.println("--- Playlist Manager ---");
        System.out.println("1. Add Song");
        System.out.println("2. Remove Song");
        System.out.println("3. Display Playlist");
        System.out.println("4. Play Next Song");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }
}