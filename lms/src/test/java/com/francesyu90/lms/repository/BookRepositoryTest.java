package com.francesyu90.lms.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private IBookRepository bookRepo;
	
	@Test
	public void testFindBookByTitle() {
		
		//	given
		String title = "Hello";
		Library library = new Library();
		Library savedLibrary = this.entityManager.persistAndFlush(library);
		Book book = new Book(title, "World", savedLibrary);
		this.entityManager.persist(book);
		this.entityManager.flush();
		
		//	when
		Book found = this.bookRepo.findByTitle(title);
		
		assertThat(found.getTitle()).isEqualTo(book.getTitle());
		assertThat(found.getAuthor()).isEqualTo(book.getAuthor());
		
	}
	
	@Test
	public void testFindBookByAuthor() {
		
		// given
		String author = "World";
		Library library = new Library();
		Library savedLibrary = this.entityManager.persistAndFlush(library);
		Book book = new Book("Hello", author, savedLibrary);
		this.entityManager.persistAndFlush(book);
		
		// when
		Book found = this.bookRepo.findByAuthor(author);
		
		assertThat(found.getTitle()).isEqualTo(book.getTitle());
		assertThat(found.getAuthor()).isEqualTo(book.getAuthor());
		
	}
	
	@Test
	public void testSaveBook() {
		
		//	given
		String title = "Hello";
		String author = "World";
		Library library = new Library();
		Library savedLibrary = this.entityManager.persistAndFlush(library);
		Book book = new Book(title, author, savedLibrary);
		
		//	when
		Book savedBook = this.bookRepo.saveAndFlush(book);
		
		assertThat(savedBook.getTitle()).isEqualTo(book.getTitle());
		assertThat(savedBook.getAuthor()).isEqualTo(book.getAuthor());
		
	}
	
	@Test
	public void testGetBooksByLibrary() {
		
		//	given
		Library library = new Library();
		Library savedLibrary = this.entityManager.persistAndFlush(library);
		List<String> titles = Arrays.asList("Hello", "Hello1");
		List<String> authors = Arrays.asList("World", "World1");
		List<Book> books = new ArrayList<>();
		IntStream.range(0, titles.size()).forEach(index -> {
			Book book = new Book(titles.get(index), authors.get(index), savedLibrary);
			books.add(book);
			this.entityManager.persistAndFlush(book);
		});
		
		//	when
		List<Book> foundBooks = this.bookRepo.findByLibrary(savedLibrary);
		
		assertThat(foundBooks).isNotNull();
		assertThat(foundBooks).isNotEmpty();
		IntStream.range(0, titles.size()).forEach(index -> {
			assertThat(
					foundBooks.get(index).getTitle()).isEqualTo(books.get(index).getTitle());
			assertThat(
					foundBooks.get(index).getAuthor()).isEqualTo(books.get(index).getAuthor());
		});
		
	}
	
	@Test
	public void testGetBooksByLibraryId() {
		
		//	given
		Library library = new Library();
		Library savedLibrary = this.entityManager.persistAndFlush(library);
		List<String> titles = Arrays.asList("Hello", "Hello1");
		List<String> authors = Arrays.asList("World", "World1");
		List<Book> books = new ArrayList<>();
		IntStream.range(0, titles.size()).forEach(index -> {
			Book book = new Book(titles.get(index), authors.get(index), savedLibrary);
			books.add(book);
			this.entityManager.persistAndFlush(book);
		});
		
		//	when
		List<Book> foundBooks = this.bookRepo.findBooksByLibraryId(savedLibrary.getId());
		
		assertThat(foundBooks).isNotNull();
		assertThat(foundBooks).isNotEmpty();
		IntStream.range(0, titles.size()).forEach(index -> {
			assertThat(
					foundBooks.get(index).getTitle()).isEqualTo(books.get(index).getTitle());
			assertThat(
					foundBooks.get(index).getAuthor()).isEqualTo(books.get(index).getAuthor());
		});
		
	}
 
}
