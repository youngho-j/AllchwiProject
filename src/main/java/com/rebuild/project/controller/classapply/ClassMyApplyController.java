package com.rebuild.project.controller.classapply;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebuild.project.service.classapply.ClassApplyService;
import com.rebuild.project.vo.classapply.ClassApplyDateInfoVO;


@Controller
public class ClassMyApplyController {
	
	@Autowired private ClassApplyService service;
	
	@RequestMapping(value="/class/myapply", method = RequestMethod.POST)
	public String goClassMyboard(Model model,int apply_num, int class_num) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("apply_num",apply_num);
		map.put("class_num",class_num);
		List<ClassApplyDateInfoVO> list = service.list(map);
				
		model.addAttribute("list", list);	
				
		return ".classapply.ApplyInfo";
	}
}
