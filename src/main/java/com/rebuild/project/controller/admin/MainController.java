package com.rebuild.project.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/admin/main")
	public String adminMain() {
		return ".admin.main";
	}
	
}
