package com.classroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classroom.dao.FacultyDao;
import com.classroom.entity.Faculty;

@Service
public class FacultyService {

	@Autowired

	FacultyDao dao;

	public List<Faculty> getallFaculty() {
		System.err.println("I am in service faculty");
		List<Faculty> allrecord = dao.allFacultyList();
		return allrecord;

	}

	public void createFaculty(Faculty faculty) {
		dao.createFaculty(faculty);
	}

	public void deleteFaculty(Long id) {
		dao.deleteFaculty(id);
	}

	public void updateFaculty(Faculty faculty) {
		dao.updateFaculty(faculty);
	}

	public Faculty getFacultyById(Long id) {
		return dao.getFacultyById(id);
	}

}


