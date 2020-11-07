package com.github.eminsit.ReadingIsGood.exceptions;

public class StockInsufficientException extends RuntimeException {
    StockInsufficientException(Long id) {
        super("Book is not in our stocks, " + id);
    }
}
