package org.example;

import java.util.ArrayList;
import java.util.List;

public class Search implements SearchStrategy {
    private List<SearchStrategy> strategies;

    public Search() {
        this.strategies = new ArrayList<>();
        this.strategies.add(new TitleSearch());
        this.strategies.add(new AuthorSearch());
        this.strategies.add(new ISBNSearch());
    }

    @Override
    public List<Book> search(List<Book> books, String query) {
        List<Book> results = new ArrayList<>();
        for (SearchStrategy strategy : strategies){
            results.addAll(strategy.search(books, query));
        }
        return results;
    }
}
