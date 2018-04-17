package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.service.AuthorService;
import org.echocat.kata.java.part1.service.BookService;
import org.echocat.kata.java.part1.service.MagazineService;
import org.echocat.kata.java.part1.service.impl.AuthorServiceImpl;
import org.echocat.kata.java.part1.service.impl.BookServiceImpl;
import org.echocat.kata.java.part1.service.impl.MagazineServiceImpl;

import java.util.List;
import java.util.Set;

public class KataExecutor {

    private AuthorService authorService = new AuthorServiceImpl();
    private BookService bookService = new BookServiceImpl();
    private MagazineService magazineService = new MagazineServiceImpl();

    private List<Author> authors;
    private List<Book> books;
    private List<Magazine> magazines;

    public KataExecutor() {
        init();
    }

    public void init() {
        authors = authorService.parse("authors.csv");
        books = bookService.parse("books.csv");
        adjustBooksWithAuthors();
        magazines = magazineService.parse("magazines.csv");
        adjustMagazinesWithAuthors();
    }

    private void adjustMagazinesWithAuthors() {
        magazines.forEach(m -> {
            Set<Author> authorsForBook = authorService.findByEmails(m.getAuthorsEmails(), authors);
            m.setAuthors(authorsForBook);
        });
    }

    private void adjustBooksWithAuthors() {
        books.forEach(b -> {
            Set<Author> authorsForBook = authorService.findByEmails(b.getAuthorsEmails(), authors);
            b.setAuthors(authorsForBook);
        });
    }

    public void start() {
        bookService.print(books);
        magazineService.print(magazines);

        String isbnToSearch = "4545-8558-3232";
        System.out.println("Searching for book with isbn: " + isbnToSearch);
        Book bookByIsbn = bookService.findByIsbn(isbnToSearch, books);
        bookService.print(bookByIsbn);
        System.out.println("Searching for magazine with isbn: " + isbnToSearch);
        List<Magazine> magazinesByIsbn = magazineService.findByIsbn(isbnToSearch, magazines);
        magazineService.print(magazinesByIsbn);

        String authorsEmail = authors.get(0).getEmail();
        System.out.println("Searching for book with author email: " + authorsEmail);
        List<Book> booksByAuthor = bookService.findByAuthor(authorsEmail, books);
        bookService.print(booksByAuthor);
        System.out.println("Searching for magazine with author email: " + authorsEmail);
        List<Magazine> magazinesByAuthor = magazineService.findByAuthor(authorsEmail, magazines);
        magazineService.print(magazinesByAuthor);

        System.out.println("To be continue...");
    }
}
