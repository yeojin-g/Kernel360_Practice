package com.example.memorydb.book.service;


import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.db.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookEntity create(BookEntity book){
        return bookRepository.save(book);
    }

    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }
}
