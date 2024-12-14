package com.classroom.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classroom.entity.ClassSchedule;

@Repository
public class ClassScheduleDao {

	@Autowired

	SessionFactory factory;
	

	public List<ClassSchedule> allClassScheduleList() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(ClassSchedule.class);
		List<ClassSchedule> fList = criteria.list();
		return fList;
	}

	public void createClassSchedule(ClassSchedule classschedule) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(classschedule);
		tx.commit();
	}

	public void deleteClassSchedule(Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		ClassSchedule c = session.load(ClassSchedule.class, id);
		session.delete(c);
		tx.commit();
	}

	public void updateClassSchedule(ClassSchedule classschedule) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(classschedule);
		tx.commit();
	}

	public ClassSchedule getClassScheduleById(Long id) {
		Session session = factory.openSession();
		return session.get(ClassSchedule.class, id);
	}

}


	