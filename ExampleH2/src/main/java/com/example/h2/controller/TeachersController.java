package com.example.h2.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2.service.ITeachersServices;
import com.example.h2.vo.TeachersVO;

@RestController
public class TeachersController {
	
	@Autowired
	ITeachersServices iTeachersServices;

	@GetMapping("/teachers")
	public List<TeachersVO> teachers() throws ClassNotFoundException, SQLException {
		return iTeachersServices.getTeachers();
	}
	
	@GetMapping("/teachers/{id}")
	public TeachersVO teachers(@PathVariable Long id) throws ClassNotFoundException, SQLException {
		return iTeachersServices.getTeachers(id);
	}
	
	@GetMapping("/teachers/name/{firstName}")
	public List<TeachersVO> teachers(@PathVariable String firstName) throws ClassNotFoundException, SQLException {
		return iTeachersServices.getTeachersName(firstName);
	}
	
	@GetMapping("/teachers/fullname/{firstName}&{lastName}")
	public List<TeachersVO> teachers(@PathVariable String firstName, @PathVariable String lastName) throws ClassNotFoundException, SQLException {
		return iTeachersServices.getTeachersFullName(firstName, lastName);
	}
	
	@PostMapping("/teachers/add")
	public TeachersVO addTeachers(@RequestBody TeachersVO teachersVO) {
		return iTeachersServices.addTeachers(teachersVO);
	}
	
}
