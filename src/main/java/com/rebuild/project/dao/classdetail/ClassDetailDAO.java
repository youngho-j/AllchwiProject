package com.rebuild.project.dao.classdetail;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.classdetail.ClassDetailVO;

@Repository
public class ClassDetailDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.ClassDetailMapper";	
	public ClassDetailVO getDetail(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".getDetail", map);
	}
	
	
	public List<ClassDetailVO> topFive() {
		return session.selectList(NAMESPACE+".topFive");
	}
	
}
