package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Since @Controller extends off of @Component
 * so it gets picked during component scanning
 */
@Controller
public class HomeController {
	
	
	/*
	 * Add Request Mapping to Controller Method
	 * i.e. map url request to this method here
	 */
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}

}
