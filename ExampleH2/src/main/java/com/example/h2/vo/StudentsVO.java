package com.example.h2.vo;

import java.io.Serializable;
import java.util.List;

public class StudentsVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private List<TeachersVO> teachers;
	
	public StudentsVO() {
		super();
	}

	public StudentsVO(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<TeachersVO> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeachersVO> teachers) {
		this.teachers = teachers;
	}
	
}
