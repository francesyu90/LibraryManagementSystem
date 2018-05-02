package com.francesyu90.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.francesyu90.lms.domain.Library;

public interface ILibraryRepository extends CrudRepository<Library, Long> {

}
