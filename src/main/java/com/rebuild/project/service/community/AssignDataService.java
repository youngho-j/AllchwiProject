package com.rebuild.project.service.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.community.AssignDataDAO;
import com.rebuild.project.vo.community.AssignDataVO;

@Service
public class AssignDataService {
	@Autowired private AssignDataDAO dao;
	
	public int insert(AssignDataVO vo) {
		return dao.insert(vo);
	}
	
	public List<AssignDataVO> data_list(int sub_num){
		return dao.data_list(sub_num);
	}
	
	public AssignDataVO saveFilename(int assigndata_num) {
		return dao.saveFilename(assigndata_num);
	}
}
