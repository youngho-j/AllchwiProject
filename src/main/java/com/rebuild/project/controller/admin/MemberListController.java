package com.rebuild.project.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rebuild.project.service.admin.memberListService;
import com.rebuild.project.vo.admin.MemberListVO;

@Controller
public class MemberListController {
	@Autowired
	private memberListService service;
	
	@GetMapping("/admin/memberlist")
	public String adminMain(Model model) {
		List<MemberListVO> list = service.member_list();
		model.addAttribute("list", list);
		//for (MemberListVO vo:list) {
		//	System.out.println(vo.getMb_name() +"," + vo.getMb_name().length());
		//}
		
		return ".admin.memberlist";
	}
	
	@GetMapping("/admin/memberlist/delete")
	public String member_del(@RequestParam("ml_num") int ml_num, Model model) {
		try {
			service.update_mlnum(ml_num);
		} catch (Exception e) {
			e.printStackTrace();
			return ".admin.error";
		}
	
		List<MemberListVO> list =service.member_list();
		model.addAttribute("list", list);
		return ".admin.memberlist";	
	}


}
