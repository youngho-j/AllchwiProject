package com.rebuild.project.service.classapply;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rebuild.project.dao.classapply.*;
import com.rebuild.project.dao.point.PointDAO;
import com.rebuild.project.vo.classapply.*;
import com.rebuild.project.vo.point.PointVO;

@Service
public class ClassApplyService {
	@Autowired private ClassApplyDAO apply_dao;
	@Autowired private PaymentDAO pay_dao;
	@Autowired private PointDAO point_dao;
	
	@Transactional
	public boolean insert(ClassApplyVO vo, PaymentVO payvo, PointVO pointvo) throws Exception{
		
		// Class_Apply 테이블 insert
		apply_dao.insert(vo);
		
		// Payment 테이블 insert
		payvo.setApply_num(vo.getApply_num());
		pay_dao.insert(payvo);
		
		// Point 테이블 insert (사용:u)
		if(pointvo.getPoint()>0) {
			//사용 point가 0보다 클 때 insert
			point_dao.insert(pointvo);
			
		}
	
		return true;
	}
	public List<ClassApplyDateInfoVO> list(HashMap<String, Object> map){
		return apply_dao.list(map);
	}	
	
	public int check(HashMap<String, Object> map) {
		return apply_dao.check(map);
	}
	
	public List<ClassApplyDateInfoVO> applyinfo(HashMap<String, Object> map){
		return apply_dao.applyinfo(map);
	}
}
