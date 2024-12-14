package com.classroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classroom.entity.Department;

@Repository
public class DepartmentDao {

	@Autowired

	SessionFactory factory;

	public List<Department> allDepartmentList() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Department.class);
		List<Department> deptList = criteria.list();
		return deptList;
	}

	public void createDepartment(Department department) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(department);
		tx.commit();
	}

	public void deleteDepartment(Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Department d = session.load(Department.class, id);
		session.delete(d);
		tx.commit();
	}

	public void updateDepartment(Department department) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(department);
		tx.commit();
	}

	public Department getDepartmentById(Long id) {
		Session session = factory.openSession();
		return session.get(Department.class, id);
	}

}
