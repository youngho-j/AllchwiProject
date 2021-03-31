package com.rebuild.project.dao.receiveTuition;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.receiveTuition.*;

@Repository
public class ReceiptDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.ReceiptMapper";	
	
	public List<ReceiptVO> receipt_list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".receipt_list",map);
	}
	
	public int count() {
		return session.selectOne(NAMESPACE+".count");
	}
	
	public int insertRemit(InsertRemitVO vo) {
		return session.insert(NAMESPACE+".insertRemit", vo);
	}
	
	public int updateRemit(int pay_num) {
		return session.update(NAMESPACE+".updateRemit", pay_num);
	}
	
	
	
	
}


