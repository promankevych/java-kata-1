package org.echocat.kata.java.part1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {

    // csv fields
    private String email;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Author{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
