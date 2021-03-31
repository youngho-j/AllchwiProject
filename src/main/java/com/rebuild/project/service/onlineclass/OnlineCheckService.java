package com.rebuild.project.service.onlineclass;

import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.onlineClass.OnlineCheckDAO;
import com.rebuild.project.vo.onlineclass.OnlineCheckVO;

@Service
public class OnlineCheckService {
	@Autowired
	private OnlineCheckDAO dao;

	public int select(OnlineCheckVO vo) {
		return dao.select(vo);
	}

	public void insert(OnlineCheckVO vo) throws SQLException{
		dao.insert(vo);
	}

	public int timeSelect(HashMap<String, Object> map) {
		return dao.timeSelect(map);
	}
	
}
