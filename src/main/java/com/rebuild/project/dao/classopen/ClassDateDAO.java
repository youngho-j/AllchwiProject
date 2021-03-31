package com.rebuild.project.dao.classopen;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.classopen.ClassDateVO;

@Repository
public class ClassDateDAO {
	@Autowired private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.ClassDateMapper";
	
	public List<ClassDateVO> list(int class_num){
		return session.selectList(NAMESPACE+".list",class_num);
	}

	public int insert(ClassDateVO vo) {
		return session.insert(NAMESPACE + ".insert",vo);
	}

	public int update(int ref) {
		return session.update(NAMESPACE+".refUpdate",ref);
	}

	public List<ClassDateVO> select(int class_num) {
		return session.selectList(NAMESPACE+".dateArray",class_num);
	}

	public int deleteDate(Integer date_num) {
		return session.delete(NAMESPACE+".delDate",date_num);
	}
}
