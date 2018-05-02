package com.francesyu90.lms.service.impl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;
import com.francesyu90.lms.repository.ILibraryRepository;
import com.francesyu90.lms.service.IBookService;
import com.francesyu90.lms.service.ILibraryService;

@Service
public class LibraryService implements ILibraryService {
	
	@Autowired
	private ILibraryRepository libRepo;
	
	@Autowired
	private IBookService bookService;
	
	private Scanner scanner;
	
	public LibraryService() {
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void createLibrary() {
		
		System.out.print("Please enter the name for the new library: ");
		String libraryName = this.scanner.next();
		
		Set<Book> newBooks = this.getBooksFromUsrInput();
		System.out.println(newBooks);
		
		this.bookService.saveBooks(newBooks);
		Library newLibrary = new Library(libraryName, newBooks);
		Library library = this.libRepo.save(newLibrary);
		if(library != null) {
			System.out.println("Saved successfully!");
		}
		
	}
	
	private Set<Book> getBooksFromUsrInput() {
		
		Set<Book> books = new HashSet<>();
		
		Book book;
		boolean next = false;
		
		while(!next) {
			
			System.out.println("Adding a new book... ");
			System.out.print("Please enter the title of the book: ");
			String title = this.scanner.next();
			System.out.print("Please enter the author of the book: ");
			String author = this.scanner.next();
			book = new Book(title, author);
			books.add(book);
			
			System.out.print("Would you like to add more books? ['y' or 'n' only]");
			String res = this.scanner.next();
			
			boolean isValidRes = (res.equals("y") || res.equals("n"))? true : false;
			next = (isValidRes && res.equals("y"))? false : true;
			
		}
		
		return books;
	}
	

}
