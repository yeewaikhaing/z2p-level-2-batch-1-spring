package com.mmit.beans;

import org.springframework.stereotype.Component;

@Component(value = "universityBean")
public class Unversity {

	public void show() {
		System.out.println("University's show method");
	}
}
