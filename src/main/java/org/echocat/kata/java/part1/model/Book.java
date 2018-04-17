package org.echocat.kata.java.part1.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class Book extends PrintEntity {

    // csv fields
    private String title;
    private String isbn;
    private String description;
    private Set<String> authorsEmails;
    // field to be adjusted after parsing
    private Set<Author> authors;

    @Override
    public String contentToPrint() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=[" + authorsEmails.stream().collect(Collectors.joining(",")) +
                "], description='" + description + '\'' +
                '}';
    }
}
