package com.rebuild.project.dao.classopen;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.classopen.ClassInfoVO;
import com.rebuild.project.vo.myclasslist.MyClassListVO;

@Repository
public class ClassInfoDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.ClassInfoMapper";
	
	public int insert(ClassInfoVO vo) {
		return session.insert(NAMESPACE + ".insert",vo);
	}
	// 검색 조건에 맞는 전체 글 list
	public List<ClassInfoVO> list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".list",map);
	}
	// 검색 조건에 맞는 전체 글 갯수
	public int count(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".count",map);
	}
	// 해당 수업의 튜터 프로필 번호
	public ClassInfoVO getTutorinfo(int class_num) {
		return session.selectOne(NAMESPACE+".getTutorinfo",class_num);
	}
	public ClassInfoVO getInfo(int class_num) {
		return session.selectOne(NAMESPACE+".getInfo",class_num);
	}
	
	// 내수업 목록 하나 가져오기.
	public HashMap<String, Object> getMyBoardInfo(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".myBoard_list", map);
	}

	public List<ClassInfoVO> getClassTitle(int ml_num) {
		return session.selectList(NAMESPACE + ".title_list", ml_num);
	}

	public ClassInfoVO select(int class_num) {
		return session.selectOne(NAMESPACE + ".select", class_num);
	}
	public List<MyClassListVO> getMyList(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE+".myClassList", map);
	}
	public int countMy(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".countFinish", map);
	}
	public int statusUpdate(HashMap<String, Object> map) {
		return session.update(NAMESPACE + ".statusUpdate",map);
	}
	public int update(ClassInfoVO vo) {
		return session.update(NAMESPACE + ".infoUpdate", vo);
	}
	public int salesUpdate(HashMap<String, Object> map) {
		return session.update(NAMESPACE +".salesUpdate",map);
	}
	public int classDelete(HashMap<String, Object> map) {
		return session.update(NAMESPACE +".classDelete",map);
	}
		
}
