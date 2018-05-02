package com.francesyu90.lms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.repository.IBookRepository;
import com.francesyu90.lms.service.IBookService;

@Service
public class BookService implements IBookService {
	
	@Autowired
	private IBookRepository bookRepo;

	@Override
	public void saveBook(Book book) {
		Book savedBook = this.bookRepo.save(book);
		if(savedBook != null) {
			System.out.println("Saved successfully");
		}
	}
	
	@Override
	public void saveBooks(List<Book> books) {
		ArrayList<Book> savedBooks = (ArrayList<Book>) this.bookRepo.saveAll(books);
		if(savedBooks != null && !savedBooks.isEmpty()) {
			System.out.println("Saved successfully");
		}
	}
	
	

}
