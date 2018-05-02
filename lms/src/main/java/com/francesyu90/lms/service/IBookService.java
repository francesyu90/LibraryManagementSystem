package com.francesyu90.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;

@Service
public interface IBookService {
	
	public void saveBook(Book book);
	
	public void saveBooks(List<Book> books);
	
	public List<Book> getBooksByLibrary(Library library);

}
