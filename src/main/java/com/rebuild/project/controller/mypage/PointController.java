package com.rebuild.project.controller.mypage;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.point.PointService;
import com.rebuild.project.vo.point.PointListVO;

@Controller
public class PointController {
	@Autowired
	private PointService ps;
	
	@RequestMapping("/mypage/pointForm")
	public String goPoint(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String pointType, HttpSession session, Model model, HashMap<String, Object> hm) {
		//회원번호 map에 담기
		hm.put("ml_num", session.getAttribute("ml_num"));
		if(pointType != null || pointType != "") {
			hm.put("point_type", pointType);			
		}
		//총 포인트 계산 
		int total = ps.getTotal(hm);
		//총 포인트 사용/적립 횟수 계산
		int totalRowCount = ps.count(hm);
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 5, 5);
		//페이지유틸에서 계산한 결과 map에 담기(목록 출력시 한화면에 보이는 첫 포인트부터 마지막 포인트 번호) 
		hm.put("startRow", pu.getStartRow() - 1);
		hm.put("endRow", pu.getEndRow());
		//리스트에 서비스에서 넣어준 값 담기
		List<PointListVO> list = ps.pointList(hm);
		model.addAttribute("list", list);
		model.addAttribute("total", total);
		model.addAttribute("pu", pu);
		return ".mypage.mypoint";
	}
}
