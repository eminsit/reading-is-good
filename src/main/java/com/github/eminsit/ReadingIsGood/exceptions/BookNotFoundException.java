package com.github.eminsit.ReadingIsGood.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Could not find book " + id);
    }
}
