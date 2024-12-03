package models;

import java.time.LocalDate;

public class Client {
    private static long idCounter = 1;
    private final long id;
    private  String name;
    private LocalDate dateOfBirth;
    private String email;

    public Client(String name, LocalDate dateOfBirth, String email) {
        this.id = idCounter++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
