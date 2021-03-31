package com.rebuild.project.controller.classdetail;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.service.classdetail.ClassReviewService;
import com.rebuild.project.vo.classdetail.ClassReviewVO;

@Controller
public class ClassReviewController {
	@Autowired
	private ClassReviewService crs;
	@PostMapping("/classDetail/insertreview")
	@ResponseBody
	public String insertReview(ClassReviewVO rvo) {
		try {
			crs.insertReview(rvo);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	@GetMapping("/review/modal")
	public String showModal(int class_num,Model model) {
		
		model.addAttribute("class_num", class_num);
		
		return "receipt/writeReview";
	}
	
	@PostMapping("/review/writeOk")
	@ResponseBody
	public String writeOk(HttpSession session, int class_num) {
		int ml_num = (int)session.getAttribute("ml_num");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ml_num",ml_num);
		map.put("class_num",class_num);
		
		int n = crs.writeOk(map);
		if(n>0) {
			return "success";
		}else {
			return "fail";
		}
		
	}

}
