package browser.history.app;

import browser.history.History;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        History history = new History();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBrowser History Management");
            System.out.println("1. Visit a New Page");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. View History");
            System.out.println("5. Clear History");
            System.out.println("6. Search History");
            System.out.println("7. Bookmark Current Page");
            System.out.println("8. View Bookmarks");
            System.out.println("9. Save Bookmarks");
            System.out.println("10. Load Bookmarks");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the URL of the new page: ");
                    String url = scanner.nextLine();
                    history.visitPage(url);
                    System.out.println("Visited: " + url);
                    break;

                case 2:
                    history.goBack();
                    System.out.println("Navigated back.");
                    break;

                case 3:
                    history.goForward();
                    System.out.println("Navigated forward.");
                    break;

                case 4:
                    System.out.println("Browsing History:");
                    history.viewHistory();
                    break;

                case 5:
                    history.clearHistory();
                    break;

                case 6:
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    System.out.println("Search Results:");
                    history.searchHistory(keyword).forEach(System.out::println);
                    break;

                case 7:
                    history.bookmarkPage();
                    break;

                case 8:
                    history.viewBookmarks();
                    break;

                case 9:
                    history.saveBookmarks();
                    break;

                case 10:
                    history.loadBookmarks();
                    break;

                case 0:
                    System.out.println("Exiting Browser History Manager.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
