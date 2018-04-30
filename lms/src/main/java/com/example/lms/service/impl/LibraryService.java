package com.example.lms.service.impl;

import org.springframework.stereotype.Service;

import com.example.lms.service.LibraryServiceInterface;
import com.exanple.lms.data.Book;
import com.exanple.lms.data.Library;

@Service
public class LibraryService implements LibraryServiceInterface {

	@Override
	public void createLibrary() {
		Library library = new Library("Great Library");
        Book book = new Book();
        book.setId(1);
        book.setAuthor("Stendhal");
        book.setTitle("The red and the black");
        library.addBook(book);
		System.out.println(library);
	}

}
