package com.example.demo.book.service;

import com.example.demo.book.db.entity.BookEntity;
import com.example.demo.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // Lombok
public class BookService {

    private final BookRepository bookRepository;

    // create, update
    public BookEntity create(BookEntity book){
        return bookRepository.save(book);
    }

    // all
    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }

}
