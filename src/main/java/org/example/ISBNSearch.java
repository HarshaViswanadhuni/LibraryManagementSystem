package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class ISBNSearch implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String query){
        return books.stream().filter(book -> book.getISBN().equalsIgnoreCase(query)).collect(Collectors.toList());
    }
}
