package com.spring.mvc;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// Create a student object
		Student theStudent = new Student();
		
		// Add student object as model attribute
		theModel.addAttribute("student",theStudent);
		
		return "student-form";	
	}
	
	@RequestMapping("/processForm")
	/*
	 * Here we are binding the Student model attribute which basically
	 * holds the new object of student class. This is taken care by spring
	 */
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// Print data just to be sure
		System.out.println("theStudent: " + theStudent.getFirstName()
									+ " " + theStudent.getLastName());
		
		return "student-confirmation";
		
	}

}
