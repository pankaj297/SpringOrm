package com.springorm.dao;



import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;



public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	//save student
	@Transactional
	public int insert(Student student) {
		//insert
	    int i =	(int) this.hibernateTemplate.save(student);
		return i;
	
	}

	
	//getter and setter
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

    
	//default constructor
	public StudentDao() {
	
	}
	
	
	
	
	
}
