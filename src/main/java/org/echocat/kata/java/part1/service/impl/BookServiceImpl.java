package org.echocat.kata.java.part1.service.impl;

import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.service.BookService;
import org.echocat.kata.java.part1.util.ParsingUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    @Override
    public Book findByIsbn(String isbn, List<Book> books) {
        return books.stream()
                .filter(b -> Objects.nonNull(b.getIsbn()))
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> findByAuthor(String authorsEmail, List<Book> books) {
        return books.stream()
                .filter(b -> Objects.nonNull(b.getAuthorsEmails()))
                .filter(b -> b.getAuthorsEmails().contains(authorsEmail))
                .collect(Collectors.toList());
    }

    @Override
    public Book convertToEntity(CSVRecord record) {
        return Book.builder()
                .title(record.get("title"))
                .isbn(record.get("isbn"))
                .authorsEmails(ParsingUtil.parseEmails(record.get("authors")))
                .description(record.get("description"))
                .build();
    }
}
