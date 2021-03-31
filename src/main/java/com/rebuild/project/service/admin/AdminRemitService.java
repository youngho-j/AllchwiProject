package com.rebuild.project.service.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rebuild.project.dao.admin.AdminRemitDAO;
import com.rebuild.project.vo.admin.*;

@Service
public class AdminRemitService {
	@Autowired
	private AdminRemitDAO dao;
	
	public List<AdminRemitVO> remit_list(HashMap<String, Object> map){
		return dao.remit_list(map);
	}
	
	public int count(HashMap<String, Object> map) {
		return dao.count(map);
	}
	
	@Transactional
	public int acceptAndSales(int pay_num,SalesVO vo) throws Exception{
		dao.accpet(pay_num);	
		dao.insertSales(vo);
		return 1;
	}
	
	
}
