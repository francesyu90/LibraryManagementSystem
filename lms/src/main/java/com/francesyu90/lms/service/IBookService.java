package com.francesyu90.lms.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.francesyu90.lms.domain.Book;

@Service
public interface IBookService {
	
	public void saveBook(Book book);
	
	public void saveBooks(Set<Book> books);

}
