package com.rebuild.project.controller.community;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.service.classopen.ClassImgService;
import com.rebuild.project.service.community.*;
import com.rebuild.project.vo.classopen.ClassImgVO;
import com.rebuild.project.vo.community.CommunityVO;

@Controller
public class CommunityController {
	@Autowired
	private CommunityService service;
	
	@Autowired
	private NoticeService nts;
	
	@Autowired
	private AssignmentService assign;
	
	@Autowired
	private ClassImgService cis;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/onclass/community")
	public String adminMain(HttpSession session,int class_num, Model model) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int ml_num = (int)session.getAttribute("ml_num");
		
		map.put("ml_num", ml_num);
		map.put("class_num", class_num);
		
		CommunityVO vo = service.goCommu(map);
		if(vo!=null) {
			//a 해당 주에 올라온 과제 및 공지글 갯수
			int noticeCount = nts.weekNotice(vo.getCommu_num()); 
			int assignCount = assign.weekAssign(vo.getCommu_num());
			//a 온라인 클래스 이미지 가져오기
			List<ClassImgVO> classImg = cis.getImgList(vo.getClass_num());
			
			session.setAttribute("commuInfo", vo);
			model.addAttribute("noticeCount", noticeCount);
			model.addAttribute("assignCount", assignCount);
			model.addAttribute("classImg", classImg);
			log.debug("온라인 커뮤니티로 이동");
			return ".community";			
		}else {
			return ".error.error";
		}
		
		
	}
	
	
	@PostMapping("/class/community")
	@ResponseBody
	public String communityCreate(HttpSession session,int class_num,String commu_title) {
		
		int ml_num = (int)session.getAttribute("ml_num");
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("class_num", class_num);
		map.put("commu_title", commu_title);
		map.put("ml_num", ml_num);
		
		int n = service.selectChk(map);
		
		if(n > 0) {
			log.debug("classMyBoard.jsp로 이동");
			return "already";
		}else {
			try {
				service.insert(map);
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}
		return "success";
	}
	
}
