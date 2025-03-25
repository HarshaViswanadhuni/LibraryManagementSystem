package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class TitleSearch implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String query){
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(query)).collect(Collectors.toList());
    }
}
