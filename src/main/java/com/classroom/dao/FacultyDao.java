package com.classroom.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classroom.entity.Faculty;

@Repository
public class FacultyDao {

	@Autowired

	SessionFactory factory;

	public List<Faculty> allFacultyList() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Faculty.class);
		List<Faculty> fList = criteria.list();
		return fList;
	}

	public void createFaculty(Faculty faculty) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(faculty);
		tx.commit();
	}

	public void deleteFaculty(Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Faculty f = session.load(Faculty.class, id);
		session.delete(f);
		tx.commit();
	}

	public void updateFaculty(Faculty faculty) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(faculty);
		tx.commit();
	}

	public Faculty getFacultyById(Long id) {
		Session session = factory.openSession();
		return session.get(Faculty.class, id);
	}

}

