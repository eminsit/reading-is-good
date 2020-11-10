package com.github.eminsit.ReadingIsGood.exceptions;

public class StockInsufficientException extends RuntimeException {
    public StockInsufficientException(Long id) {
        super("Book is insufficient, book: " + id);
    }
}
