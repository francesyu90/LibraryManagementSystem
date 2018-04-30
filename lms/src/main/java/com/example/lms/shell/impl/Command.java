package com.example.lms.shell.impl;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.example.lms.shell.CommandInterface;
import com.exanple.lms.data.Book;
import com.exanple.lms.data.Library;

@ShellComponent
public class Command implements CommandInterface {

	@Override
	@ShellMethod(value = "list: displays all libraries")
	public void list() {
		System.out.println("list: not yet implemented");
	}

	@Override
	@ShellMethod(value = "create: creates a library")
	public void create() {
		Library library = new Library("Great Library");
        Book book = new Book();
        book.setId(1);
        book.setAuthor("Stendhal");
        book.setTitle("The red and the black");
        library.addBook(book);
		System.out.println(library);
	}

	@Override
	@ShellMethod(value = "delete: deletes a library")
	public void delete() {
		System.out.println("delete: not yet implemented");
	}
	
}
