package com.classroom.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.classroom.dao.ClassScheduleDao;
import com.classroom.entity.ClassSchedule;

@Service
public class ClassScheduleService {

	@Autowired

	ClassScheduleDao dao;

	public List<ClassSchedule> getallClassSchedule() {
		System.err.println("I am in service classschedule");
		List<ClassSchedule> allrecord = dao.allClassScheduleList();
		return allrecord;

	}

	public void createClassSchedule(ClassSchedule classschedule) {
		dao.createClassSchedule(classschedule);
	}

	public void deleteClassSchedule(Long id) {
		dao.deleteClassSchedule(id);
	}

	public void updateClassSchedule(ClassSchedule classschedule) {
		dao.updateClassSchedule(classschedule);
	}

	public ClassSchedule getClassScheduleById(Long id) {
		return dao.getClassScheduleById(id);
	}

}



