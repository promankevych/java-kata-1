package org.echocat.kata.java.part1.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ParsingUtil {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");

    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date, formatter);
    }

    public static Set<String> parseEmails(String emails) {
        return Arrays.stream(emails.split(",")).collect(Collectors.toSet());
    }

}
