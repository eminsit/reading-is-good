package com.github.eminsit.ReadingIsGood.advices;


import com.github.eminsit.ReadingIsGood.exceptions.BookNotFoundException;
import com.github.eminsit.ReadingIsGood.exceptions.CustomerNotFoundException;
import com.github.eminsit.ReadingIsGood.exceptions.StockInsufficientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {
    @ResponseBody
    @ExceptionHandler({BookNotFoundException.class, StockInsufficientException.class, CustomerNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NotFoundAdvice(BookNotFoundException ex) {
        return ex.getMessage();
    }
}