package com.rebuild.project.service.classapply;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	private String init;
	private String pg;
	private String pay_method;
	private String name;
	private String bemail;
	private String bname;
	private String btel;
	private String baddr;
	private String bpostcode;
	
	public ClassApplyDAO getApply_dao() {
		return apply_dao;
	}

	public PaymentDAO getPay_dao() {
		return pay_dao;
	}

	public PointDAO getPoint_dao() {
		return point_dao;
	}

	public String getInit() {
		return init;
	}

	public String getPg() {
		return pg;
	}

	public String getPay_method() {
		return pay_method;
	}

	public String getName() {
		return name;
	}

	public String getBemail() {
		return bemail;
	}

	public String getBname() {
		return bname;
	}

	public String getBtel() {
		return btel;
	}

	public String getBaddr() {
		return baddr;
	}

	public String getBpostcode() {
		return bpostcode;
	}

	@Value("${imp.init}")
	public void setInit(String init) {
		this.init = init;
	}
	
	@Value("${imp.pg}")
	public void setPg(String pg) {
		this.pg = pg;
	}
	
	@Value("${imp.pay_method}")
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	
	@Value("${imp.name}")
	public void setName(String name) {
		this.name = name;
	}
	
	@Value("${imp.bemail}")
	public void setBemail(String bemail) {
		this.bemail = bemail;
	}
	
	@Value("${imp.bname}")
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	@Value("${imp.btel}")
	public void setBtel(String btel) {
		this.btel = btel;
	}
	
	@Value("${imp.baddr}")
	public void setBaddr(String baddr) {
		this.baddr = baddr;
	}
	@Value("${imp.bpostcode}")
	public void setBpostcode(String bpostcode) {
		this.bpostcode = bpostcode;
	}
	
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
