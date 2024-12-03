package models;

import java.time.LocalDateTime;

public class Loan {
    private static long idCounter = 1;
    private final long id;
    private Book book;
    private Client client;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;


    public Loan(Book book, Client client) {
        this.id = idCounter++;
        this.book = book;
        this.client = client;
        this.loanDate = LocalDateTime.now();
        this.returnDate = this.loanDate.plusMonths(2);
    }

    public long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }
}
