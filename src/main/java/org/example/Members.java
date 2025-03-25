package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Members {
    private List<Patron> patrons;

    public Members() {
        this.patrons = new ArrayList<>();
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }

    public void updatePatron(Patron oldPatron, Patron newPatron) {
        int index = patrons.indexOf(oldPatron);
        if(index != -1) {
            patrons.set(index, newPatron);
        } else{
            patrons.add(newPatron);
        }
    }

    public Patron getPatronById(String patronId) {
        return patrons.stream().filter(patron -> patron.getPatronId().equalsIgnoreCase(patronId)).findFirst().orElse(null);
    }

    public List<Patron> getAllPatrons() {
        return new ArrayList<>(patrons);
    }

    public List<Book> getBorrowingHistory(String patronId) {
        Patron patron = getPatronById(patronId);
        if(patron != null){
            return new ArrayList<>(patron.getBorrowedBooks());
        }
        return new ArrayList<>();
    }

    public Map<String, List<Book>> getAllBorrowingHistories() {
        Map<String, List<Book>> allHistories = new HashMap<>();
        for (Patron patron : patrons) {
            allHistories.put(patron.getPatronId(), new ArrayList<>(patron.getBorrowedBooks()));
        }
        return allHistories;
    }
}
