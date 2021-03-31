package com.rebuild.project.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.admin.StatisticDAO;
import com.rebuild.project.vo.admin.*;

@Service
public class AdminStatisticService {
	@Autowired
	private StatisticDAO dao;
	
	public List<Statistic1VO> list(int thisyear, int nextyear) {
		return dao.list(thisyear, nextyear);
	}
	
	public List<Statistic2VO> top_statlist(){
		return dao.top_statlist();
	}
	
	
	public List<Statistic3VO> cate_statlist(){
		return dao.cate_statlist();
	}
	
	
	
	
}
