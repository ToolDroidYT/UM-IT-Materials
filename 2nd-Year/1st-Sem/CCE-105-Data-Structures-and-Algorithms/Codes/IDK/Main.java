import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack backwardStack = new Stack();
        Stack forwardStack = new Stack();

        int pageCounter = 0;
        Node currentPage = null;

        while (true) {
            System.out.println("===Web Browser History(Back and Forward)===");
            System.out.println("[1] Visit New Web Page");
            System.out.println("[2] Back");
            System.out.println("[3] Forward");
            System.out.println("[4] Show Current Website");
            System.out.println("[0] Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("\n==Visit Web Page==");
                System.out.print("Enter Website: ");
                String websiteName = sc.nextLine();
                pageCounter++;
                Node newNode = new Node(websiteName, pageCounter);

                if (currentPage != null) {
                    backwardStack.push(currentPage);
                    forwardStack = new Stack(); // Clear forward stack when visiting a new page
                }
                currentPage = newNode;
                System.out.println(currentPage.pageNumber + " |" + currentPage.data + " website added");

            } else if (choice == 2) {
                System.out.println("\n==Back==");
                if (!backwardStack.isEmpty()) {
                    Node poppedNode = backwardStack.pop();
                    if (currentPage != null) {
                        forwardStack.push(currentPage);
                    }
                    currentPage = poppedNode;
                    System.out.println(currentPage.pageNumber + " |" + currentPage.data + " removed  from Backward Stack.");
                    System.out.println(currentPage.pageNumber + " |" + currentPage.data + " added  to Forward Stack");
                } else {
                    System.out.println("Stack is empty");
                }

            } else if (choice == 3) {
                System.out.println("\n==Forward==");
                if (!forwardStack.isEmpty()) {
                    Node poppedNode = forwardStack.pop();
                    if (currentPage != null) {
                        backwardStack.push(currentPage);
                    }
                    currentPage = poppedNode;
                    System.out.println(currentPage.pageNumber + " |" + currentPage.data + " removed  from Forward Stack.");
                    System.out.println(currentPage.pageNumber + " |" + currentPage.data + " added  to Backward Stack");
                } else {
                    System.out.println("Stack is empty");
                }

            } else if (choice == 4) {
                System.out.println("\n==Current Website==");
                if (currentPage != null) {
                    System.out.println("You are currently in " + currentPage.pageNumber + " |" + currentPage.data + ".");
                } else {
                    System.out.println("Stack is empty.");
                }

            } else if (choice == 0) {
                System.out.println("\nProgram Exiting.......");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("\n==Backward Stack==");
            backwardStack.display();
            System.out.println("==Forward Stack==");
            forwardStack.display();
        }

        sc.close();
    }
}