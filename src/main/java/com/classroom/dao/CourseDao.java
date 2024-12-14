package com.classroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classroom.entity.Course;

@Repository
public class CourseDao {

	@Autowired

	SessionFactory factory;

	public List<Course> allCourseList() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Course.class);
		List<Course> courseList = criteria.list();
		return courseList;
	}

	public void createCourse(Course course) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(course);
		tx.commit();
	}

	public void deleteCourse(Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Course c = session.load(Course.class, id);
		session.delete(c);
		tx.commit();
	}

	public void updateCourse(Course course) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(course);
		tx.commit();
	}

	public Course getCourseById(Long id) {
		Session session = factory.openSession();
		return session.get(Course.class, id);
	}

}

