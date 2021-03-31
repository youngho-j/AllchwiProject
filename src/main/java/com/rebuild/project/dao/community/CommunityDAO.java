package com.rebuild.project.dao.community;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.community.CommunityVO;

@Repository
public class CommunityDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.CommunityMapper";
	public int insert(HashMap<String, Object> map) {
		return session.insert(NAMESPACE + ".insert", map);
	}
	public int selectChk(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".selectChk", map);
	}
	public CommunityVO goCommu(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".goCommu",map);
	}
	
}
