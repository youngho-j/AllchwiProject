package com.rebuild.project.dao.community;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.community.AssignSubmitVO;

@Repository
public class AssignSubmitDAO {
	@Autowired private SqlSession session;
	private final String NAMESPACE="com.rebuild.mybatis.mapper.AssignSubmitMapper";
	
	public int insert(AssignSubmitVO vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public List<AssignSubmitVO> sub_list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".list",map);
	}
}
