package com.rebuild.project.controller.classdetail;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.classapply.PaymentService;
import com.rebuild.project.service.classdetail.*;
import com.rebuild.project.service.classopen.*;
import com.rebuild.project.service.login.KakaoLoginService;
import com.rebuild.project.service.wishlist.WishListService;
import com.rebuild.project.vo.classdetail.*;
import com.rebuild.project.vo.classopen.*;

@Controller
public class ClassDetailController {
	@Autowired
	private ClassDetailService cds;
	@Autowired
	private ClassDateService dates;
	@Autowired
	private ClassReviewService crs;
	@Autowired
	private WishListService wls;
	@Autowired
	private PaymentService ps;
	@Autowired
	private KakaoLoginService kls;

	@GetMapping("/classDetail/detail")
	public ModelAndView detail(int class_num, HttpSession session,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
		ModelAndView mv = new ModelAndView(".classDetail.detail");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("class_num", class_num);
		if(session.getAttribute("ml_num")!=null) {
			int ml_num = (int) session.getAttribute("ml_num");
			// 로그인한 아이디의 wish상태
			map.put("ml_num", ml_num);
			if (wls.getWish(map) != null) {
				mv.addObject("wstatus", true);
			}
			// 수업완료여부(리뷰작성권한)
			if(ps.getFinished(map) != null) {
				int finished = ps.getFinished(map).getClass_finish();
				mv.addObject("finished", finished);
			}
			mv.addObject("ml_num", ml_num);
		}
		
	
		// getdetail
		ClassDetailVO cdv = cds.getDetail(map);
		// 날짜시간
		
		
		List<ClassDateVO> dlist = dates.select(class_num);
		
		// 리뷰리스트,페이징
		map.put("class_num", class_num);
		int totalRowCount = crs.rcount(map);
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 4, 5);
		int startRow = pu.getStartRow() - 1;
		map.put("startRow", startRow);
		List<ClassReviewVO> rlist = crs.reviewList(map);
		if(crs.rate_avg(class_num)!=null) {
			ClassReviewVO rating= crs.rate_avg(class_num);
			mv.addObject("rating", rating);
		}

		mv.addObject("cdv", cdv);
		mv.addObject("dlist", dlist);
		mv.addObject("rlist", rlist);
		mv.addObject("rpu", pu);
		mv.addObject("class_num", class_num);
		mv.addObject("appkey", kls.getAppKey());
		
		return mv;
	}

	// 인표 상세페이지 이동 detail2
	@GetMapping("/classDetail/detail2")
	public ModelAndView detail2(int class_num, HttpSession session,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
		ModelAndView mv = new ModelAndView("/classDetail/detail");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("class_num", class_num);
		if(session.getAttribute("ml_num")!=null) {
			int ml_num = (int) session.getAttribute("ml_num");
			// 로그인한 아이디의 wish상태
			map.put("ml_num", ml_num);
			if (wls.getWish(map) != null) {
				mv.addObject("wstatus", true);
			}
			// 수업완료여부(리뷰작성권한)
			if(ps.getFinished(map) != null) {
				int finished = ps.getFinished(map).getClass_finish();
				mv.addObject("finished", finished);
			}
			mv.addObject("ml_num", ml_num);
		}
		
	
		// getdetail
		ClassDetailVO cdv = cds.getDetail(map);
		// 날짜시간
		
		
		List<ClassDateVO> dlist = dates.select(class_num);
		
		// 리뷰리스트,페이징
		map.put("class_num", class_num);
		int totalRowCount = crs.rcount(map);
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 4, 5);
		int startRow = pu.getStartRow() - 1;
		map.put("startRow", startRow);
		List<ClassReviewVO> rlist = crs.reviewList(map);
		if(crs.rate_avg(class_num)!=null) {
			ClassReviewVO rating= crs.rate_avg(class_num);
			mv.addObject("rating", rating);
		}

		mv.addObject("cdv", cdv);
		mv.addObject("dlist", dlist);
		mv.addObject("rlist", rlist);
		mv.addObject("rpu", pu);
		mv.addObject("class_num", class_num);
		mv.addObject("appkey", kls.getAppKey());
		
		return mv;
	}
}
