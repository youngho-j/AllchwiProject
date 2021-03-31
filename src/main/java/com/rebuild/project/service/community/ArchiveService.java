package com.rebuild.project.service.community;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.community.ArchiveDAO;
import com.rebuild.project.vo.community.*;

@Service
public class ArchiveService {
	@Autowired
	private ArchiveDAO dao;
	
	public int insert(ArchiveVO vo) {
		return dao.insert(vo);
	}
	
	public int delete(int room_num) {
		return dao.delete(room_num);
	}
	
	public int update(ArchiveVO vo) {
		return dao.update(vo);
	}
	
	public ArchiveVO getInfo(int room_num) {
		return dao.getInfo(room_num);
	}
	
	
	public List<ArchiveVO> list(HashMap<String, Object>map){
		return dao.list(map);
	}
	
	public int count(int commu_num) {
		return dao.count(commu_num);
	}
	
	public ArchiveVO detail(int room_num){
		return dao.detail(room_num);
	}
	
	public int hit(int room_num) {
		return dao.hit(room_num);
	}
	
	public ArchiveVO next(int room_num){
		return dao.next(room_num);
	}
	
	public ArchiveVO prev(int room_num) {
		return dao.prev(room_num);
	}
	
}
