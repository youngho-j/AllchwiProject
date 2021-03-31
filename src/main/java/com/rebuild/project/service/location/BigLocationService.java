package com.rebuild.project.service.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.location.BigLocationDAO;
import com.rebuild.project.vo.location.BigLocationVO;

@Service
public class BigLocationService {
	@Autowired
	BigLocationDAO dao;
	
	public int insert(BigLocationVO vo) {
		return dao.insert(vo);
	}
	
	public List<BigLocationVO> blocList(){
		return dao.blocList();
	}
  
}
