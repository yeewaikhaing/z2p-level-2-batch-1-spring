package com.mmit.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmit.model.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@GetMapping("/add") // /employees/add
	public String goAdd(Model model) {
		
		model.addAttribute("employee_obj", new Employee());
		return "emp-add";
	}
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("employee_obj") Employee emp, BindingResult result) {
		
		if(emp.getName() != null && emp.getName().equals("virus")) {
			ObjectError error = new ObjectError("global", "It does not allow");
			result.addError(error);
		}
		
		if(result.hasErrors())
			return "emp-add";
		
		//System.out.println(emp);
		return "emp-show";
	}
}
