package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.model.Author;

import java.util.List;
import java.util.Set;

public interface AuthorService extends ParsingService<Author> {

    Author findByEmail(String email, List<Author> authors);

    Set<Author> findByEmails(Set<String> email, List<Author> authors);

}
