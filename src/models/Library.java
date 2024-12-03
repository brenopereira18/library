package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<Loan> loans;
    private  List<Client> clients;

    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public List<Book> listBooks() {
        return Collections.unmodifiableList(books);
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        } else {
            System.out.println("Este livro já está cadastrado.");
        }

    }

    public List<Author> listAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public void addAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
        } else {
            System.out.println("Este autor já está cadastrado.");
        }

    }

    public List<Client> listClients() {
        return Collections.unmodifiableList(clients);
    }

    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        } else {
            System.out.println("Este cliente já foi cadastrado.");
        }
    }

    public List<Loan> listLoans() {
        return Collections.unmodifiableList(loans);
    }

    public void addLoan(Loan loan) {
        if (!loans.contains(loan)) {
            loans.add(loan);
        } else {
            System.out.println("Este empréstimo já foi cadastrado.");
        }
    }
}
