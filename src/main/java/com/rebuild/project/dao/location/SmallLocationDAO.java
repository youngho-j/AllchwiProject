package com.rebuild.project.dao.location;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.location.SmallLocationVO;

@Repository
public class SmallLocationDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.SmallLocationMapper";
	
	public int insert(SmallLocationVO slocVo) {
		return session.insert(NAMESPACE + ".insert",slocVo );
	}
	
	public List<SmallLocationVO> slocList(int bloc_num){
		return session.selectList(NAMESPACE+".sloc_list",bloc_num);
	}
}
