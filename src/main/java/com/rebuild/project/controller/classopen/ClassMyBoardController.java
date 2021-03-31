package com.rebuild.project.controller.classopen;

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

import com.rebuild.project.service.classopen.ClassInfoService;
import com.rebuild.project.service.community.CommunityService;
import com.rebuild.project.vo.classopen.*;

@Controller
public class ClassMyBoardController {
	@Autowired
	private ClassInfoService service;
	@Autowired
	private CommunityService CommuService;
	
	@GetMapping("/class/classBoard")
	public String goClassMyboard(HttpSession session,Model model,
								@RequestParam(value = "class_num",defaultValue = "0")int class_num) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		// 로그인 번호 
		int ml_num = (int)session.getAttribute("ml_num");
		map.put("ml_num", ml_num);
		if(class_num !=0) {
			map.put("class_num",class_num);
		}
		
		
		// 내수업 첫화면 정보 가져오기
		HashMap<String, Object> list = service.getMyBoardInfo(map);
		//내수업 전체 목록 제목,번호가져오기
		List<ClassInfoVO> title = service.getClassTitle(ml_num);
		
		map.put("class_num", list.get("class_num"));
		int community = CommuService.selectChk(map);
		
		model.addAttribute("community", community);
		model.addAttribute("list", list);
		model.addAttribute("title", title);
		
		
		return ".classOpen.classMyBoard";
	}
	
	@PostMapping("/class/classStatusUpdate")
	@ResponseBody
	public String fnStatusUpdate(HttpSession session, String class_num, String class_auth) {
		
		int ml_num = (int)session.getAttribute("ml_num");
		
		
		if(Integer.parseInt(class_auth) == 0) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ml_num",ml_num);
			map.put("class_num",Integer.parseInt(class_num));
			service.statusUpdate(map);
		}else {
			return "fail";
		}
		
		
		return "success";
	}
	@PostMapping("/class/classSalesUpdate")
	@ResponseBody
	public String fnSalessUpdate(HttpSession session, String class_num, String class_status) {
		
		int ml_num = (int)session.getAttribute("ml_num");
		

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ml_num",ml_num);
		map.put("class_num",Integer.parseInt(class_num));
		map.put("class_status",Integer.parseInt(class_status));
	
		try {
			service.salesUpdate(map);			
		}catch (Exception e) {
			e.getStackTrace();
			return "fail";
		}
		

		return "success";
	}
	
	
	
	
}
