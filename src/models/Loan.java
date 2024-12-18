package models;

import java.time.LocalDateTime;

public class Loan {
    private static Integer idCounter = 1;
    private final Integer id;
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

    public Integer getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        if (book.getIsAvailable()) {
            this.book = book;
            this.book.setIsAvailable(false);
        } else {
            System.out.println("Este livro não está disponivel");
        }
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
