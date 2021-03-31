package com.rebuild.project.dao.community;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.community.*;

@Repository
public class ArchiveDAO {
	@Autowired
	private SqlSession session;
	private String NAMESPACE="com.rebuild.mybatis.mapper.CommunityArchiveMapper";
	
	public int insert(ArchiveVO vo) {
		return session.insert(NAMESPACE+".insert", vo);
	}
	
	public int delete(int room_num) {
		return session.delete(NAMESPACE+".delete", room_num);
	}
	
	public int update(ArchiveVO vo) {
		return session.update(NAMESPACE+".update", vo);
	}
	
	public ArchiveVO getInfo(int room_num) {
		return session.selectOne(NAMESPACE+".getInfo", room_num);
	}
	
	
	public List<ArchiveVO> list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".list",map);
	}
	
	public int count(int commu_num) {
		return session.selectOne(NAMESPACE+".count",commu_num);
	}
	
	public ArchiveVO detail(int room_num){
		return session.selectOne(NAMESPACE+".detail", room_num);
	}
	
	public int hit(int room_num) {
		return session.update(NAMESPACE+".hit", room_num);
	}
	
	public ArchiveVO next(int room_num){
		return session.selectOne(NAMESPACE+".next", room_num);
	}
	
	public ArchiveVO prev(int room_num) {
		return session.selectOne(NAMESPACE+".prev", room_num);
	}
	
	
	
}
