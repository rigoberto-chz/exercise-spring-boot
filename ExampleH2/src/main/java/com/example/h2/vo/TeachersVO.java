package com.example.h2.vo;

import java.io.Serializable;
import java.util.List;

public class TeachersVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private List<StudentsVO> students;
	
	public TeachersVO() {
		super();
	}

	public TeachersVO(String firstName, String lastName) {
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

	public List<StudentsVO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentsVO> students) {
		this.students = students;
	}
	
}
