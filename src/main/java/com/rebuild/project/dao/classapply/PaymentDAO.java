package com.rebuild.project.dao.classapply;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.classapply.PaymentVO;

@Repository
public class PaymentDAO {
	@Autowired private SqlSession session;
	private final String NAMESPACE="com.rebuild.mybatis.mapper.PaymentMapper";
	
	public int insert(PaymentVO vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}

	public int finishUpdate(HashMap<String, Object> map) {
		return session.update(NAMESPACE + ".finishUpdate", map);
	}
	public PaymentVO getFinished(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".getFinished", map);
	}
}
