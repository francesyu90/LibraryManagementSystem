package com.francesyu90.lms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;
import com.francesyu90.lms.service.IBookService;
import com.francesyu90.lms.service.IGeneralService;
import com.francesyu90.lms.service.ILibraryService;
import com.francesyu90.lms.util.LmsUtility;

@Service
public class GeneralService implements IGeneralService {
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private ILibraryService libraryService;
	
	@Autowired
	private LmsUtility lmsUtility;
	
	private Scanner scanner;
	
	public GeneralService() {
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void create() {
		
		System.out.println("Please enter the name for the new library: ");
		String libraryName = this.scanner.nextLine();
		
		Library newLibrary = new Library(libraryName);
		Library savedLibrary = this.libraryService.saveLibrary(newLibrary);
		
		List<Book> newBooks = this.getBooksFromUsrInput(savedLibrary);
		this.bookService.saveBooks(newBooks);
		
		String jsonLibrary = this.lmsUtility.getLibraryJSONString(newLibrary);
		System.out.printf("Library (JSON): %s\n", jsonLibrary);
		
	}
	
	private List<Book> getBooksFromUsrInput(Library library) {
		
		List<Book> books = new ArrayList<>();
		
		Book book;
		boolean next = false;
		
		while(!next) {
			
			System.out.println("Adding a new book... ");
			System.out.println("Please enter the title of the book: ");
			String title = this.scanner.nextLine();
			System.out.println("Please enter the author of the book: ");
			String author = this.scanner.nextLine();
			book = new Book(title, author, library);
			books.add(book);
			
			System.out.println("Would you like to add more books? ['y' or 'n' only]");
			String res = this.scanner.nextLine();
			
			boolean isValidRes = (res.equals("y") || res.equals("n"))? true : false;
			next = (isValidRes && res.equals("y"))? false : true;
			
		}
		
		return books;
	}

	@Override
	public void list() {
		
		List<Library> libraries = this.libraryService.getAllLibraries();
		List<Library> updatedLibraries = libraries.stream().map(library -> {
			List<Book> books = this.bookService.getBooksByLibrary(library);
			library.setBooks(books);
			return library;
		}).collect(Collectors.toList());
		
		String jsonLibraries = this.lmsUtility.getLibrariesJSONString(updatedLibraries);
		System.out.printf("Library (JSON): %s\n", jsonLibraries);
		
	}

	@Override
	public void delete() {
		System.out.println("Please enter the id of the library you want to delete: ");
		long res = this.scanner.nextLong();
		this.libraryService.removeLibrary(res);
	}

}
