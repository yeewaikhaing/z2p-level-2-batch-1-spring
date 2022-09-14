package com.mmit.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mmit.beans.Customer;
import com.mmit.beans.Person;
import com.mmit.beans.Unversity;
import com.mmit.config.BeanConfig;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		
		var cxt = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		//Unversity uni = cxt.getBean(Unversity.class);
		//Unversity uni = cxt.getBean("universityBean", Unversity.class);
		
		//uni.show();
		
		//var customer = cxt.getBean(Customer.class);
		//customer.save();
		
		var person1 = cxt.getBean(Person.class);
		person1.setName("Jeon");
		
		var person2 = cxt.getBean(Person.class);
		
		System.out.println("Person1's name: " + person1.getName());
		System.out.println("Person2's name: " + person2.getName());
		
		person2.setName("JK");
		System.out.println("---------");
		System.out.println("Person1's name: " + person1.getName());
		System.out.println("Person2's name: " + person2.getName());
		
		
		cxt.close();
		
	}

}
