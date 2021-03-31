package com.rebuild.project.service.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.admin.manageClassDAO;
import com.rebuild.project.vo.admin.ManageClassVO;

@Service
public class manageClassService {
	@Autowired
	private manageClassDAO dao;
	
	public List<ManageClassVO> manage_list(HashMap<String, Object> map){
		return dao.manage_list(map);
	}
	
	
	public int count(HashMap<String, Object> map) {
		return dao.count(map);
	}
	
}
