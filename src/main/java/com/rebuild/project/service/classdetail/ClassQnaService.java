package com.rebuild.project.service.classdetail;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.classdetail.ClassQnaDAO;
import com.rebuild.project.vo.classdetail.ClassQnaVO;

@Service
public class ClassQnaService {
	@Autowired private ClassQnaDAO dao;
	
	public int insertQna(ClassQnaVO vo) {
		return dao.insertQna(vo);
	}
	public int insertReply(ClassQnaVO vo) {
		return dao.insertReply(vo);
	}
	public List<ClassQnaVO> qnaList(HashMap<String, Object> map) {
		return dao.qnaList(map);
	}
	public List<ClassQnaVO> commList(HashMap<String, Object> map) {
		return dao.commList(map);
	}
	public int count(HashMap<String, Object> map) {
		return dao.count(map);
	}
}

