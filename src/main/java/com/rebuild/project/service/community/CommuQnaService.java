package com.rebuild.project.service.community;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.community.CommuQnaDAO;
import com.rebuild.project.vo.community.CommuQnaVO;
@Service
public class CommuQnaService {
	@Autowired private CommuQnaDAO dao;
	
	public int insertQna(CommuQnaVO vo) {
		return dao.insertQna(vo);
	}
	public int insertReply(CommuQnaVO vo) {
		return dao.insertReply(vo);
	}
	public List<CommuQnaVO> qnaList(HashMap<String, Object> map) {
		return dao.qnaList(map);
	}
	public List<CommuQnaVO> commList(HashMap<String, Object> map) {
		return dao.commList(map);
	}
	public int count(HashMap<String, Object> map) {
		return dao.count(map);
	}
	public int replyAuth(HashMap<String, Object> map) {
		return dao.replyAuth(map);
	}
	public int editQna(CommuQnaVO vo) {
		return dao.editQna(vo);
	}
	public int delQna(int qna_num) {
		return dao.delQna(qna_num);
	}
}
