package com.rebuild.project.service.classopen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.classopen.CurriculumDAO;
import com.rebuild.project.vo.classopen.CurriculumVO;

@Service
public class CurriculumService {
	@Autowired
	private CurriculumDAO dao;
	
	public int insert(CurriculumVO vo) {
		return dao.insert(vo);
	}
}
