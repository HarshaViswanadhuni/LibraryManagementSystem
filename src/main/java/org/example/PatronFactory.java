package org.example;

public class PatronFactory {
    public static Patron createPatron(String name, String patronId) {
        return new Patron(name, patronId);
    }
}
