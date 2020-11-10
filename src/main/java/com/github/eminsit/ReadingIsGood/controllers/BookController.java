package com.github.eminsit.ReadingIsGood.controllers;

import com.github.eminsit.ReadingIsGood.models.Book;
import com.github.eminsit.ReadingIsGood.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PutMapping("/book/{bookId}/stock/{count}")
    ResponseEntity<Book> updateStock(@PathVariable Long bookId, @PathVariable Integer count) {
        return new ResponseEntity<Book>(bookService.updateCount(bookId, count), HttpStatus.OK);
    }
}
