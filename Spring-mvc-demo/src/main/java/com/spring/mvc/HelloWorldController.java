package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
/*
 * We can add controller level Request Mapping
 * to avoid ambiguous access to same mapping
 * in different controller in application
 */
public class HelloWorldController {

	// Need a Controller Method to show Initial HTML Form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// Need a Controller Method to process HTML Form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// New Controller method to read from data
	@RequestMapping("/processFormVersionTwo")
	public String letsShout(@RequestParam("studentName") String theName,Model model
	/*HttpServletRequest request,*/) {
		
		// Read request parameter from the HTML Form
		//String theName = request.getParameter("studentName");
		/*
		 * @RequestParam annotation can be used to add data
		 * to variable without having to use request object
		 */
		
		
		// Convert data to all caps
		theName = theName.toUpperCase();
		
		// Create the message
		String result = "YO! " + theName;
		
		// Add message to model
		model = model.addAttribute("message", result);
		
		return "helloworld";
	}

}
