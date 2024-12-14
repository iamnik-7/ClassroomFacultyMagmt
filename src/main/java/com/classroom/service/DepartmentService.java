package com.classroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.classroom.dao.DepartmentDao;
import com.classroom.entity.Department;

@Service
public class DepartmentService {

	@Autowired

	DepartmentDao dao;

	public List<Department> getallDepartment() {
		System.err.println("I am in service department");
		List<Department> allrecord = dao.allDepartmentList();
		return allrecord;
	}

	public void createDepartment(Department department) {
		dao.createDepartment(department);
	}

	public void deleteDepartment(Long id) {
		dao.deleteDepartment(id);
	}

	public void updateDepartment(Department department) {
		dao.updateDepartment(department);
	}

	public Department getDepartmentById(Long id) {
		return dao.getDepartmentById(id);
	}
		
	}

