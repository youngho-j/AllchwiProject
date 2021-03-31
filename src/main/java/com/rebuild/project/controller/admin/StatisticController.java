package com.rebuild.project.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.dao.admin.StatisticDAO;
import com.rebuild.project.vo.admin.Statistic1VO;
import com.rebuild.project.vo.admin.Statistic2VO;
import com.rebuild.project.vo.admin.Statistic3VO;

@Controller
public class StatisticController {
	@Autowired
	private StatisticDAO dao;
	
	
	@GetMapping("/admin/statistic1")
	public String statstic() {
		return ".admin.statistic1";
	}
	
	@GetMapping("/admin/statisticAjax1")
	@ResponseBody
	public List<Statistic1VO> statisticAjax(int thisyear, int nextyear){
		List<Statistic1VO> list = dao.list(thisyear,nextyear);
		return list;
	}
	
	
	@GetMapping("/admin/statistic2")
	public String statstic2() {
		return ".admin.statistic2";
	}
	
	@GetMapping("/admin/statisticAjax2")
	@ResponseBody
	public List<Statistic2VO> statisticAjax2(){
		List<Statistic2VO> top_statlist =  dao.top_statlist();		
		return top_statlist;
	}


	@GetMapping("/admin/statistic3")
	public String statstic3() {
		return ".admin.statistic3";
	}
	
	
	@GetMapping("/admin/statisticAjax3")
	@ResponseBody
	public List<Statistic3VO> statisticAjax3(){
		List<Statistic3VO> cate_list =  dao.cate_statlist();
		return cate_list;
	}
	
	
}
