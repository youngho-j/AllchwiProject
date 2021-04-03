package com.rebuild.project.controller.detail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/class/detail")
	public String detail() {
		log.debug("class/detail.jsp로 이동");
		return ".class.detail";
	}
}