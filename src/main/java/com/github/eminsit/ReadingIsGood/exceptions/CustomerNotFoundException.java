package com.github.eminsit.ReadingIsGood.exceptions;

public class CustomerNotFoundException  extends RuntimeException {
    CustomerNotFoundException(Long id) {
        super("Could not find customer " + id);
    }
}
