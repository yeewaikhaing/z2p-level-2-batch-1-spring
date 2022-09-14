package com.mmit.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Unversity {

	@Autowired
	private Teacher teacher;
	
	public Unversity() {
		
	}
	public Unversity(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public void show() {
		System.out.println("University's show method");
		teacher.teach();
	}
}
