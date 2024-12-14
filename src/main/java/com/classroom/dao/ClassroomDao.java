package com.classroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classroom.entity.Classroom;

@Repository
public class ClassroomDao {
	
	@Autowired

	SessionFactory factory;

	public List<Classroom> allClassroomsList() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Classroom.class);
		List<Classroom> classList = criteria.list();
		return classList;
	}

	public void createClassroom(Classroom classroom) 
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(classroom);
		tx.commit();
    }

    public void deleteClassroom(Long id)
    {
	    Session session=factory.openSession();
	    Transaction tx= session.beginTransaction();
	    Classroom c=session.load(Classroom.class, id);
	    session.delete(c);
	    tx.commit();
     }
     
    public void updateClassroom(Classroom classroom) 
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(classroom);
		tx.commit();
    }
    public Classroom getClassroomById(Long id)
    {
		Session session = factory.openSession();
        return session.get(Classroom.class, id);
    }
    
    
    
}