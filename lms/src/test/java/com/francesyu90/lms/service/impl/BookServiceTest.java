package com.francesyu90.lms.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.francesyu90.lms.configuration.TestConfiguration;
import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.repository.IBookRepository;
import com.francesyu90.lms.service.IBookService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=TestConfiguration.class)
public class BookServiceTest {
	
	@Autowired
	private IBookService bookService;
	
	@MockBean 
	private IBookRepository bookRepo;
	
	@Test
	public void testSaveBook() {
		
		//	given
		Book book = new Book("Hello", "World");
		Mockito.when(this.bookRepo.save(book)).thenReturn(book);
		
		//	when
		boolean isSaved = this.bookService.saveBook(book);
		
		//	then
		assertThat(isSaved).isTrue();
		
	}
	
	@Test
	public void testSaveBookWithError() {
		
		//	given
		Book book = new Book("Hello", "World");
		Mockito.when(this.bookRepo.save(book)).thenReturn(null);
		
		//	when
		boolean isSaved = this.bookService.saveBook(book);
		
		//	then
		assertThat(isSaved).isFalse();
		
	}
	
	@Test
	public void testSaveBooks() {
		
		//	given
		Book book = new Book("Hello", "World");
		Book book1 = new Book("Hello1", "World1");
		List<Book> books = new ArrayList<>();
		books.add(book);
		books.add(book1);
		Mockito.when(this.bookRepo.saveAll(books)).thenReturn(books);
		
		//	when
		boolean isSaved = this.bookService.saveBooks(books);
		
		//	then
		assertThat(isSaved).isTrue();
		
	}
	
	@Test
	public void testSaveBooksWithErrorI() {
		
		//	given
		Book book = new Book("Hello", "World");
		Book book1 = new Book("Hello1", "World1");
		List<Book> books = new ArrayList<>();
		books.add(book);
		books.add(book1);
		Mockito.when(this.bookRepo.saveAll(books)).thenReturn(null);
		
		//	when
		boolean isSaved = this.bookService.saveBooks(books);
		
		//	then
		assertThat(isSaved).isFalse();
		
	}
	
	@Test
	public void testSaveBooksWithErrorII() {
		
		//	given
		Book book = new Book("Hello", "World");
		Book book1 = new Book("Hello1", "World1");
		List<Book> books = new ArrayList<>();
		books.add(book);
		books.add(book1);
		List<Book> resBooks = new ArrayList<>();
		Mockito.when(this.bookRepo.saveAll(books)).thenReturn(resBooks);
		
		//	when
		boolean isSaved = this.bookService.saveBooks(books);
		
		//	then
		assertThat(isSaved).isFalse();
		
	}
	
}
