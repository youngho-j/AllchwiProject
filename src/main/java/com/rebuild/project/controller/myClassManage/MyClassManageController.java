package com.rebuild.project.controller.myClassManage;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.myclassmanage.MyClassManageService;
import com.rebuild.project.vo.classopen.ClassInfoVO;
import com.rebuild.project.vo.myclassmanage.MyClassManageVO;

@Controller
public class MyClassManageController {
	@Autowired
	private MyClassManageService mcms;
	
	@RequestMapping("/myClass/myClassManage")
	public String goMyClassMagnage(HttpSession session, Model model,
			@RequestParam(value="class_num", defaultValue = "0")int class_num,
			@RequestParam(value="pageNum", defaultValue = "1")int pageNum) {
		//a 변수를 담기 위해 hashmap 선언
		HashMap<String, Object> hm = new HashMap<String, Object>();
		//세션에서 회원번호 얻어오기
		int ml_num = (int)session.getAttribute("ml_num");
		//해당 회원(튜터)의 수업 목록을 얻어오기 위해 hashmap에 담아줌
		hm.put("ml_num", ml_num);
		//튜터번호를 구분하기 위해 hashmap에 담아줌
		hm.put("class_num", class_num);
		//회원번호 및 튜터 번호를 사용하여 신청서 목록 갯수를 얻어옴 
		int totalRowCount = mcms.applyCounting(hm);
		//페이징 처리 페이지번호, 총 리스트 갯수, 화면에 보여줄 목록 갯수, 페이지 수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 5, 5);
		//리스트에는 0번부터 시작하므로 -1로 0번째 부터 가져옴
		int startRow = pu.getStartRow()-1;
		//해당 페이지의 출력할 목록의 갯수를 알아내기 위해 hashmap에 담아줌
		hm.put("startRow", startRow);
		List<MyClassManageVO> list = mcms.searchApply(hm);
		//해당 회원(튜터)의 목록 가져오기
		List<ClassInfoVO> myClass = mcms.searchMyClass(ml_num);
		model.addAttribute("list", list);
		model.addAttribute("myClass", myClass);
		model.addAttribute("class_num", class_num);
		model.addAttribute("pu", pu);
		return ".myClass.myClassManage";
	}
}
