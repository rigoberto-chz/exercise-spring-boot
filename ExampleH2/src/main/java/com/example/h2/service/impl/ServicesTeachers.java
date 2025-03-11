package com.example.h2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.h2.entity.Teachers;
import com.example.h2.repository.ITeachersRepository;
import com.example.h2.service.ITeachersServices;
import com.example.h2.vo.StudentsVO;
import com.example.h2.vo.TeachersVO;

@Service
public class ServicesTeachers implements ITeachersServices {

	@Autowired
	ITeachersRepository iTeachersRepository;
	
	@Override
	public List<TeachersVO> getTeachers() {
		
		List<TeachersVO> teachersVO = new ArrayList<TeachersVO>();
		
		List<Teachers> teachers =  (List<Teachers>) iTeachersRepository.findAll();
		
		if(teachers != null && teachers.size() > 0) {
			teachers.forEach(t -> {
				TeachersVO tVO = new TeachersVO();
				tVO.setId(t.getId());
				tVO.setFirstName(t.getFirstName());
				tVO.setLastName(t.getLastName());
				tVO.setEmail(t.getEmail());
				
				List<StudentsVO> studentsVO = new ArrayList<StudentsVO>();
				t.getStudents().forEach(s -> {
					StudentsVO sVO = new StudentsVO();
					sVO.setId(s.getId());
					sVO.setFirstName(s.getFirstName());
					sVO.setLastName(s.getLastName());
					sVO.setEmail(s.getEmail());
					studentsVO.add(sVO);
				});
				
				tVO.setStudents(studentsVO);
				teachersVO.add(tVO);
			});
		}
		
		return teachersVO;
		
	}

	@Override
	public TeachersVO getTeachers(Long id) {
		
		Teachers teachers = (Teachers) iTeachersRepository.findTeachersById(id);
		
		TeachersVO teachersVO = new TeachersVO();
		
		if(teachers != null) {
			teachersVO.setId(teachers.getId());
			teachersVO.setFirstName(teachers.getFirstName());
			teachersVO.setLastName(teachers.getLastName());
			teachersVO.setEmail(teachers.getEmail());
			
			List<StudentsVO> studentsVO = new ArrayList<StudentsVO>();
			teachers.getStudents().forEach(s -> {
				StudentsVO sVO = new StudentsVO();
				sVO.setId(s.getId());
				sVO.setFirstName(s.getFirstName());
				sVO.setLastName(s.getLastName());
				sVO.setEmail(s.getEmail());
				studentsVO.add(sVO);
			});
			
			teachersVO.setStudents(studentsVO);
		}
		
		return teachersVO;
		
	}

	@Override
	public List<TeachersVO> getTeachersName(String firstName) {
		
		List<TeachersVO> teachersVO = new ArrayList<TeachersVO>();
		
		List<Teachers> teachers =  (List<Teachers>) iTeachersRepository.findTeachersByFirstName(firstName);
		
		if(teachers != null && teachers.size() > 0) {
			teachers.forEach(t -> {
				TeachersVO tVO = new TeachersVO();
				tVO.setId(t.getId());
				tVO.setFirstName(t.getFirstName());
				tVO.setLastName(t.getLastName());
				tVO.setEmail(t.getEmail());
				
				List<StudentsVO> studentsVO = new ArrayList<StudentsVO>();
				t.getStudents().forEach(s -> {
					StudentsVO sVO = new StudentsVO();
					sVO.setId(s.getId());
					sVO.setFirstName(s.getFirstName());
					sVO.setLastName(s.getLastName());
					sVO.setEmail(s.getEmail());
					studentsVO.add(sVO);
				});
				
				tVO.setStudents(studentsVO);
				teachersVO.add(tVO);
			});
		}
		
		return teachersVO;
		
	}

	@Override
	public List<TeachersVO> getTeachersFullName(String firstName, String lastName) {
		
		List<TeachersVO> teachersVO = new ArrayList<TeachersVO>();
		
		List<Teachers> teachers =  (List<Teachers>) iTeachersRepository.findTeachersByFullName(firstName, lastName);
		
		if(teachers != null && teachers.size() > 0) {
			teachers.forEach(t -> {
				TeachersVO tVO = new TeachersVO();
				tVO.setId(t.getId());
				tVO.setFirstName(t.getFirstName());
				tVO.setLastName(t.getLastName());
				tVO.setEmail(t.getEmail());
				
				List<StudentsVO> studentsVO = new ArrayList<StudentsVO>();
				t.getStudents().forEach(s -> {
					StudentsVO sVO = new StudentsVO();
					sVO.setId(s.getId());
					sVO.setFirstName(s.getFirstName());
					sVO.setLastName(s.getLastName());
					sVO.setEmail(s.getEmail());
					studentsVO.add(sVO);
				});
				
				tVO.setStudents(studentsVO);
				teachersVO.add(tVO);
			});
		}
		
		return teachersVO;
		
	}

	@Override
	public TeachersVO addTeachers(TeachersVO teachersVO) {
		Teachers teachers = new Teachers();
		teachers.setFirstName(teachersVO.getFirstName());
		teachers.setLastName(teachersVO.getLastName());
		teachers.setEmail(teachersVO.getEmail());
		
		iTeachersRepository.save(teachers);
		
		teachersVO.setId(teachers.getId());
		
		return teachersVO;
	}
 
}
