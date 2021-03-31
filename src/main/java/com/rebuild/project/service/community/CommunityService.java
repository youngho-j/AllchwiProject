package com.rebuild.project.service.community;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.community.CommunityDAO;
import com.rebuild.project.vo.community.CommunityVO;

@Service
public class CommunityService {
	@Autowired
	private CommunityDAO dao;

	public int insert(HashMap<String, Object> map) throws Exception {
		return dao.insert(map);
	}

	public int selectChk(HashMap<String, Object> map) {
		return dao.selectChk(map);
	}

	public CommunityVO goCommu(HashMap<String, Object> map) {
		return dao.goCommu(map);
	}
	
	
}
