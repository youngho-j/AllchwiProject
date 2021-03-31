package com.rebuild.project.service.community;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.community.AssignSubmitDAO;
import com.rebuild.project.vo.community.AssignSubmitVO;

@Service
public class AssignSubmitService {
	@Autowired private AssignSubmitDAO dao;
	
	public int insert(AssignSubmitVO vo) {
		return dao.insert(vo);
	}
	
	public List<AssignSubmitVO> sub_list(HashMap<String, Object> map){
		return dao.sub_list(map);
	}
}
