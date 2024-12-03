package main;

import models.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("SERVIÇOS:");
            System.out.println("Cadastrar Livro - 1 / Cadastrar Cliente - 2 / Fazer Empréstimo - 3 / " +
                    "Listar Clientes - 4 / Listar Empréstimos - 5 / Sair - 6");
            System.out.println("Digite o número do serviço correspondente.");
            Integer response = scanner.nextInt();
            scanner.nextLine();

            if (response == 6) {
                break;
            } else if (response == 1) {
                System.out.print("Informe o título do livro: ");
                String title = scanner.nextLine();

                System.out.print("Informe o Autor: ");
                String authorName = scanner.nextLine();

                Author author = new Author(authorName);
                Book book = new Book(title, author);

                library.addBook(book);
            } else if (response == 2) {
                System.out.print("Informe o nome do cliente: ");
                String clientName = scanner.nextLine();
                
                System.out.print("Informe o email: ");
                String clientEmail = scanner.nextLine();

                System.out.print("Informe a data de nascimento no formato dd/MM/yyyy: ");
                String dateOfBirthClient = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                try {
                    LocalDate date = LocalDate.parse(dateOfBirthClient, formatter);
                    Client client = new Client(clientName, date, clientEmail);
                    library.addClient(client);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido.");
                }                
            } else if (response == 3) {
                System.out.println("Livros disponíveis:");
                library.availableBooks().forEach(book ->
                        System.out.println("ID: " + book.getId() + " - Título: " + book.getTitle())
                );

                System.out.println("Selecione o id do livro desejado: ");
                Integer bookId = scanner.nextInt();
                scanner.nextLine();

                Book selectedBook = library.availableBooks().stream().filter(book -> book.getId().equals(bookId))
                        .findFirst()
                        .orElse(null);

                if (selectedBook == null) {
                    System.out.println("Livro não encontrado ou indisponível");
                    return;
                }

                System.out.print("Informe seu nome de cadastro: ");
                String clientName = scanner.nextLine();

                Client selectedClient = library.listClients().stream().filter(client -> client.getName()
                        .equalsIgnoreCase(clientName))
                        .findFirst()
                        .orElse(null);

                if (selectedClient == null) {
                    System.out.println("Cliente não cadastrado, cadastre-o para fazer um empréstimo.");
                    return;
                }
                Loan loan = new Loan(selectedBook, selectedClient);
                loan.setBook(selectedBook);

                System.out.println("Empréstimo do livro " + selectedBook.getTitle() + " para o cliente " +
                        selectedClient.getName() + " realizado com sucesso, o livro deverá ser entregue dia " +
                        loan.getReturnDate()
                );

                library.addLoan(loan);
            } else if (response == 4) {
                System.out.println("LISTA DE CLIENTES:");
                library.listClients().forEach(client ->
                        System.out.println(client.getName())
                );
            } else if (response == 5) {
                System.out.println("LISTA DE EMPRÉSTIMOS:");
                library.listLoans().stream().forEach(loan ->
                        System.out.println("Empréstimo do livro " + loan.getBook().getTitle() + " para o cliente " +
                        loan.getClient().getName() + ", devolução em - " + loan.getReturnDate())
                );
            }

        }
        scanner.close();
    }
}
