# Browser-History-Manager

A console-based Java application that simulates web browser history management. This project allows users to manage browsing history using a doubly linked list data structure, providing features similar to those in modern web browsers, such as visiting new pages, navigating back and forward, viewing history, clearing history, bookmarking pages, and saving/loading bookmarks.

Features
Core Functionalities
Visit a New Page: Simulate visiting a new web page, which adds the page to the browsing history. If any "forward" pages exist (from previous back navigation), they will be removed, similar to actual browsers.
Go Back: Navigate back to the previous page in the history. Ensures that the user cannot go back if they are at the first page.
Go Forward: Navigate forward to the next page in the history (if available). Prevents moving forward if already at the most recent page.
View History: Display the entire browsing history from the first visited page to the current page, with an indication of the current page.
Clear History: Erase all browsing history, similar to opening a new browsing session.
Bookmarking and Storage
Bookmark Pages: Allows users to bookmark specific pages within the history, enabling easy access to frequently visited pages.
View Bookmarks: Display all saved bookmarks in the order they were bookmarked.
Save Bookmarks: Save all bookmarks to a file, making them persistent across sessions.
Load Bookmarks: Load bookmarks from a file, restoring them to the session.
Advanced Functionalities
Search History: Search through browsing history based on keywords to quickly locate specific pages.


Data Structure: Utilizes a doubly linked list to represent browsing history. Each node (page) contains:
A URL
Pointers to the previous and next pages
Classes and Packages:
Page: Represents a single page in the history with URL and pointers to adjacent pages.
History: Manages the doubly linked list and provides methods to visit pages, navigate, view, and manage history.
BookmarkManager: Handles file operations for saving and loading bookmarks from a text file.
Package Structure
less
Copy code
browser
└── history
    ├── models
    │   └── Page.java           // Represents a single web page in the browsing history
    ├── History.java            // Manages the doubly linked list of pages with core functionality
    ├── storage
    │   └── BookmarkManager.java // Handles saving and loading bookmarks to and from a file
    └── app
        └── Main.java           // Contains the main method and console-based user interface
Usage
Run the Application: Execute Main.java to start the console-based application.
Console Menu:
Select options to visit new pages, navigate back/forward, view and clear history, bookmark pages, and save/load bookmarks.
Enter URLs and commands as prompted for a smooth simulation of browsing history management.
