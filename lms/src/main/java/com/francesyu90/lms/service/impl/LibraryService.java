package com.francesyu90.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;
import com.francesyu90.lms.repository.ILibraryRepository;
import com.francesyu90.lms.service.ILibraryService;

@Service
public class LibraryService implements ILibraryService {
	
	@Autowired
	private ILibraryRepository libRepo;
	
	@Override
	public Library saveLibrary(Library library) {
		
		Library savedLibrary = this.libRepo.save(library);
		if(savedLibrary != null) {
			return savedLibrary;
		}
		return null;
		
	}

	@Override
	public List<Library> getAllLibraries() {
		return (List<Library>) this.libRepo.findAll();
	}
	
}
