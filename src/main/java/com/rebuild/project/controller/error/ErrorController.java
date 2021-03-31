package com.rebuild.project.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	
	@GetMapping("/error")
	public String goError() {
		return ".error.error";
	}
	
}
