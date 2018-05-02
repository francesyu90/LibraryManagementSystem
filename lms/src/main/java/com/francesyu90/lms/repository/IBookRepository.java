package com.francesyu90.lms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;

public interface IBookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);
    
    List<Book> findByAuthor(String author);
    
    List<Book> findByLibrary(Library library);
}
