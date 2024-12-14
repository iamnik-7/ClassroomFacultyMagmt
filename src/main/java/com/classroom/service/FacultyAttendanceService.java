package com.classroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.classroom.dao.FacultyAttendanceDao;
import com.classroom.entity.FacultyAttendance;


@Service
public class FacultyAttendanceService {
	
@Autowired

FacultyAttendanceDao dao;
public List<FacultyAttendance> getallFacultyAttendance() {
	System.err.println("I am in service facultyattendance");
	List<FacultyAttendance> allrecord = dao.allFacultyAttendanceList();
	return allrecord;
	
}
public void createFacultyAttendance(FacultyAttendance facultyattendance) {
	dao.createFacultyAttendance(facultyattendance);
}

public void deleteFacultyAttendance(Long id) {
	dao.deleteFacultyAttendance(id);
}

public void updateFacultyAttendance(FacultyAttendance facultyattendance) {
	dao.updateFacultyAttendance(facultyattendance);
}

public FacultyAttendance getFacultyAttendanceById(Long id) {
	return dao.getFacultyAttendanceById(id);
}
	
}


	
	

