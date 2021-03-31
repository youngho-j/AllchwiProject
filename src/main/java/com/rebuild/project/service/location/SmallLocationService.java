package com.rebuild.project.service.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.location.SmallLocationDAO;
import com.rebuild.project.vo.location.SmallLocationVO;

@Service
public class SmallLocationService {
	@Autowired
	private SmallLocationDAO dao;
	
	public int insert(SmallLocationVO slocVo) {
		return dao.insert(slocVo);
	}
	
	public List<SmallLocationVO> slocList(int bloc_num){
		return dao.slocList(bloc_num);
	}
}
