package com.rebuild.project.dao.classdetail;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.classdetail.ClassQnaVO;

@Repository
public class ClassQnaDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.ClassQnaMapper";	
	
	public int insertQna(ClassQnaVO vo) {
		return session.insert(NAMESPACE+".insertQna", vo);
	}
	public int insertReply(ClassQnaVO vo) {
		return session.insert(NAMESPACE+".insertReply", vo);
	}
	public List<ClassQnaVO> qnaList(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE+".qnalist", map);
	}
	public List<ClassQnaVO> commList(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE+".commlist", map);
	}
	public int count(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".count",map);
	}
	
}
