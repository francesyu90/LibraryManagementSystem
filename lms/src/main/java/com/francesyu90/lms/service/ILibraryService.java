package com.francesyu90.lms.service;

import org.springframework.stereotype.Service;

import com.francesyu90.lms.domain.Library;

@Service
public interface ILibraryService {

	public void saveLibrary(Library library);
}
