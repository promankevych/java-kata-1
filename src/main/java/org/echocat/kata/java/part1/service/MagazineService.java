package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.model.Magazine;

import java.util.List;

public interface MagazineService extends ParsingService<Magazine>, PrintService<Magazine> {

    List<Magazine> findByIsbn(String isbn, List<Magazine> magazines);

    List<Magazine> findByAuthor(String authorsEmail, List<Magazine> magazines);
}
