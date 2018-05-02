package com.francesyu90.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francesyu90.lms.domain.Library;

public interface ILibraryRepository extends JpaRepository<Library, Long> {
}
