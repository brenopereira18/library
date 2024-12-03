package models;

import java.time.LocalDateTime;

public class Book {
    private static long idCounter = 1;
    private final long id;
    private String title;
    private Author author;
    private Boolean isAvailable = true;
    private LocalDateTime dateRegistration;
    private LocalDateTime dateUpdate;

    public Book(Author author) {
        this.id = idCounter++;
        this.author = author;
        this.dateRegistration = LocalDateTime.now();
    }

    public long getId() {
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
        this.author = author;
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
