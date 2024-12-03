package models;

import java.time.LocalDate;

public class Author {
    private static long idCounter = 1;
    private final long id;
    private String name;
    private LocalDate dateOfBirth;

    public Author(String name, LocalDate dateOfBirth) {
        this.id = idCounter++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
