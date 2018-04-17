package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.model.PrintEntity;

import java.util.List;
import java.util.Objects;

public interface PrintService<T extends PrintEntity> {

    default void print(T entity) {
        if (Objects.isNull(entity)) {
            System.out.println("Nothing to print entity is null");
        } else {
            System.out.println(entity.contentToPrint());
        }
    }

    default void print(List<T> entities) {
        if (entities.isEmpty()) {
            System.out.println("Nothing to print entity list is empty");
        } else {
            entities.forEach(this::print);
        }
    }
}
