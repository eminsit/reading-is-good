package com.github.eminsit.ReadingIsGood.services;

import com.github.eminsit.ReadingIsGood.models.Book;

import java.util.List;

public interface BookService {
    void save(Book book);
    void saveAll(List<Book> books);
    Book getOne(Long id);
    Book updateCount(Long id, Integer count);


}
