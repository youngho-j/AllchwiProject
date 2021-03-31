package com.rebuild.project.controller.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.admin.manageClassService;
import com.rebuild.project.vo.admin.ManageClassVO;

@Controller
public class ManageClassController {
	@Autowired
	private manageClassService service;

	@GetMapping("/admin/manageClass")
	public String manageClass(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model,String field, String keyword) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("field", field);
		map.put("keyword", keyword);
	
		int totalRowCount = service.count(map);
		
		
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 5);

		map.put("startRow", pu.getStartRow() - 1);
		map.put("endRow", pu.getEndRow());
		
		List<ManageClassVO> list = service.manage_list(map);
				
		model.addAttribute("list", list);
		model.addAttribute("pu", pu);
		model.addAttribute("keyword",keyword);
		model.addAttribute("field", field);
		
		return ".admin.manageClass";
	}
	

	
	
	

}
