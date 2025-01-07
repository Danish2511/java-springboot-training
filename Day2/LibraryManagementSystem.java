package Day2;
import java.util.ArrayList;
import java.util.List;

// Class representing a Book
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // By default, the book is available when created
    }

    // Method to borrow the book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed the book: " + title);
        } else {
            System.out.println("Sorry, the book '" + title + "' is currently unavailable.");
        }
    }

    // Method to return the book
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("You have successfully returned the book: " + title);
        } else {
            System.out.println("The book '" + title + "' was not borrowed.");
        }
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println();
    }

    // Getter method for title
    public String getTitle() {
        return title;
    }

    // Getter method for ISBN
    public String getIsbn() {
        return isbn;
    }

    // Getter method for availability
    public boolean isAvailable() {
        return isAvailable;
    }
}

// Class representing the Library
class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' has been added to the library.");
    }

    // Method to borrow a book by ISBN
    public void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Sorry, the book with ISBN " + isbn + " was not found in the library.");
    }

    // Method to return a book by ISBN
    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Sorry, the book with ISBN " + isbn + " was not found in the library.");
    }

    // Method to display details of all books in the library
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        for (Book book : books) {
            book.displayBookDetails();
        }
    }
}

// Main class to test the Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create the library
        Library library = new Library();

        // Add books to the library
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book book2 = new Book("1984", "George Orwell", "9780451524935");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Display all books in the library
        System.out.println("Books in the library:");
        library.displayAllBooks();

        // Borrow a book
        library.borrowBook("9780743273565"); // Borrow "The Great Gatsby"
        library.borrowBook("9780451524935"); // Borrow "1984"

        // Attempt to borrow a book that's already borrowed
        library.borrowBook("9780743273565"); // Try to borrow "The Great Gatsby" again

        // Display all books again to see the updated availability
        System.out.println("Books in the library after borrowing:");
        library.displayAllBooks();

        // Return a book
        library.returnBook("9780743273565"); // Return "The Great Gatsby"

        // Display all books again to see the updated availability
        System.out.println("Books in the library after returning:");
        library.displayAllBooks();
    }
}
