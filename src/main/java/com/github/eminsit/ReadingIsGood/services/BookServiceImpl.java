package com.github.eminsit.ReadingIsGood.services;

import com.github.eminsit.ReadingIsGood.exceptions.BookNotFoundException;
import com.github.eminsit.ReadingIsGood.exceptions.CustomerNotFoundException;
import com.github.eminsit.ReadingIsGood.models.Book;
import com.github.eminsit.ReadingIsGood.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repo;

    @Override
    public Book getOne(Long id) {
        return repo.findById(id).orElse(null);
    }

    Logger logger = LoggerFactory.getLogger(BookService.class);

    @Override
    public Book updateCount(Long bookId, Integer count) {
        var book = this.getOne(bookId);
        logger.info("updateCount() presentBook" + book.toString());
        if (book == null) {
            throw new BookNotFoundException(bookId);
        }
        book.setCount(count);

        logger.info("updateCount() updatedBook" + book.toString());
        return repo.save(book);
    }

    @Override
    public void save(Book book) {
        repo.save(book);
    }

    @Override
    public void saveAll(List<Book> books) {
        repo.saveAll(books);
    }
}
