package com.classroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classroom.dao.ClassroomDao;
import com.classroom.entity.Classroom;



@Service
public class ClassroomService {
	
	@Autowired
	
	ClassroomDao dao;
	public List<Classroom> getallClassrooms()
	{ 
		System.err.println("I am in service classroom");
		List<Classroom>allrecord=dao.allClassroomsList();
		return allrecord;
	}
	
	public void createClassroom(Classroom classroom)
	{
		dao.createClassroom(classroom);
	}
	
	public void deleteClassroom(Long id)
	{
		dao.deleteClassroom(id);
	}
	
	public void updateClassroom(Classroom classroom)
	{
		dao.updateClassroom(classroom);
	}
	public Classroom getClassroomById(Long id)
	{
	   return dao.getClassroomById(id);
	}
	

	
	
}	