package com.francesyu90.lms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;
import com.francesyu90.lms.repository.IBookRepository;
import com.francesyu90.lms.service.IBookService;

@Service
public class BookService implements IBookService {
	
	@Autowired
	private IBookRepository bookRepo;

	@Override
	public boolean saveBook(Book book) {
		Book savedBook = this.bookRepo.save(book);
		return (savedBook != null)? true : false;
	}
	
	@Override
	public boolean saveBooks(List<Book> books) {
		ArrayList<Book> savedBooks = (ArrayList<Book>) this.bookRepo.saveAll(books);
		return (savedBooks != null && !savedBooks.isEmpty()) ? true : false;
	}

	@Override
	public List<Book> getBooksByLibrary(Library library) {
		return this.bookRepo.findBooksByLibraryId(library.getId());
	}
	
	

}
