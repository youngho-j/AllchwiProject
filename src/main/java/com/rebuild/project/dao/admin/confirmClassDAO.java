package com.rebuild.project.dao.admin;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.admin.*;

@Repository
public class confirmClassDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.AdminConfirmClassMapper";	
	
	public List<ConfirmClassVO> confirm_list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".confirm_list",map);
	}
	
	
	public int count(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".count",map);
	}
	
	
	public int acceptClass(int class_num) {
		return session.update(NAMESPACE+".acceptClass", class_num);
	}
	
	public int denyClass(int class_num) {
		return session.update(NAMESPACE+".denyClass", class_num);
	}
	
	
	public ClassDetailVO detail_list(int class_num){
		return session.selectOne(NAMESPACE+".class_detail", class_num);
	}
	
	
	public List<CertiVO> certi_list(int class_num){
		return session.selectList(NAMESPACE+".certi_list", class_num);
	}
	
	public List<CurriVO> curri_list(int class_num){
		return session.selectList(NAMESPACE+".curri_list", class_num);
	}
	
	
	
}
