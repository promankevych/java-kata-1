package org.echocat.kata.java.part1.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.stream.Collectors;

public interface ParsingService<T> {

    T convertToEntity(CSVRecord record);

    default List<T> parse(String path) {
        try (InputStreamReader reader = new InputStreamReader(this.getClass().getResourceAsStream(path));
             CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withEscape(null)
                     .withQuote(null)
                     .withDelimiter(';')
                     .withHeader())) {
            return parser.getRecords().stream()
                    .map(this::convertToEntity)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
