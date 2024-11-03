package browser.history.storage;

import browser.history.models.Page;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookmarkManager {
    private static final String FILE_PATH = "bookmarks.txt";

    // Save bookmarks to a file
    public static void saveBookmarks(List<Page> bookmarks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Page page : bookmarks) {
                writer.write(page.getUrl());
                writer.newLine();
            }
            System.out.println("Bookmarks saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving bookmarks: " + e.getMessage());
        }
    }

    // Load bookmarks from a file
    public static List<Page> loadBookmarks() {
        List<Page> bookmarks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                bookmarks.add(new Page(line));
            }
            System.out.println("Bookmarks loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading bookmarks: " + e.getMessage());
        }
        return bookmarks;
    }
}
