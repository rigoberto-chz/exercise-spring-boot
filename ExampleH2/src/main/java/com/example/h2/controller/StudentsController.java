package com.example.h2.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2.service.IStudentsServices;
import com.example.h2.vo.StudentsVO;

@RestController
public class StudentsController {

	@Autowired
	IStudentsServices iStudentsServices;
	
	@GetMapping("/students")
	public List<StudentsVO> students() throws ClassNotFoundException, SQLException {
		return iStudentsServices.getStudents();
	}
	
	@GetMapping("/students/{id}")
	public StudentsVO students(@PathVariable Long id) throws ClassNotFoundException, SQLException {
		return iStudentsServices.getStudents(id);
	}
	
	@GetMapping("/students/name/{firstName}")
	public List<StudentsVO> students(@PathVariable String firstName) throws ClassNotFoundException, SQLException {
		return iStudentsServices.getStudentsName(firstName);
	}
	
	@GetMapping("/students/fullname/{firstName}&{lastName}")
	public List<StudentsVO> studentsLastName(@PathVariable String firstName, @PathVariable String lastName) throws ClassNotFoundException, SQLException {
		return iStudentsServices.getStudentsFullName(firstName,lastName);
	}
	
	@PostMapping("/students/add")
	public StudentsVO addStudent(@RequestBody StudentsVO studentsVO) {
		return iStudentsServices.addStudents(studentsVO);
	}
	
	@PostMapping("/students/addTeachers")
	public StudentsVO addTeachers(@RequestBody StudentsVO studentsVO) {
		return iStudentsServices.addTeachers(studentsVO);
	}
	
	
}
