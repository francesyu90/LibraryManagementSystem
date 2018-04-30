package com.example.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exanple.lms.data.Book;
import com.exanple.lms.data.Library;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>  {

	List<Book> findByTitle(String title);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByLibrary(Library library);
}
