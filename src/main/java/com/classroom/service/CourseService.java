package com.classroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classroom.dao.CourseDao;
import com.classroom.entity.Course;

@Service
public class CourseService {

	@Autowired

	CourseDao dao;

	public List<Course> getallCourse() {
		System.err.println("I am in service course");
		List<Course> allrecord = dao.allCourseList();
		return allrecord;
	}

	public void createCourse(Course course) {
		dao.createCourse(course);
	}

	public void deleteCourse(Long id) {
		dao.deleteCourse(id);
	}

	public void updateCourse(Course course) {
		dao.updateCourse(course);
	}

	public Course getCourseById(Long id) {
		return dao.getCourseById(id);
	}

	


}
