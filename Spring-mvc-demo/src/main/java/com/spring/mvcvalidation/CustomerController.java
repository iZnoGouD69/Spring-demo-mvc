package com.spring.mvcvalidation;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/customer")
public class CustomerController {
	
	// Add an Init binder to convert input strings
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		// Remove leading and trailing white spaces
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		// Resolve issue for validation
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());	
		
		return "customer-form"; 
	}

	@RequestMapping("/processForm")
	public String processForm( @Valid @ModelAttribute("customer") Customer theCustomer,
								BindingResult theBindingResult) {
		
		// debug thing
		System.out.println("Binding Result " + theBindingResult);
		
		
		if(theBindingResult.hasErrors()){
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
	}
}
