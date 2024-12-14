package com.classroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classroom.entity.FacultyAttendance;

@Repository
public class FacultyAttendanceDao {

	@Autowired

	SessionFactory factory;

	public List<FacultyAttendance> allFacultyAttendanceList() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(FacultyAttendance.class);
		List<FacultyAttendance> fattendanceList = criteria.list();
		return fattendanceList;
	}

	public void createFacultyAttendance(FacultyAttendance facultyattendance) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(facultyattendance);
		tx.commit();
	}

	public void deleteFacultyAttendance(Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		FacultyAttendance f = session.load(FacultyAttendance.class, id);
		session.delete(f);
		tx.commit();
	}

	public void updateFacultyAttendance(FacultyAttendance facultyattendance) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(facultyattendance);
		tx.commit();
	}

	public FacultyAttendance getFacultyAttendanceById(Long id) {
		Session session = factory.openSession();
		return session.get(FacultyAttendance.class, id);
	}

}

