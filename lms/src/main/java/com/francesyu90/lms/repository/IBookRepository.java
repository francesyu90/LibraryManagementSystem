package com.francesyu90.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;

public interface IBookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);
    
    Book findByAuthor(String author);
    
    List<Book> findByLibrary(Library library);
    
    List<Book> findBooksByLibraryId(long libraryId);
}
