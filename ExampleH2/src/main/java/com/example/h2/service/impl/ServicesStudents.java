package com.example.h2.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.h2.entity.Students;
import com.example.h2.entity.Teachers;
import com.example.h2.repository.IStudentsRespository;
import com.example.h2.service.IStudentsServices;
import com.example.h2.vo.StudentsVO;
import com.example.h2.vo.TeachersVO;

@Service
public class ServicesStudents implements IStudentsServices {

	@Autowired
	IStudentsRespository studentsRespository;
	
	@Override
	public List<StudentsVO> getStudents() throws SQLException {
		
		List<StudentsVO> studentsVO = new ArrayList<StudentsVO>();

		List<Students> students = (List<Students>) studentsRespository.findAll();
		
		if(students != null && students.size() > 0) {
			students.forEach(s -> {
				StudentsVO sVO = new StudentsVO();
				sVO.setId(s.getId());
				sVO.setFirstName(s.getFirstName());
				sVO.setLastName(s.getLastName());
				sVO.setEmail(s.getEmail());
				
				List<TeachersVO> teachersVO = new ArrayList<TeachersVO>();
				s.getTeachers().forEach(t -> {
					TeachersVO tVO = new TeachersVO();
					tVO.setId(t.getId());
					tVO.setFirstName(t.getFirstName());
					tVO.setLastName(t.getLastName());
					tVO.setEmail(t.getEmail());
					teachersVO.add(tVO);
				});
				
				sVO.setTeachers(teachersVO);
				studentsVO.add(sVO);
			});
		}
		
		return studentsVO;
		
	}

	@Override
	public StudentsVO getStudents(Long id) throws SQLException {
		
		Students students = studentsRespository.findStudentsById(id);
		
		StudentsVO studentsVO = new StudentsVO();
		
		if(students != null) {
			studentsVO.setId(students.getId());
			studentsVO.setFirstName(students.getFirstName());
			studentsVO.setLastName(students.getLastName());
			studentsVO.setEmail(students.getEmail());
			
			List<TeachersVO> teachersVO = new ArrayList<TeachersVO>();
			students.getTeachers().forEach(t -> {
				TeachersVO tVO = new TeachersVO();
				tVO.setId(t.getId());
				tVO.setFirstName(t.getFirstName());
				tVO.setLastName(t.getLastName());
				tVO.setEmail(t.getEmail());
				teachersVO.add(tVO);
			});
			
			studentsVO.setTeachers(teachersVO);
		}
		
		return studentsVO;
		
	}

	@Override
	public List<StudentsVO> getStudentsName(String firstName) throws SQLException {

		List<StudentsVO> studentsVO = new ArrayList<StudentsVO>();

		List<Students> students = (List<Students>) studentsRespository.findStudentsByFirstName(firstName);
		
		if(students != null && students.size() > 0) {
			students.forEach(s -> {
				StudentsVO sVO = new StudentsVO();
				sVO.setId(s.getId());
				sVO.setFirstName(s.getFirstName());
				sVO.setLastName(s.getLastName());
				sVO.setEmail(s.getEmail());
				
				List<TeachersVO> teachersVO = new ArrayList<TeachersVO>();
				s.getTeachers().forEach(t -> {
					TeachersVO tVO = new TeachersVO();
					tVO.setId(t.getId());
					tVO.setFirstName(t.getFirstName());
					tVO.setLastName(t.getLastName());
					tVO.setEmail(t.getEmail());
					teachersVO.add(tVO);
				});
				
				sVO.setTeachers(teachersVO);
				studentsVO.add(sVO);
				
				
			});
		}
		
		return studentsVO;
		
	}
	
	@Override
	public List<StudentsVO> getStudentsFullName(String firstName, String lastName) throws SQLException {
		
		List<StudentsVO> studentsVO = new ArrayList<StudentsVO>();

		List<Students> students = (List<Students>) studentsRespository.findStudentsByFirstNameLastName(firstName, lastName);
		
		if(students != null && students.size() > 0) {
			students.forEach(s -> {
				StudentsVO sVO = new StudentsVO();
				sVO.setId(s.getId());
				sVO.setFirstName(s.getFirstName());
				sVO.setLastName(s.getLastName());
				sVO.setEmail(s.getEmail());
				
				List<TeachersVO> teachersVO = new ArrayList<TeachersVO>();
				s.getTeachers().forEach(t -> {
					TeachersVO tVO = new TeachersVO();
					tVO.setId(t.getId());
					tVO.setFirstName(t.getFirstName());
					tVO.setLastName(t.getLastName());
					tVO.setEmail(t.getEmail());
					teachersVO.add(tVO);
				});
				
				sVO.setTeachers(teachersVO);
				studentsVO.add(sVO);
				
			});
		}
		
		return studentsVO;
		
	}

	@Override
	public StudentsVO addStudents(StudentsVO studentsVO) {
		Students students = new Students();
		students.setFirstName(studentsVO.getFirstName());
		students.setLastName(studentsVO.getLastName());
		students.setEmail(studentsVO.getEmail());
		
		studentsRespository.save(students);
	
		studentsVO.setId(students.getId());
			
		return studentsVO;
	}

	@Override
	public StudentsVO addTeachers(StudentsVO studentsVO) {
		
		Students students = new Students();
		students.setId(studentsVO.getId());
		
		List<Teachers> teachers = new ArrayList<Teachers>();
		
		studentsVO.getTeachers().forEach(t -> {
			teachers.add(new Teachers(t.getId()));
		});
		
		studentsRespository.save(students);
		
		return studentsVO;
	}

}
