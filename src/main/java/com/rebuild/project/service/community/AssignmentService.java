package com.rebuild.project.service.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.community.AssignmentDAO;
import com.rebuild.project.vo.community.AssignmentVO;

@Service
public class AssignmentService {
	@Autowired private AssignmentDAO dao;
	
	public int insert(AssignmentVO vo) {
		return dao.insert(vo);
	}
	
	public List<AssignmentVO> list(int commu_num){
		return dao.list(commu_num);
	}
	
	public int delete(int assign_num) {
		return dao.delete(assign_num);
	}
	
	public AssignmentVO updatelist(int assign_num) {
		return dao.updatelist(assign_num);
	}
	
	public int update(AssignmentVO vo) {
		return dao.update(vo);
	}
	//a 이번주 과제 글 갯수
	public int weekAssign(int commu_num) {
		return dao.weekAssign(commu_num);
	}
}
