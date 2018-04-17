package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.model.Book;

import java.util.List;

public interface BookService extends ParsingService<Book>, PrintService<Book> {

    Book findByIsbn(String isbn, List<Book> books);

    List<Book> findByAuthor(String authorsEmail, List<Book> books);
}
