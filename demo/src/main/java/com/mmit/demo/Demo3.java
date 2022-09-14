package com.mmit.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mmit.config.Config3;
import com.mmit.di.Unversity;

public class Demo3 {

	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(Config3.class);
		
		//var university = cxt.getBean("universityBean", Unversity.class);
		var university = cxt.getBean("university", Unversity.class);
		university.show();
	}
}
