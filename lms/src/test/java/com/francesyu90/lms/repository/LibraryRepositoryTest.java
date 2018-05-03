package com.francesyu90.lms.repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.francesyu90.lms.domain.Library;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LibraryRepositoryTest {


	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private ILibraryRepository libRepo;
	
	@Test
	public void testSaveLibrary() {
		
		//	given
		Library library = new Library("Hello World");
		
		//	when
		Library savedLibrary = this.libRepo.save(library);
		
		assertThat(savedLibrary).isNotNull();
		assertThat(savedLibrary.getName()).isEqualTo(library.getName());
	}
	
	@Test
	public void testDeleteLibrary() {
		
		//	given
		Library library = new Library("Hello World");
		Library savedLibrary = this.entityManager.persistAndFlush(library);
		long idToBeDeleted = savedLibrary.getId();
		
		//	when
		this.libRepo.deleteById(idToBeDeleted);
		
		boolean isExists = this.libRepo.existsById(idToBeDeleted);
		assertThat(isExists).isFalse();
		
	}
	
	@Test
	public void testGetLibrary() {
		
		//	given
		Library library = new Library("Hello World");
		Library savedLibrary = this.entityManager.persistAndFlush(library);
		
		//	when
		Library found = this.libRepo.getOne(savedLibrary.getId());
		
		assertThat(found).isNotNull();
		assertThat(found.getName()).isEqualTo(library.getName());
			
	}
	
	

}
