package com.rebuild.project.controller.home;


import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebuild.project.service.admin.ChangePicsService;
import com.rebuild.project.service.classdetail.*;
import com.rebuild.project.service.login.MemberInfoService;
import com.rebuild.project.vo.classdetail.*;
import com.rebuild.project.vo.login.ProfileVO;

@Controller
public class HomeController {
	@Autowired private MemberInfoService mis;
	@Autowired private ClassDetailService detail_service;
	@Autowired private ClassReviewService crs;
	@Autowired private ChangePicsService changePicsService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale,HttpServletRequest req, Model model) {
		ServletContext sc = req.getSession().getServletContext();
		sc.setAttribute("cp", req.getContextPath());
		//a 로그인하여 세션에 회원번호가 저장되었을때 
		if(req.getSession().getAttribute("ml_num") != null ) {
			//a 메인 닉네임 및 이름 출력위해 세션에 저장된 회원번호 가져오기
			int ml_num = (int)req.getSession().getAttribute("ml_num");
			//a 회원번호 사용하여 vo에 이미지 및 이름, 닉네임 담기
			ProfileVO pfv = mis.selectInfo(ml_num);
			//model에 vo 객체 담아 보내기
			req.getSession().setAttribute("mem", pfv);
		}
		//인기수업
		List<ClassDetailVO> top_list=detail_service.topFive();
		model.addAttribute("top_list",top_list);
		//리뷰좋은튜터
		List<ClassReviewVO> best_tutor=crs.best_tutor();
		model.addAttribute("best_tutor",best_tutor);
		
		//홈화면 배너뽑아주기
		List<String> banner_list =changePicsService.banner_list();
		if(banner_list.size() > 0) {
			model.addAttribute("firstPic", banner_list.get(0));
			model.addAttribute("secondPic", banner_list.get(1));
			model.addAttribute("thirdPic", banner_list.get(2));
		}
		
		return ".main";
	}
	
}
