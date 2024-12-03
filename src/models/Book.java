package models;

import java.time.LocalDateTime;

public class Book {
    private static Integer idCounter = 1;
    private final Integer id;
    private String title;
    private Author author;
    private Boolean isAvailable;
    private LocalDateTime dateRegistration;
    private LocalDateTime dateUpdate;

    public Book(String title, Author author) {
        this.id = idCounter++;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.dateRegistration = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        if (author != null) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Erro: O autor não pode ser nulo.");
        }
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean available) {
        isAvailable = available;
    }

    public LocalDateTime getDateRegistration() {
        return dateRegistration;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
