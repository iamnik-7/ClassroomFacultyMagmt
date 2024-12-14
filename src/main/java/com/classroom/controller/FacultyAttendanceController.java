package com.classroom.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.classroom.entity.FacultyAttendance;
import com.classroom.service.FacultyAttendanceService;

@RestController
@RequestMapping("/api/faculty-attendances")
public class FacultyAttendanceController {

	@Autowired
	private FacultyAttendanceService facultyAttendanceService;

	@GetMapping
	public List<FacultyAttendance> getAllFacultyAttendance() {
		return facultyAttendanceService.getallFacultyAttendance();
	}

	@GetMapping("/{id}")
	public FacultyAttendance getFacultyAttendanceById(@PathVariable Long id) {
		return facultyAttendanceService.getFacultyAttendanceById(id);
	}

	@PostMapping("/insertfacultyattendance")
	public FacultyAttendance createFacultyAttendance(@RequestBody FacultyAttendance facultyAttendance) {
		facultyAttendanceService.createFacultyAttendance(facultyAttendance);
		return facultyAttendance;
	}

	@PutMapping("/{id}")
	public FacultyAttendance updateFacultyAttendance(@PathVariable Long id,
			@RequestBody FacultyAttendance facultyAttendanceDetails) {
		FacultyAttendance facultyAttendance = facultyAttendanceService.getFacultyAttendanceById(id);
		if (facultyAttendance != null) {
			facultyAttendance.setFaculty(facultyAttendanceDetails.getFaculty());
			facultyAttendance.setClassSchedule(facultyAttendanceDetails.getClassSchedule());
			facultyAttendance.setDate(facultyAttendanceDetails.getDate());
			facultyAttendance.setStatus(facultyAttendanceDetails.getStatus());
			facultyAttendanceService.updateFacultyAttendance(facultyAttendance);
			return facultyAttendance;
		} else {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public void deleteFacultyAttendance(@PathVariable Long id) {
		facultyAttendanceService.deleteFacultyAttendance(id);
	}
}
