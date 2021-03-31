package com.rebuild.project.dao.admin;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.admin.AdminPaymentVO;

@Repository
public class AdminPaymentDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.AdminPaymentMapper";	
	
	public List<AdminPaymentVO> payment_list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".payment_list", map);
	}
	
	public int count(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".count",map);
	}
	
	
}
