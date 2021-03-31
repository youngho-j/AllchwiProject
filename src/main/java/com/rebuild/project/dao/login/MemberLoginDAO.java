package com.rebuild.project.dao.login;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.login.MemberLoginVO;

@Repository
public class MemberLoginDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.MemberLoginMapper";
	//0  회원가입
	public int join(MemberLoginVO mlv) {
		return session.insert(NAMESPACE + ".member_join", mlv);
	}
	//1 id, 카카오유저 번호 값으로 회원 조회
	public MemberLoginVO idCheck(HashMap<String, Object> hm) {
		return session.selectOne(NAMESPACE + ".idCheck", hm);
	}
	//1-1 카카오유저 고유아이디 값으로 회원 조회
	public MemberLoginVO kakaoIdCheck(HashMap<String, Object> hm) {
		return session.selectOne(NAMESPACE + ".kakaoIdCheck", hm);
	}
	//1-2 아이디로 전체 회원 아이디 조회
	public List<MemberLoginVO> allIdCheck(HashMap<String, Object> hm) {
		return session.selectList(NAMESPACE + ".allIdCheck", hm);
	}
	//2 id값으로 회원 비밀번호 검색하여 변경
	public int searchPwd(HashMap<String, Object> hm) {
		return session.update(NAMESPACE + ".searchPwd", hm);
	}
	//3 id, pwd값으로 회원 비밀번호 일치 여부 확인
	public MemberLoginVO checkPwd(HashMap<String, Object> hm) {
		return session.selectOne(NAMESPACE + ".checkPwd", hm);
	}
	//4 id, 이전pwd값으로 회원 비밀번호 업데이트
	public int changePwd(HashMap<String, Object> hm) {
		return session.update(NAMESPACE + ".changePwd", hm);
	}
	//5 로그인정보와 일치하는지 확인
	public MemberLoginVO loginCheck(MemberLoginVO mlv) {
		return session.selectOne(NAMESPACE + ".loginCheck", mlv);
	}
	//6 로그아웃 -> session.invalidate
	public void logout(HttpSession session) {}
	//7 회원번호 사용하여 회원정보 출력
	public MemberLoginVO loginInfo(HashMap<String, Object> hm) {
		return session.selectOne(NAMESPACE + ".loginInfo", hm);
	}
	//8 회원번호 사용하여 탈퇴여부 업데이트
	public int signout(HashMap<String, Object> hm) {
		return session.update(NAMESPACE + ".signout", hm);
	}
	public void tutorAuth(int ml_num) {
		session.update(NAMESPACE+".tutorAuth",ml_num);
	}
}
