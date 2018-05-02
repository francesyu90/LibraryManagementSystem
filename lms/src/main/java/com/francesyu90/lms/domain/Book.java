package com.francesyu90.lms.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title;
    private String author;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="library_id", nullable = false)
    private Library library;

    protected Book() {}

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public Book(String title, String author, Library library) {
    	this.title = title;
    	this.author = author;
    	this.library = library;
    }
    
    public long getId() {
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
