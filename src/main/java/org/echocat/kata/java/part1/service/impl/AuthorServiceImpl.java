package org.echocat.kata.java.part1.service.impl;

import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.service.AuthorService;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class AuthorServiceImpl implements AuthorService {

    @Override
    public Author findByEmail(String email, List<Author> authors) {
        return authors.stream()
                .filter(a -> Objects.nonNull(a.getEmail()))
                .filter(a -> a.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Author> findByEmails(Set<String> email, List<Author> authors) {
        return null;
    }

    @Override
    public Author convertToEntity(CSVRecord record) {
        return Author.builder()
                .email(record.get("email"))
                .firstName(record.get("firstname"))
                .lastName(record.get("lastname"))
                .build();
    }
}
