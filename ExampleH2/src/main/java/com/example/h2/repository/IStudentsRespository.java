package com.example.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.h2.entity.Students;

@Repository
public interface IStudentsRespository extends JpaRepository<Students, Long> {

	Students findStudentsById(Long id);
	
	List<Students> findStudentsByFirstName(String firstName);
	
	@NativeQuery("SELECT * FROM STUDENTS WHERE FIRST_NAME = :firstName AND LAST_NAME = :lastName")
	List<Students> findStudentsByFirstNameLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
}
