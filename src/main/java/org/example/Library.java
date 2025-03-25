package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Library {
    private static Library instance;
    private Inventory inventory;
    private Members members;

    public Library() {
        this.inventory = new Inventory();
        this.members = new Members();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        inventory.addBook(book);
    }

    public void removeBook(Book book) {
        inventory.removeBook(book);
    }

    public void updateBook(Book oldBook, Book newBook) {
        inventory.updateBook(oldBook, newBook);
    }

    public List<Book> searchBooks(String query) {
        return inventory.searchBooks(query);
    }

    public List<Book> getAllAvailableBooks(){
        return inventory.getAllAvailableBooks();
    }

    public List<Book> getAllBorrowedBooks() {
        return inventory.getAllBorrowedBooks();
    }

    public void addPatron(Patron patron) {
        members.addPatron(patron);
    }

    public void removePatron(Patron patron) {
        members.removePatron(patron);
    }

    public void updatePatron(Patron oldPatron, Patron newPatron) {
        members.updatePatron(oldPatron, newPatron);
    }

    public Patron getPatronById(String patronId) {
        return members.getPatronById(patronId);
    }

    public List<Patron> getAllPatrons() {
        return members.getAllPatrons();
    }

    public List<Book> getBorrowingHistory(String patronId) {
        return members.getBorrowingHistory(patronId);
    }

    public Map<String, List<Book>> getAllBorrowingHistories() {
        return members.getAllBorrowingHistories();
    }

    public void borrowBook(String patronId, Book book) {
        Patron patron = getPatronById(patronId);
        if(patron != null && inventory.getAllAvailableBooks().contains(book)) {
            patron.borrowBook(book);
            inventory.borrowBook(book);
        }
    }

    public void returnBook(String patronId, Book book) {
        Patron patron = getPatronById(patronId);
        if(patron != null && inventory.getAllBorrowedBooks().contains(book)) {
            patron.returnBook(book);
            inventory.returnBook(book);
        }
    }
}
