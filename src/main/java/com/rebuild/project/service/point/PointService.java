package com.rebuild.project.service.point;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.point.PointDAO;
import com.rebuild.project.vo.point.PointListVO;

@Service
public class PointService {
	@Autowired
	private PointDAO pd;
	//회원번호 받아 포인트 리스트 출력
	public List<PointListVO> pointList(HashMap<String, Object> hm){
		return pd.pointList(hm);
	}
	//현재 보유포인트 계산
	public int getTotal(HashMap<String, Object> hm){
		return pd.getTotal(hm);
	}
	//포인트 사용/적립 횟수 계산
	public int count(HashMap<String, Object> hm) {
		return pd.count(hm);
	}
}
