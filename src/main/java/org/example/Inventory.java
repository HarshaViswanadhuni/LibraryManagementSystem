package org.example;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Book> availableBooks;
    private List<Book> borrowedBooks;
    private Search search;

    public Inventory(){
        this.availableBooks = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
        this.search = new Search();
    }

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public void removeBook(Book book) {
        availableBooks.remove(book);
        borrowedBooks.remove(book);
    }

    public void updateBook(Book oldBook, Book newBook) {
        int index = availableBooks.indexOf(oldBook);
        if(index != -1) {
            availableBooks.set(index, newBook);
        } else {
            availableBooks.add(newBook);
        }
    }

    public List<Book> searchBooks(String query) {
        return search.search(availableBooks, query);
    }

    public void borrowBook(Book book) {
        availableBooks.remove(book);
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        availableBooks.add(book);
    }

    public List<Book> getAllAvailableBooks(){
        return new ArrayList<>(availableBooks);
    }

    public List<Book> getAllBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }
}
