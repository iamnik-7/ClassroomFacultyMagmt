package com.classroom.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "faculty_attendance")


public class FacultyAttendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Date date;
    
	@ManyToOne
	@JoinColumn(name = "faculty_id", nullable = false)
	private Faculty faculty;

	@ManyToOne
	@JoinColumn(name = "class_schedule_id", nullable = false)
	private ClassSchedule classschedule;

//	@Temporal(TemporalType.DATE)
//	private Date date;

	private String status;

	public FacultyAttendance() {
		super();
		// TODO Auto-generated constructor stub
		
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public FacultyAttendance(Faculty faculty, Date date, String status) {
		super();
		this.faculty = faculty;
		this.date = date;
		this.status = status;
	}

	@Override
	public String toString() {
		return "FacultyAttendance [id=" + id + ", faculty=" + faculty + ", date=" + date + ", status=" + status + "]";
	}

	public Object getClassSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setClassSchedule(Object classSchedule) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
