package com.classroom.controller;

import java.util.List;

import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classroom.entity.Classroom;
import com.classroom.service.ClassroomService;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;

	@GetMapping("/getAll")
	public List<Classroom> getAllClassrooms() {
		return classroomService.getallClassrooms();
	}

	@GetMapping("/{id}")
	public Classroom getClassroomById(@PathVariable Long id) {
		return classroomService.getClassroomById(id);
	}

	@PostMapping("/insertclassroom")
	public void createClassroom(@RequestBody Classroom classroom) {
		classroomService.createClassroom(classroom);
	}
	
	@PutMapping("/{id}")
	public Classroom updateClassroom(@PathVariable Long id, @RequestBody Classroom classroomDetails) {
		Classroom classroom = classroomService.getClassroomById(id);
		if (classroom != null) {
			classroom.setName(classroomDetails.getName());
			classroomService.updateClassroom(classroom);
		}
		return classroom;
	}

	@DeleteMapping("/{id}")
	public String deleteClassroom(@PathVariable Long id) 
	{		
		if (id == null) {
			return "no id found for deleting";
		} else {
			classroomService.deleteClassroom(id);
			return "data deleted...";
		}
	}
}
