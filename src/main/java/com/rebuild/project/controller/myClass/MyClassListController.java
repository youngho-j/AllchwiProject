package com.rebuild.project.controller.myClass;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.classapply.PaymentService;
import com.rebuild.project.service.classopen.ClassInfoService;
import com.rebuild.project.vo.myclasslist.MyClassListVO;

@Controller
public class MyClassListController {
	@Autowired
	private ClassInfoService service;
	@Autowired
	private PaymentService payService;
	
	
	@GetMapping("/mypage/myClassList")
	public String goMyClassList(HttpSession session,Model model,@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
					@RequestParam(value = "class_form",defaultValue = "0")int class_form) {
		
		int ml_num = (int)session.getAttribute("ml_num");
		
		//페이징 
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ml_num",ml_num);
		map.put("class_form", class_form);
		
		int totalRowCount = service.countMy(map);
		
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 2, 5);
		map.put("startRow", pu.getStartRow() - 1);
		
		// 내 수업 목록 가져오기
		List<MyClassListVO> list = service.getMyList(map);
		
		model.addAttribute("list", list);
		model.addAttribute("pu",pu);
		model.addAttribute("class_form", class_form);
		
		return ".myClass.myClassList";
	}
	  
	@PostMapping("/mypage/finishUpdate")
	@ResponseBody
	public String classFinishUpdate(HttpSession session,int apply_num) {
		
		int ml_num = (int)session.getAttribute("ml_num");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ml_num", ml_num);
		map.put("apply_num", apply_num);
		
		if(apply_num != 0) {
			try {
				payService.finishUpdate(map);
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}else {
			return "fail";
		}
		
		return "success";
	}
}
