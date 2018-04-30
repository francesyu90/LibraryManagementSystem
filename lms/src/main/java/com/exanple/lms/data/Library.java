package com.exanple.lms.data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class Library {
	
	private int id;
    private String name;
    private Set<Book> books;
    
    public Library(){}
    
    public Library(String name) {
        this.name = name;
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
    
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    public Set<Book> getBooks() {
        return books;
    }
    
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Category[id=%d, name='%s']%n",
                id, name);
        if (books != null || !books.isEmpty()) {
            for(Book book : books) {
                result += book.toString();
            }
        }

        return result;
    }
    
    
    
    

}
