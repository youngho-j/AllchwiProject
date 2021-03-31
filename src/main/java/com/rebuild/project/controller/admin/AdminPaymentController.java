package com.rebuild.project.controller.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.admin.AdminPaymentService;
import com.rebuild.project.vo.admin.AdminPaymentVO;

@Controller
public class AdminPaymentController {
	@Autowired
	private AdminPaymentService service;
	
	@GetMapping("/admin/payment")
	public String goPayment(Model model,String field,String keyword,
			@RequestParam(value="pageNum", defaultValue = "1") int pageNum) {
		
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("field",field);
		map.put("keyword", keyword);
		
	
		//System.out.println(field);
		//System.out.println(keyword);
		
		int totalRowCount = service.count(map);
		PageUtil pu= new PageUtil(pageNum, totalRowCount, 5, 5);
		
		map.put("startRow", pu.getStartRow()-1);
		map.put("endRow", pu.getEndRow());
		
		//System.out.println(pu.getStartRow()-1);
		//System.out.println(pu.getEndRow());
		
		List<AdminPaymentVO> list = service.payment_list(map);
		
		model.addAttribute("list",list);
		model.addAttribute("pu",pu);
		model.addAttribute("keyword",keyword);
		model.addAttribute("field", field);
		
		return ".admin.payment";
	}
	

	@RequestMapping(value = "/admin/payment2", produces= "application/json;charset=utf-8")
	@ResponseBody
	public HashMap<String, Object> goPayment2(@RequestParam(value="pageNum", defaultValue = "1") int pageNum, String field, String keyword) {	
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("field",field);
		map.put("keyword", keyword);
				
		
		int totalRowCount = service.count(map);
		PageUtil pu= new PageUtil(pageNum, totalRowCount, 5, 5);
		
		
		map.put("startRow", pu.getStartRow()-1);
		map.put("endRow", pu.getEndRow());
		
		
		List<AdminPaymentVO> list = service.payment_list(map);
		
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("list",list);
		map2.put("pu",pu);
		
		return map2;
	}
	
	
	
}
