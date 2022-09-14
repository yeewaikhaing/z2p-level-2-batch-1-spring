package com.mmit.model.entities;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class Employee {

	@NotBlank(message = "Name is required")
	@Length(min = 10, message = "Name must be at least 10 letters")
	private String name;
	@Min(value = 10000 , message = "Salary must be at least 10000")
	private int salary;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;
	public String city;
	public String address;
	public String gender;
	public boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", birthday=" + birthday + ", city=" + city
				+ ", address=" + address + ", gender=" + gender + ", active=" + active + "]";
	}

	
	
	
	
}
