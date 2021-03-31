package com.rebuild.project.service.classapply;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.classapply.PaymentDAO;
import com.rebuild.project.vo.classapply.PaymentVO;

@Service
public class PaymentService {
	@Autowired private PaymentDAO dao;
	
	public int insert(PaymentVO vo) {
		return dao.insert(vo);
	}

	public int finishUpdate(HashMap<String, Object> map)throws Exception {
		return dao.finishUpdate(map);
	}
	public PaymentVO getFinished(HashMap<String, Object> map) {
		return dao.getFinished(map);
	}
}
