package com.mmit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mmit.di.Teacher;
import com.mmit.di.Unversity;

@Configuration
public class Config3 {

	@Bean
	public Teacher teacherBean() {
		return new Teacher();
	}
	
	@Bean
	public Unversity universityBean() {
		var uni = new Unversity(teacherBean()); // di with constructor
		
		return uni;
	}
//	@Bean
//	public Unversity university() { // di with setter
//		var uni = new Unversity();
//		uni.setTeacher(teacherBean());
//		
//		return uni;
//	}
	@Bean
	public Unversity university() {
		return new Unversity();
	}
}
