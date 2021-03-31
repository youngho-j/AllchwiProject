package com.rebuild.project.dao.classapply;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.classapply.*;

@Repository
public class ClassApplyDAO {
	@Autowired private SqlSession session;
	private String NAMESPACE="com.rebuild.mybatis.mapper.ClassApplyMapper";
	
	public int insert(ClassApplyVO vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public List<ClassApplyDateInfoVO> list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".list",map);
	}
	
	public int check(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".check",map);
	}
	
	public List<ClassApplyDateInfoVO> applyinfo(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".applyinfo",map);
	}
}
