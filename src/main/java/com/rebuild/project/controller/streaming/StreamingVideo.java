package com.rebuild.project.controller.streaming;

import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rebuild.project.service.onlineclass.*;
import com.rebuild.project.vo.onlineclass.*;


@Controller
public class StreamingVideo {
	@Autowired
	private OnlineCheckService check_service;
	@Autowired
	private OnlineClassService class_service;
	
	
	@GetMapping("/community/video")
	public String goOnlineClass(HttpSession session,@RequestParam(value = "online_num",defaultValue = "-1") int online_num,
								Model model) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int ml_num = (int)session.getAttribute("ml_num");
		
		
		if(online_num > 0) {
			OnlineClassVO vo =  class_service.select(online_num);
			model.addAttribute("vo", vo);
			map.put("online_num", online_num);
			map.put("ml_num", ml_num);
			
			int view_point = check_service.timeSelect(map);
			
			model.addAttribute("view_point", view_point);
			
					
		}else {
			return ".error.error";
		}
		
		
		
		return".community.onlineCampus.onlineClass";
	}
	
	
	
	// video 스트리밍 
	@RequestMapping(value="/video/{folder:.+}/{name:.+}",method = RequestMethod.GET)
	public String goStreamView(@PathVariable("name") String name,@PathVariable("folder") String folder,Model model) { 
		System.out.println("folder : " + folder);
		model.addAttribute("movieName", name);
		model.addAttribute("folder", folder);
		return "streamView";
	}
	
	// 강의 시청 시간 저장
	@PostMapping("/community/saveTime")
	public void OnlineTimeSave(HttpSession session,@RequestParam HashMap<String, Object> fd) {
		
		
		int view_point = Integer.parseInt((String)fd.get("saveTime")); 
		int online_num = Integer.parseInt((String)fd.get("online_num"));
		int ml_num = (int)session.getAttribute("ml_num");
		
		/*
		 * System.out.println("view_point : " + view_point);
		 * System.out.println("online_num : " + online_num);
		 * System.out.println("ml_num : " + ml_num);
		 */
		
		OnlineCheckVO vo = new OnlineCheckVO(0, ml_num, online_num, view_point, null);
		
		int check_num = check_service.select(vo);
		
		if(check_num > 0) {
			vo.setCheck_num(check_num);
		}

		try {
			check_service.insert(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
