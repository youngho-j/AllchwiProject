package com.rebuild.project.dao.login;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.login.*;


@Repository
public class MemberInfoDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.MemberInfoMapper";
	
	//회원탈퇴정보 업데이트
	public int UpdateSignout(HashMap<String, Object> hm) {
		return session.update(NAMESPACE + ".updateSignout", hm);
	}
	//회원가입시 정보 삽입, 회원가입시에는 회원번호 로그인번호 이미지번호 이름 등록일만
	public int SignIn(MemberInfoVO miv) {
		return session.insert(NAMESPACE + ".addInfo", miv);
	}
	//3 세션에 담긴 회원번호로 회원정보 조회
	public ProfileVO selectInfo(int ml_num) {
		return session.selectOne(NAMESPACE + ".selectInfo", ml_num);
	}
	//4 회원번호로 회원정보(별명, 인사말) 업데이트
	public int UpdateInfo(HashMap<String, Object> hm) {
		return session.update(NAMESPACE + ".updateInfo", hm);
	}
	//5 회원번호로 이미지테이블 이미지 넘버 검색
	public int selectProNum(int num) {
		return session.selectOne(NAMESPACE + ".selectProNum", num);
	}
}
