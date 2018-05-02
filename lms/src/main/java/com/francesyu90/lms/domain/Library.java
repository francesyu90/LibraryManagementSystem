package com.francesyu90.lms.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Library {
	
	private int id;
    private String name;
    
    @OneToMany(mappedBy = "library")
    private Set<Book> books;
    
    public Library(){
    	this.setBooks(null);
    }
    
    public Library(String name) {
        this.name = name;
        this.setBooks(null);
    }
    
    public Library(String name, Set<Book> books) {
    	this.name = name;
    	this.setBooks(books);
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setBooks(Set<Book> books) {
    	if(books == null) {
    		this.books = new HashSet<Book>();
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
