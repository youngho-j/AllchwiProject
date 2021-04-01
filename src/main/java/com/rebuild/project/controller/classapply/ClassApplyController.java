package com.rebuild.project.controller.classapply;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.service.classapply.ClassApplyService;
import com.rebuild.project.service.classopen.ClassDateService;
import com.rebuild.project.service.classopen.ClassInfoService;
import com.rebuild.project.service.point.PointService;
import com.rebuild.project.vo.classapply.*;
import com.rebuild.project.vo.classopen.*;
import com.rebuild.project.vo.point.PointVO;

@Controller
public class ClassApplyController {
	@Autowired
	private ClassApplyService classApply_service;
	@Autowired
	private ClassDateService classDate_service;
	@Autowired
	private ClassInfoService classInfo_service;
	@Autowired
	private PointService point_service;
	@Autowired
	private ClassApplyService cas;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	// class_num에 해당하는 수업 신청서 페이지로 이동
	@RequestMapping(value = "/class/apply", method = RequestMethod.GET)
	public String goClassapply(Model model, int class_num, HttpServletRequest req) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		//접속한 사람의 회원번호 받아오기
		int ml_num = (int) req.getSession().getAttribute("ml_num");	
		ClassInfoVO classvo = classInfo_service.getTutorinfo(class_num);
		int class_ml_num = classvo.getMl_num();
		log.debug("접속한 회원번호 = " + String.valueOf(ml_num));
		log.debug("수업개설 튜터 회원번호 = " + String.valueOf(class_ml_num));
		
		if (ml_num == class_ml_num) {
			model.addAttribute("code", "tutor");
			model.addAttribute("init", cas.getInit());
			model.addAttribute("pg", cas.getPg());
			model.addAttribute("pay_method", cas.getPay_method());
			model.addAttribute("name", cas.getBname());
			model.addAttribute("bemail", cas.getBemail());
			model.addAttribute("bname", cas.getBname());
			model.addAttribute("btel", cas.getBtel());
			model.addAttribute("baddr", cas.getBaddr());
			model.addAttribute("bpostcode", cas.getBpostcode());
			return ".classapply.ClassApply";
		} else {
			log.debug("실행2");
			map.put("ml_num", ml_num);
			List<ClassDateVO> classDate_list = classDate_service.select(class_num);
			int pro_num = classvo.getPro_num();
			int point = point_service.getTotal(map);
			model.addAttribute("classDate_list", classDate_list);
			model.addAttribute("point", point);
			model.addAttribute("pro_num", pro_num);
			model.addAttribute("class_num", class_num);
			model.addAttribute("code", "member");
			model.addAttribute("init", cas.getInit());
			model.addAttribute("pg", cas.getPg());
			model.addAttribute("pay_method", cas.getPay_method());
			model.addAttribute("name", cas.getBname());
			model.addAttribute("bemail", cas.getBemail());
			model.addAttribute("bname", cas.getBname());
			model.addAttribute("btel", cas.getBtel());
			model.addAttribute("baddr", cas.getBaddr());
			model.addAttribute("bpostcode", cas.getBpostcode());

			ClassInfoVO vo = classInfo_service.select(class_num);
			req.setAttribute("class_form", vo.getClass_form());
			
			return ".classapply.ClassApply";
		}

	}

	// ClassApply & Payment table insert, ajax callback함수에 success 문자열 전송
	@RequestMapping(value = "/class/applyOk", method = RequestMethod.POST)
	@ResponseBody
	public String classApplyOk(HttpSession session, ClassApplyVO vo, PaymentVO payvo,
			@RequestParam(value = "pay_point", defaultValue = "0") int pay_point) {


		int ml_num = (int) session.getAttribute("ml_num");
		int class_num = payvo.getClass_num();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("date_num", vo.getDate_num());
		map.put("class_num", class_num);
		map.put("ml_num", session.getAttribute("ml_num"));
		int n = classApply_service.check(map);
		if (n > 0) {
			return "already";
		}

		try {
			PointVO pointvo = new PointVO(0, ml_num, pay_point, "결제차감", null, 'u');
			classApply_service.insert(vo, payvo, pointvo);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}

	}

	// 수업신청 성공 시 결과 정보 가져와서 success.jsp로 가져가기..
	@RequestMapping(value = "/class/success", method = RequestMethod.GET)
	public String goSuccess(HttpSession session, int class_num, Model model) {

		int ml_num = (int) session.getAttribute("ml_num");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("ml_num",ml_num);
		map.put("class_num",class_num);
		List<ClassApplyDateInfoVO> list = classApply_service.applyinfo(map);
				
		model.addAttribute("list", list);	
		return ".classapply.success";
	}
}
