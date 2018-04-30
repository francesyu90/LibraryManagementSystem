package com.example.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exanple.lms.data.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
