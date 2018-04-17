package org.echocat.kata.java.part1.service.impl;

import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.service.MagazineService;
import org.echocat.kata.java.part1.util.ParsingUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MagazineServiceImpl implements MagazineService {

    @Override
    public List<Magazine> findByIsbn(String isbn, List<Magazine> magazines) {
        return magazines.stream()
                .filter(m -> Objects.nonNull(m.getIsbn()))
                .filter(m -> m.getIsbn().equals(isbn))
                .collect(Collectors.toList());
    }

    @Override
    public List<Magazine> findByAuthor(String authorsEmail, List<Magazine> magazines) {
        return magazines.stream()
                .filter(m -> Objects.nonNull(m.getAuthorsEmails()))
                .filter(m -> m.getAuthorsEmails().contains(authorsEmail))
                .collect(Collectors.toList());
    }

    @Override
    public Magazine convertToEntity(CSVRecord record) {
        return Magazine.builder()
                .title(record.get("title"))
                .isbn(record.get("isbn"))
                .authorsEmails(ParsingUtil.parseEmails(record.get("authors")))
                .publishedAt(ParsingUtil.parseDate(record.get("publishedAt")))
                .build();
    }

}
