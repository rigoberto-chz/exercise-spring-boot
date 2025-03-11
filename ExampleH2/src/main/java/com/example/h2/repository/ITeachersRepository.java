package com.example.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.h2.entity.Teachers;

@Repository
public interface ITeachersRepository extends JpaRepository<Teachers, Long> {

	Teachers findTeachersById(Long id);
	
	@Query("select t1_0.id,t1_0.firstName,t1_0.lastName from teachers t1_0 where t1_0.firstName=?1")
	List<Teachers> findTeachersByFirstName(String firstName);
	
	@NativeQuery("SELECT * FROM TEACHERS WHERE FIRST_NAME = :firstName AND LAST_NAME = :lastName")
	List<Teachers> findTeachersByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
}
