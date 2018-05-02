package com.francesyu90.lms.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Library {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    
    private String name;
    
    @OneToMany(mappedBy = "library")
    private List<Book> books;
    
    public Library(){
    	this.setBooks(null);
    }
    
    public Library(String name) {
        this.name = name;
        this.setBooks(null);
    }
    
    public Library(String name, List<Book> books) {
    	this.name = name;
    	this.setBooks(books);
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setBooks(List<Book> books) {
    	if(books == null) {
    		this.books = new ArrayList<Book>();
    	} else {
    		 this.books = books;
    	}
    }
    
    public void addBook(Book book) {
    	if(book == null) {
    		return;
    	}
    	this.books.add(book);
    }

    @Override
    public String toString() {
        String result = String.format(
                "Library[id=%d, name='%s']%n",
                id, name);
        if (books != null && !books.isEmpty()) {
            for(Book book : books) {
                result += book.toString();
            }
        }
        return result;
    }
    
}
