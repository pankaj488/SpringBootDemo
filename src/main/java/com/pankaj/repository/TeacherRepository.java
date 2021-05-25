package com.pankaj.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>  {
	//@Query("@Query(\"SELECT b FROM Book b WHERE b.title = ?1 and b.author = ?2\")")
	//@Query("SELECT t.id from TEACHER t WHERE t.id = ?1")
	@Query("SELECT id FROM Teacher o WHERE o.id= 1")
	public Long testQuery(Long id) ;
	//@Lock(LockModeType.PESSIMISTIC_READ)
	
	public Optional<Teacher> findByid(Long id);

	
	
}
