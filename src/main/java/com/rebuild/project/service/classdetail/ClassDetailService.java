package com.rebuild.project.service.classdetail;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.classdetail.ClassDetailDAO;
import com.rebuild.project.vo.classdetail.ClassDetailVO;

@Service
public class ClassDetailService {
	@Autowired private ClassDetailDAO  dao;
	
	public ClassDetailVO getDetail(HashMap<String, Object> map) {
		return dao.getDetail(map);
	}
	
	public List<ClassDetailVO> topFive() {
		return dao.topFive();
	}
}
