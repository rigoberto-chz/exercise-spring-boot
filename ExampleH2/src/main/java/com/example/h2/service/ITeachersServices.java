package com.example.h2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.h2.vo.TeachersVO;

@Service
public interface ITeachersServices {

	public List<TeachersVO> getTeachers();
	public TeachersVO getTeachers(Long id);
	public List<TeachersVO> getTeachersName(String firstName);
	public List<TeachersVO> getTeachersFullName(String firstName, String lastName);
	public TeachersVO addTeachers(TeachersVO teachersVO);

}
