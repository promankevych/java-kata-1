package org.echocat.kata.java.part1.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class Magazine extends PrintEntity {

    // csv fields
    private String title;
    private LocalDate publishedAt;
    private Set<String> authorsEmails;
    private String isbn;
    // field to be adjusted after parsing
    private Set<Author> authors;

    @Override
    public String contentToPrint() {
        return "Magazine{" +
                "title='" + title + '\'' +
                ", publishedAt=" + publishedAt +
                ", authorsEmails=[" + authorsEmails.stream().collect(Collectors.joining(",")) +
                "], bookIsbn='" + isbn + '\'' +
                '}';
    }
}
