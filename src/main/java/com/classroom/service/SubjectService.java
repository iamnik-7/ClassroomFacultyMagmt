package com.classroom.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classroom.dao.SubjectDao;
import com.classroom.entity.Subject;

@Service
public class SubjectService {

	@Autowired

	SubjectDao dao;

	public List<Subject> getallSubjects() {
		System.err.println("I am in service subject");
		List<Subject> allrecord = dao.allSubjectsList();
		return allrecord;

	}

	public void createSubject(Subject subject) {
		dao.createSubject(subject);
	}

	public void deleteSubject(Long id) {
		dao.deleteSubject(id);
	}

	public void updateSubject(Subject subject) {
		dao.updateSubject(subject);
	}

	public Subject getSubjectById(Long id) {
		return dao.getSubjectById(id);
	}


	}


