package com.rebuild.project.dao.community;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.community.AssignmentVO;

@Repository
public class AssignmentDAO {
	@Autowired private SqlSession session;
	private final String NAMESPACE="com.rebuild.mybatis.mapper.AssignmentMapper";
	
	public int insert(AssignmentVO vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public List<AssignmentVO> list(int commu_num){
		return session.selectList(NAMESPACE+".list",commu_num);
	}
	
	public int delete(int assign_num) {
		return session.delete(NAMESPACE+".delete",assign_num);
	}
	
	public AssignmentVO updatelist(int assign_num) {
		return session.selectOne(NAMESPACE+".updatelist",assign_num);
	}
	
	public int update(AssignmentVO vo) {
		return session.update(NAMESPACE+".update",vo);
	}
	//a 이번주 과제 글 갯수
	public int weekAssign(int commu_num) {
		return session.selectOne(NAMESPACE + ".weekAssign", commu_num);
	}
}
