package org.example;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        Book book1 = BookFactory.createBook("The Great Gatsby", "F. Scott Fitzgerald", "BOOK0001", 1925);
        Book book2 = BookFactory.createBook("To Kill a Mockingbird", "Harper Lee", "BOOK0002", 1960);
        Book book3 = BookFactory.createBook("1984", "George Orwell", "BOOK0003", 1949);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Patron patron1 = PatronFactory.createPatron("John Doe", "PATRON0001");
        Patron patron2 = PatronFactory.createPatron("Jane Smith", "PATRON0002");

        library.addPatron(patron1);
        library.addPatron(patron2);

        library.borrowBook("PATRON0001", book1);
        library.borrowBook("PATRON0002", book2);

        library.returnBook("PATRON0001", book1);

        System.out.println("Search for '1984': " + library.searchBooks("1984"));
        System.out.println("Search for 'Harper Lee': " + library.searchBooks("Harper Lee"));
        System.out.println("Search for 'BOOK0003': " + library.searchBooks("BOOK003"));
        Book updatedBook1 = BookFactory.createBook("The Great Gatsby", "F. Scott Fitzgerald", "BOOK0001", 1926);
        library.updateBook(book1, updatedBook1);
        System.out.println("Updated book: " + library.searchBooks("BOOK0001"));

        library.removeBook(book2);
        System.out.println("All available books after removal: " + library.getAllAvailableBooks());
        System.out.println("All borrowed books after removal: " + library.getAllBorrowedBooks());

        System.out.println("Borrowing history for PATRON0001: " + library.getBorrowingHistory("PATRON0001"));
        System.out.println("Borrowing history for PATRON0002: " + library.getBorrowingHistory("PATRON0002"));

        Map<String, List<Book>> allHistories = library.getAllBorrowingHistories();
        for (Map.Entry<String, List<Book>> entry : allHistories.entrySet()) {
            System.out.println("Borrowing history for " + entry.getKey() + ": " + entry.getValue());
        }

    }
}