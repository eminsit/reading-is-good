package com.github.eminsit.ReadingIsGood.repositories;

import com.github.eminsit.ReadingIsGood.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();

    Book findBookById(Long id);
}