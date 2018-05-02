package com.francesyu90.lms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francesyu90.lms.domain.Library;
import com.francesyu90.lms.repository.ILibraryRepository;
import com.francesyu90.lms.service.ILibraryService;

@Service
public class LibraryService implements ILibraryService {
	
	@Autowired
	private ILibraryRepository libRepo;
	
	@Override
	public Library saveLibrary(Library library) {
		
		this.libRepo.saveAndFlush(library);
		Optional<Library> optLibrary = this.libRepo.findById(library.getId());
		if(optLibrary.isPresent()) {
			return optLibrary.get();
		}
		return null;
		
	}

	@Override
	public List<Library> getAllLibraries() {
		return (List<Library>) this.libRepo.findAll();
	}

	@Override
	public void removeLibrary(long libraryId) {
		this.libRepo.deleteById(libraryId);
	}
	
}
