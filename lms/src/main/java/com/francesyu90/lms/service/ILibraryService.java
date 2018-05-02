package com.francesyu90.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francesyu90.lms.domain.Library;

@Service
public interface ILibraryService {
	
	public Library saveLibrary(Library library);
	
	public List<Library> getAllLibraries();
	
	public void removeLibrary(long libraryId);

}
