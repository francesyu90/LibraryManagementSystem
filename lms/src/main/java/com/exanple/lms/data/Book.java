package com.exanple.lms.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class Book {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
    private String title;

    private String author;
    
    private Library library;
    
    public Book() {}
    
    public Book(String title, String author) {
    	this.title = title;
    	this.author = author;
    }
    
    public Book(String title, String author, Library library) {
    	this.title = title;
    	this.author = author;
    	this.library = library;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public int getId() {
    	return this.id;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getTitle() {
    	return this.title;
    }
    
    public void setAuthor(String author) {
    	this.author = author;
    }
    
    public String getAuthor() {
    	return this.author;
    }
    
    @Override
    public String toString() {
    	return String.format(
                "Book[id=%d, title='%s', author='%s']",
                id, title, author);
    }
    
    @ManyToOne
    @JoinColumn(name = "library_id")
    public Library getLibrary() {
        return this.library;
    }
    
    public void setBookCategory(Library library) {
        this.library = library;
    }
	
}
