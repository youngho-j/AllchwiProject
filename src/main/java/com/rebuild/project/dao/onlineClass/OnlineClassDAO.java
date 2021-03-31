package com.rebuild.project.dao.onlineClass;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.onlineclass.OnlineClassVO;

@Repository
public class OnlineClassDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.OnlineClassMapper";
	public void classInsert(OnlineClassVO vo) {
		session.insert(NAMESPACE + ".insert", vo);
	}
	public List<OnlineClassVO> list(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".list", map);
	}
	public int count(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".count", map);
	}
	public OnlineClassVO getImg(int online_num) {
		return session.selectOne(NAMESPACE + ".getImg", online_num);
	}
	public OnlineClassVO select(int online_num) {
		return session.selectOne(NAMESPACE + ".select", online_num);
	}
	public int update(OnlineClassVO updateVo) {
		return session.update(NAMESPACE + ".update", updateVo);
	}
	public int delete(int online_num) {
		return session.delete(NAMESPACE + ".delete", online_num);
	}
}
