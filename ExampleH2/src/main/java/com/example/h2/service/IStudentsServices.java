package com.example.h2.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.h2.vo.StudentsVO;

@Service
public interface IStudentsServices {

	public List<StudentsVO> getStudents() throws SQLException;
	public StudentsVO getStudents(Long id) throws SQLException;
	public List<StudentsVO> getStudentsName(String firstName) throws SQLException;
	public List<StudentsVO> getStudentsFullName(String firstName, String lastName) throws SQLException;
	public StudentsVO addStudents(StudentsVO studentsVO);
	public StudentsVO addTeachers(StudentsVO studentsVO);
	
}
