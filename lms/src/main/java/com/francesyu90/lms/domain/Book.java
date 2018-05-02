package com.francesyu90.lms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    
    @ManyToOne
	@JoinColumn (name="library_id")
    private Library library;

    protected Book() {}

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@Override
    public String toString() {
        return String.format(
                "Book[id=%d, title='%s', author='%s']",
                id, title, author);
    }
    
}
