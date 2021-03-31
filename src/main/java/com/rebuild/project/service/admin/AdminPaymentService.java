package com.rebuild.project.service.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.admin.AdminPaymentDAO;
import com.rebuild.project.vo.admin.AdminPaymentVO;

@Service
public class AdminPaymentService {
	@Autowired
	private AdminPaymentDAO dao;
	
	public List<AdminPaymentVO> payment_list(HashMap<String, Object> map) {
		return dao.payment_list(map);
	}
	
	public int count(HashMap<String, Object> map) {
		return dao.count(map);
	}
}
