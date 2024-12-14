package com.classroom.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classroom.entity.Subject;

@Repository
public class SubjectDao{

	@Autowired

	SessionFactory factory;

	public List<Subject> allSubjectsList() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Subject.class);
		List<Subject> sList = criteria.list();
		return sList;
	}

	public void createSubject(Subject subject) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(subject);
		tx.commit();
	}

	public void deleteSubject(Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Subject s = session.load(Subject.class, id);
		session.delete(s);
		tx.commit();
	}

	public void updateSubject(Subject subject) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(subject);
		tx.commit();
	}

	public Subject getSubjectById(Long id) {
		Session session = factory.openSession();
		return session.get(Subject.class, id);
	}

}



