package com.rebuild.project.dao.admin;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.admin.*;

@Repository
public class ChangePicsDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.AdminPicsChangeMapper";	
	
	public int picsInsert(MainPicsVO vo) {
		return session.insert(NAMESPACE+".picsInsert", vo);
	}
	
	public List<PicsListVO> pics_list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".pics_list",map);
	}
	
	public int count () {
		return session.selectOne(NAMESPACE+".count");
	}
	
	
	public List<String> banner_list() {
		return session.selectList(NAMESPACE+".banner_list");
	}
	
	public int reset() {
		return session.update(NAMESPACE+".reset");		
	}
	
	public int confirmPics1(String firstPic) {
		return session.update(NAMESPACE+".confirmPics1", firstPic);		
	}
	
	public int confirmPics2(String secondPic) {
		return session.update(NAMESPACE+".confirmPics2", secondPic);		
	}
	
	public int confirmPics3(String thirdPic) {
		return session.update(NAMESPACE+".confirmPics3", thirdPic);		
	}
	
	
	
	
}
