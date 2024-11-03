package browser.history;

import browser.history.models.Page;
import browser.history.storage.BookmarkManager;

import java.util.ArrayList;
import java.util.List;

public class History {
    private Page current;
    private Page head;
    private List<Page> bookmarks = new ArrayList<>();

    public void visitPage(String url) {
        Page newPage = new Page(url);
        if (current != null) {
            current.setNext(newPage);
            newPage.setPrevious(current);
        } else {
            head = newPage;
        }
        current = newPage;
    }

    public void goBack() {
        if (current != null && current.getPrevious() != null) {
            current = current.getPrevious();
        } else {
            System.out.println("You are at the first page in the history.");
        }
    }

    public void goForward() {
        if (current != null && current.getNext() != null) {
            current = current.getNext();
        } else {
            System.out.println("You are at the latest page in the history.");
        }
    }

    public void viewHistory() {
        Page temp = head;
        while (temp != null) {
            if (temp == current) {
                System.out.println(temp.getUrl() + " <-- Current Page");
            } else {
                System.out.println(temp.getUrl());
            }
            temp = temp.getNext();
        }
    }

    public void clearHistory() {
        head = null;
        current = null;
        bookmarks.clear();
        System.out.println("Browsing history cleared.");
    }

    public List<String> searchHistory(String keyword) {
        List<String> results = new ArrayList<>();
        Page temp = head;
        while (temp != null) {
            if (temp.getUrl().contains(keyword)) {
                results.add(temp.getUrl());
            }
            temp = temp.getNext();
        }
        return results;
    }

    public void bookmarkPage() {
        if (current != null && !bookmarks.contains(current)) {
            bookmarks.add(current);
            System.out.println("Bookmarked: " + current.getUrl());
        } else if (current == null) {
            System.out.println("No page to bookmark.");
        } else {
            System.out.println("Page is already bookmarked.");
        }
    }

    public void viewBookmarks() {
        if (bookmarks.isEmpty()) {
            System.out.println("No bookmarks available.");
        } else {
            System.out.println("Bookmarked Pages:");
            for (Page page : bookmarks) {
                System.out.println(page.getUrl());
            }
        }
    }

    public void saveBookmarks() {
        BookmarkManager.saveBookmarks(bookmarks);
    }

    public void loadBookmarks() {
        bookmarks = BookmarkManager.loadBookmarks();
    }
}
