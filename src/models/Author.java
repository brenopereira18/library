package models;

import java.time.LocalDate;

public class Author {
    private static Integer idCounter = 1;
    private final Integer id;
    private String name;
    private LocalDate dateOfBirth;

    public Author(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public Integer getId() {
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
